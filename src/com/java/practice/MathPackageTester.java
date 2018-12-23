package com.java.practice;

/**
 * 
 * @author Velmurugan Moorthy
 * Class to understand the usage of Math package
 * 
 */
public class MathPackageTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputNumber = -1;
		int digits = (int)(Math.log10(inputNumber));
		System.out.println("Total digits in inputNumber is : "+Math.log10(inputNumber));
		System.out.println("(Math.pow(10, digits) is : "+(Math.pow(10, digits)));
		int firstDigit = (int)(inputNumber / (int)(Math.pow(10, digits)));
		 System.out.println("First digit is : "+firstDigit);
	}

}
