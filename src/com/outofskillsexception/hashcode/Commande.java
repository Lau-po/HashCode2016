package com.outofskillsexception.hashcode;

import java.util.ArrayList;
import java.util.Map;

public class Commande {
	private int id;
	private Map<Item, Integer> demmande;

	public Commande(int id, Map<Item,Integer> items) {
		this.id = id;
		demmande = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public ArrayList<Commande> getList() {
		return list;
	}

	public void setList(ArrayList<Commande> list) {
		this.list = list;
	}

	public ArrayList<Drone> getD() {
		return d;
	}

	public void setD(ArrayList<Drone> d) {
		this.d = d;
	}

	public void delivered(Commande commande) {
		if (list.contains(commande))
			list.remove(commande);
	}
	
	public boolean addItem(Item i){
		int qt = 0;
		if(items.containsKey(i)){
			qt = items.get(i);
			qt++;
			items.put(i, qt);
			return true;
		}else if(items.containsKey(i)){
			items.put(i, 1);
			return true;
		}
		return false;
	}
	
	public boolean removeItem(Item i){
		int qt = 0;
		if(items.containsKey(i)){
			if(items.get(i) > 1){
				qt = items.get(i);
				qt--;
				items.put(i, qt);				
			}else{
				items.remove(i);				
			}
			return true;
		}
		return false;
	}
	
	public Map<Item,Integer> getItems(){
		return items;
	}
}
