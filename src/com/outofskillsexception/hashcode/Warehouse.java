package com.outofskillsexception.hashcode;

import java.util.Map;

public class Warehouse {
	int[] pos;
	int id;
	Map<Item, Integer> stock;

	public Warehouse(int id, int[] pos, Map<Item, Integer> stock) {
		this.pos = pos;
		this.stock = stock;
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

	public Map<Item, Integer> getStock() {
		return stock;
	}
	
	public void setStock(Map<Item, Integer> stock) {
		this.stock = stock;
	}
	
	public boolean removeFromWarehouse(Item item){
		if(stock.get(item) != null && stock.get(item) > 0) {
			stock.put(item, new Integer(new Integer(stock.get(item) - 1)));
			return true;
		}
		return false;
	}
	
	public Map<Item,Integer> getItems(){
		return stock;
	}
	
}
