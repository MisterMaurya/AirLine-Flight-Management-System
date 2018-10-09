package com.airlines.controller;

import java.util.Random;

public class Craft {
	
	public static String craftID() {
		char[] chars = "0123456789".toCharArray();
		Random rnd = new Random();
		String generate ="";
		for (int i = 0; i < 10; i++) {
			generate = generate + chars[rnd.nextInt(chars.length)];
		}
		return "AIR"+generate;
	}
	
	public static String flightID() {
		char[] chars = "0123456789".toCharArray();
		Random rnd = new Random();
		String generate ="";
		for (int i = 0; i < 10; i++) {
			generate = generate + chars[rnd.nextInt(chars.length)];
		}
		return "FI"+generate;
	}

}
