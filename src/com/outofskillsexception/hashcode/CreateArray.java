package com.outofskillsexception.hashcode;

public class CreateArray {
	private Object[][] tab;

	public CreateArray(int x, int y) {
		this.tab = tab;
		tab = new Object[x][y];
	}

	public void move(Object o, int n, int x) {
		for (int i = 0; i < tab[0].length; i++) {
			for (int j = 0; j < tab[1].length; j++) {
				if (tab[i][j].equals(o)) {
					Object tmp = tab[n][x];
					tab[n][x] = o;
					tab[i][x] = tmp;
				}
			}
		}
	}
}
