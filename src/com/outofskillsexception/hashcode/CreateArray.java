package com.outofskillsexception.hashcode;

import java.util.ArrayList;

public class CreateArray {
	private ArrayList[][] tab;

	public CreateArray(int x, int y) {
		tab = new ArrayList[x][y];
	}

	public void move(Object o, int x, int y) {
		for (int i = 0; i < tab[0].length; i++) {
			for (int j = 0; j < tab[1].length; j++) {
				if (tab[i][j].contains(o)) {
					tab[x][y].add(o);
					if (tab[i][j].isEmpty())
						tab[i][j] = null;
					else
						tab[i][j].remove(o);
				}
			}
		}
	}
	
	public String detect(int x, int y){
		return this.tab.getClass().getName().toString();
	}
}
