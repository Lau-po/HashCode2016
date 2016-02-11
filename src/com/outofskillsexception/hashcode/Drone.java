package com.outofskillsexception.hashcode;

import java.awt.Point;

public class Drone {
	private int weight,id;
	private Point pos;
	private Item item;
	private boolean free= false;

	public Drone(int id, int weight, int x, int y, Item item) {
		// TODO Auto-generated constructor stub
		this.weight = weight;
		this.id = id;
		this.pos = new Point(x,y);
		this.item = item;
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
		this.pos.setLocation(x, y);;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
