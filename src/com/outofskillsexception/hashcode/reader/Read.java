package com.outofskillsexception.hashcode.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read {
	
	private final File file;
	
	private int row;
	private int column;
	private int numberOfDrones;
	private int deadline;
	private int maxLoad;
	
	public Read(String file) {
		this(new File(file));
	}
	
	public Read(File file) {
		this.file = file;
	}
	
	/**
	 * Read the input file
	 */
	public void run() {
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			
			readFirstLine(bufferedReader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Read the first line
	 */
	public void readFirstLine(String line) throws Exception {
		String[] params = line.split(" ");
		
		row = Integer.parseInt(params[0]);
		column = Integer.parseInt(params[1]);
		numberOfDrones = Integer.parseInt(params[2]);
		deadline = Integer.parseInt(params[3]);
		maxLoad = Integer.parseInt(params[4]);	
	}

}
