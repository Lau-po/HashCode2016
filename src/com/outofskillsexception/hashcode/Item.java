package com.outofskillsexception.hashcode;

public class Item {
	private int weight,id;
	
	public Item(int id,int weight) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.weight = weight;
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
}
