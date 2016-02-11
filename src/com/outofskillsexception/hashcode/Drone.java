package com.outofskillsexception.hashcode;

import java.awt.Point;
import java.util.*;

public class Drone {
	private int weight, id;
	private float timeOut;
	private Point pos;
	private HashMap<Item, Integer> item = new HashMap<Item, Integer>();
	private boolean free = false;

	public Drone(int id, int weight, int x, int y) {
		// TODO Auto-generated constructor stub
		this.weight = weight;
		this.id = id;
		this.pos = new Point(x, y);
	}

	public void setTimeOut(float i) {
		timeOut = i;
	}

	public void update() {
		timeOut -= 1;
		if (timeOut <= 0) {
			setFree(true);
		}
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(int x, int y) {
		this.pos.setLocation(x, y);
		;
	}

	public HashMap<Item, Integer> getItems() {
		return item;
	}

	public boolean haveItem(Item i) {
		return item.containsKey(i);
	}

	public boolean removeItems(Item i) {
		int qte = 0;
		if(this.item.containsKey(i))
			qte = this.item.get(i);
		if(qte > 1){
			qte--;
			this.item.put(i, qte);
		}
		else
			this.item.remove(i);
		return true;
	}

	public void addItem(Item item) {
		int qte;
		if (this.item.containsKey(item)) {
			qte = this.item.get(item) + 1;
		} else
			qte = 1;
		this.item.put(item, qte);
	}
	
	public int getCurrentWeight(){
		int total = 0;
		for(Map.Entry<Item, Integer> entry : item.entrySet()){
			total += entry.getValue() * entry.getKey().getWeight();
		}
		return total;
	}
}
