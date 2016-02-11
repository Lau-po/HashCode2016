package com.outofskillsexception.hashcode;

import java.awt.Point;
import java.util.*;

public class Drone {
	private int weight,id;
	private Point pos;
	private List<Item> item = new ArrayList<Item>();
	private boolean free= false;

	public Drone(int id, int weight, int x, int y) {
		// TODO Auto-generated constructor stub
		this.weight = weight;
		this.id = id;
		this.pos = new Point(x,y);
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

	public List<Item> getItems() {
		return item;
	}
	
	public boolean haveItem(Item i) {
		return item.contains(i);
	}
	
	public boolean removeItems(Item i) {
		return item.remove((Object)i);
	}

	public void addItem(Item item) {
		this.item.add(item);
	}
}
