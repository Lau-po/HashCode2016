package com.outofskillsexception.hashcode;

import java.util.ArrayList;

public class CreateArray {
	private ArrayList[][] tab;

	public CreateArray(int x, int y) {
		tab = new ArrayList[x][y];
	}

	public void move(Object o, int n, int x) {
		for (int i = 0; i < tab[0].length; i++) {
			for (int j = 0; j < tab[1].length; j++) {
				if (tab[i][j].contains(o)) {
					tab[n][x].add(o);
					if (tab[i][j].isEmpty())
						tab[i][j] = null;
					else
						tab[i][j].remove(o);
				}
			}
		}
	}
}
