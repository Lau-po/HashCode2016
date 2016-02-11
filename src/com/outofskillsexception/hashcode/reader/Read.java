package com.outofskillsexception.hashcode.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Read {
	
	private final File file;
	
	private int row;
	private int column;
	private int numberOfDrones;
	private int deadline;
	private int maxLoad;
	
	private int numberItemTypes;
	private int[] itemWeight;
	
	private int numberWarehouse;
	private int[][] warehousePosition;
	private int[][] warehouseItems;
	
	private int numberOrder;
	private int[][] orderPosition;
	private int[][] orderItems;
	
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
			
			readNumberItemTypes(bufferedReader.readLine());
			
			readItemWeight(bufferedReader.readLine());
			
			readNumberWarehouse(bufferedReader.readLine());
			
			warehousePosition = new int[numberWarehouse][2];
			warehouseItems = new int[numberWarehouse][numberItemTypes];
			
			for (int i = 0; i < numberWarehouse; i++) {
				readPosition(bufferedReader.readLine(), i);
				readItems(bufferedReader.readLine(), i);
			}
			
			readNumberOrder(bufferedReader.readLine());
			
			orderPosition = new int[numberOrder][2];
			orderItems = new int[numberOrder][numberItemTypes];
			
			for (int i = 0; i < numberOrder; i++) {
				readOrderPosition(bufferedReader.readLine(), i);
				readOrderItems(bufferedReader.readLine(), bufferedReader.readLine(), i);
			}
			
			bufferedReader.close();
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
	
	/**
	 * Read the number of item type
	 */
	public void readNumberItemTypes(String line) throws Exception {
		numberItemTypes = Integer.parseInt(line);
	}
	
	/**
	 * Read the item weight
	 */
	public void readItemWeight(String line) throws Exception {
		String[] params = line.split(" ");
		
		itemWeight = new int[numberItemTypes];
		
		for (int i = 0; i < params.length; i++) {
			itemWeight[i] = Integer.parseInt(params[i]);
		}
	}
	
	public void readNumberWarehouse(String line) throws Exception {
		numberWarehouse = Integer.parseInt(line);
	}
	
	public void readPosition(String line, int warehouse) {
		String[] params = line.split(" ");
		
		warehousePosition[warehouse][0] = Integer.parseInt(params[0]);
		warehousePosition[warehouse][1] = Integer.parseInt(params[1]);
	}
	
	public void readItems(String line, int warehouse) {
		String[] params = line.split(" ");
		
		for (int i = 0; i < numberItemTypes; i++) {
			warehouseItems[warehouse][i] = Integer.parseInt(params[i]);
		}
	}
	
	public void readNumberOrder(String line) throws Exception {
		numberOrder = Integer.parseInt(line);
	}
	
	public void readOrderPosition(String line, int order) {
		String[] params = line.split(" ");
		
		orderPosition[order][0] = Integer.parseInt(params[0]);
		orderPosition[order][1] = Integer.parseInt(params[1]);
	}
	
	public void readOrderItems(String number, String types, int order) {
		int nbr = Integer.parseInt(number);
		
		String[] items = types.split(" ");
		
		for (int i = 0; i < nbr; i++) {
			orderItems[order][Integer.parseInt(items[i])] += 1;
		}
	}
}
