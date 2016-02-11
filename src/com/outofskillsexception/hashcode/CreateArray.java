package com.outofskillsexception.hashcode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.outofskillsexception.hashcode.writter.Writter;

public class CreateArray {
	private ArrayList[][] tab;

	private Drone[] drones;
	private Item[] items;
	private Warehouse[] warehouses;
	private Commande[] commandes;
	private int deadline;

	public CreateArray(int x, int y, int deadline, Drone[] drones, Item[] items, Warehouse[] warehouses,
			Commande[] commandes) {
		tab = new ArrayList[x][y];
		this.deadline = deadline;
		this.drones = drones;
		this.items = items;
		this.warehouses = warehouses;
		this.commandes = commandes;
	}

	public void move(Object o, int x, int y) {
		for (int i = 0; i < tab[0].length; i++) {
			for (int j = 0; j < tab[1].length; j++) {
				if (tab[i][j].contains(o)) {
					tab[x][y].add(o);
					if (tab[i][j].isEmpty())
						tab[i][j] = null;
					else
						tab[i][j].remove(o);
				}
			}
		}
	}

	public void run() {

		for (int e = 0; e < deadline; e++) {
			boolean end = true;

			for (Commande com : commandes) {
				end &= com.isFinished();
			}

			if (!end) {
				for (int i = 0; i < drones.length; i++) {
					drones[i].update();
					if (drones[i].isFree()) {
						int posX = (int) drones[i].getPos().getX();
						int posY = (int) drones[i].getPos().getY();

						int[] pos = { posX, posY };

						Warehouse warhouse = null;
						Commande commande = null;

						for (Warehouse w : warehouses) {
							int[] posW = w.getPos();

							if (posW[0] == pos[0] && posW[1] == pos[1]) {
								warhouse = w;
							}
						}

						for (Commande c : commandes) {
							int[] posC = c.getPosition();

							if (posC[0] == pos[0] && posC[1] == pos[1]) {
								commande = c;
							}
						}

						if (warhouse != null) {
							for (Commande c : commandes) {
								for (Item item : c.getDemmande().keySet()) {
									if (drones[i].isFree() && c.getDemmande().get(item) > 0
											&& warhouse.getItems().get(item) != null
											&& warhouse.getItems().get(item) > 0) {
										int pickup = (c.getDemmande().get(item) > warhouse.getItems().get(item))
												? warhouse.getItems().get(item) : c.getDemmande().get(item);

										for (int j = 0; j < pickup; j++) {
											drones[i].addItem(item);
										}

										while (drones[i].getCurrentWeight() > drones[i].getWeight()) {
											pickup--;
											drones[i].removeItems(item);
										}

										drones[i].setTimeOut(1);

										Writter.load(i, warhouse.getId(), item.getId(), pickup);
									}
								}
							}

							if (drones[i].isFree()) {
								for (Commande c : commandes) {
									for (Item item : c.getDemmande().keySet()) {
										if (drones[i].isFree() && c.getDemmande().get(item) > 0
												&& drones[i].getItems().get(item) != null
												&& drones[i].getItems().get(item) > 0) {
											int delivry = (c.getDemmande().get(item) > drones[i].getItems().get(item))
													? drones[i].getItems().get(item) : c.getDemmande().get(item);

											for (int j = 0; j < delivry; j++) {
												c.delivry(item);
												drones[i].removeItems(item);
											}

											float distance = (float) Math.sqrt(
													Math.pow(drones[i].getPos().getX() - c.getPosition()[0], 2) + Math
															.pow(drones[i].getPos().getY() - c.getPosition()[1], 2));

											drones[i].setTimeOut(distance + 1);

											Writter.delivry(i, c.getId(), item.getId(), delivry);
										}
									}
								}
							}

							if (drones[i].isFree()) {
								drones[i].setTimeOut(1);
								Writter.wait(i, 1);
							}

						} else if (commande != null) {
							for (Item item : commande.getDemmande().keySet()) {
								if (drones[i].isFree() && commande.getDemmande().get(item) > 0
										&& drones[i].getItems().get(item) > 0) {
									int delivry = (commande.getDemmande().get(item) > drones[i].getItems().get(item))
											? drones[i].getItems().get(item) : commande.getDemmande().get(item);

									for (int j = 0; j < delivry; j++) {
										commande.delivry(item);
										drones[i].removeItems(item);
									}

									drones[i].setTimeOut(1);

									Writter.delivry(i, commande.getId(), item.getId(), delivry);
								}
							}

							if (drones[i].isFree()) {
								for (Warehouse w : warehouses) {
									for (Item item : commande.getDemmande().keySet()) {
										if (drones[i].isFree() && commande.getDemmande().get(item) > 0
												&& w.getItems().get(item) > 0) {
											int pickup = (commande.getDemmande().get(item) > w.getItems().get(item))
													? w.getItems().get(item) : commande.getDemmande().get(item);

											for (int j = 0; j < pickup; j++) {
												drones[i].addItem(item);
											}

											while (drones[i].getCurrentWeight() > drones[i].getWeight()) {
												pickup--;
												drones[i].removeItems(item);
											}

											float distance = (float) Math
													.sqrt(Math.pow(drones[i].getPos().getX() - w.getPos()[0], 2)
															+ Math.pow(drones[i].getPos().getY() - w.getPos()[1], 2));

											drones[i].setTimeOut(1);

											Writter.load(i, w.getId(), item.getId(), pickup);
										}
									}
								}
							}

							if (drones[i].isFree()) {
								drones[i].setTimeOut(1);
								Writter.wait(i, 1);
							}
						}
						drones[i].setFree(false);
					}
				}
			} else {
				try {
					Writter.save(new File("out"));
					return;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public String detect(int x, int y) {
		return this.tab.getClass().getName().toString();
	}
}
