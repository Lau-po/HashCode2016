package com.outofskillsexception.hashcode;

import com.outofskillsexception.hashcode.reader.Read;

public class Main {
	
	public static void main(String[] args) {
		Read read = new Read("busy_day.in");
		read.run();
		read.createClasses();
	}

}
