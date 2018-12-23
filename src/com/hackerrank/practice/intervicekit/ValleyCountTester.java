package com.hackerrank.practice.intervicekit;

import java.util.Scanner;

/**
 * 
 * @author Velmurugan Moorthy
 * Question URL : https://www.hackerrank.com/challenges/counting-valleys/problem
 */
public class ValleyCountTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputReader = new Scanner(System.in);
		int totalSteps = inputReader.nextInt();
		String path = inputReader.next();
		
       ValleyCounter valleyCounterObject = new ValleyCounter();
       int valleysCount = valleyCounterObject.countingValleys(totalSteps, path);
       System.out.println("Valleys count : "+valleysCount);
       inputReader.close();
	}

}

class ValleyCounter { 

/*	
 * This logic is failing 
 * 
 * public int countingValleys(int steps, String path) {
		int valleyCount = 0; 

		char[] pathChars = path.toCharArray();
		
		
		for (int loopIndex = 0; loopIndex < pathChars.length; loopIndex++) {
			
			if(loopIndex < (pathChars.length-1) ) {
				if(pathChars[loopIndex] == 'D' && pathChars[loopIndex+1] == 'U') {
					valleyCount++;
				}
			}
		}
		
		return valleyCount;
	}*/
	
	public int countingValleys(int steps, String path) {
		int valleyCount = 0; 

		char[] pathChars = path.toCharArray();
		int altitude = 0; 
		
		for (int loopIndex = 0; loopIndex < pathChars.length; loopIndex++) {

			if(pathChars[loopIndex] == 'U') {
				if(altitude == -1) {
					valleyCount++;
				}
				altitude++;
			}
			else if(pathChars[loopIndex] == 'D') {
				altitude--;
			}
		}
		
		return valleyCount;
	}
}