package com.outofskillsexception.hashcode;

import java.util.Map;

public class Commande {
	private int id;
	private Map<Item, Integer> demmande;
	private int[] position;

	public Commande(int id, Map<Item,Integer> items, int[] position) {
		this.id = id;
		demmande = items;
		this.position = position;
	}
	
	public boolean isFinished() {
		return remeaning() == 0;
	}
	
	public int remeaning() {
		int remeaning = 0;
		
		for (Integer nbr : demmande.values()) {
			remeaning += nbr;
		}
		
		return remeaning;
	}
	
	public int getId() {
		return id;
	}
	
	public Map<Item, Integer> getDemmande() {
		return demmande;
	}
	
	public boolean delivry(Item item) {
		if (demmande.get(item) == null || demmande.get(item) == 0) {
			demmande.remove(item);
			return false;
		}
		
		demmande.put(item, new Integer(demmande.get(item)) - 1);
		return true;
	}
	
	public int[] getPosition() {
		return position;
	}
}
