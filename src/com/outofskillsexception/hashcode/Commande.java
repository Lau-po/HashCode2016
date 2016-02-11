package com.outofskillsexception.hashcode;

import java.util.ArrayList;

public class Commande {
	private int id;
	private String name;
	private String[] type;
	private ArrayList<Commande> list;
	private ArrayList<Drone> d;
	private Drone free;

	public Commande(int id, String name, String[] type, ArrayList<Drone> d, Drone free) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.d = d;
		this.free = free;
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).isFree())
				free = d.get(i);
		}
		this.list.add(new Commande(id, name, type, d, free));
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
}
