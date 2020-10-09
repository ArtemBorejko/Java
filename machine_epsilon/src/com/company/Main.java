package com.company;

public class Main {

    public static void main(String[] args) {
		DoubleEps doubleEps = new DoubleEps();
		FloatEps floatEps = new FloatEps();
		doubleEps.calculateEps();
		System.out.println(" ");
		floatEps.calculateEps();
    }
}
