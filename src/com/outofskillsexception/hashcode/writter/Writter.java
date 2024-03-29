package com.outofskillsexception.hashcode.writter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Writter {
	
	public static final Writter INSTANCE = new Writter();
	
	private List<String> commandes = new ArrayList<String>();
	
	public static void load(int drone, int warehouse, int product, int amount) {
		INSTANCE.commandes.add(drone + " L " + warehouse + " " + product + " " + amount);
	}
	
	public static void delivry(int drone, int order, int product, int amount) {
		INSTANCE.commandes.add(drone + " D " + order + " " + product + " " + amount);
	}
	
	public static void wait(int drone, int turn) {
		INSTANCE.commandes.add(drone + " W " + turn);
	}
	
	public static void save(File file) throws IOException {
		file.createNewFile();
		
		PrintWriter writter = new PrintWriter(file);
		
		writter.println(INSTANCE.commandes.size());
		
		for (String line : INSTANCE.commandes) {
			writter.println(line);
		}
		
		writter.flush();
		writter.close();
	}

}
