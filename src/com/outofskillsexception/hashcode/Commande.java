package com.outofskillsexception.hashcode;

import java.util.ArrayList;

public class Commande {
	private int id;
	private String name;
	private String[] type;
	private ArrayList<Commande> list;
	
	public Commande(int id, String name, String[] type){
		this.id = id;
		this.name = name;
		this.type = type;
		this.list.add(new Commande(id, name, type));
	}
	
	public void delivered(Commande commande){
		if(list.contains(commande))
			list.remove(commande);
	}
}
