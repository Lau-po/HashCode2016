package com.outofskillsexception.hashcode;

public class Warehouse {
	int[] pos;
	int id;
	int[] stock;

	public Warehouse(int id, int[] pos, int[][] stock) {
		this.pos = pos;
		this.stock = stock[id];
		this.id = id;
	}

	public int[] getPos() {
		return pos;
	}

	public void setPos(int[] pos) {
		this.pos = pos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getStock() {
		return stock;
	}

	public void setStock(int[] stock) {
		this.stock = stock;
	}
	
	
}
