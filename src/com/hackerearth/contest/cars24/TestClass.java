package com.hackerearth.contest.cars24;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
 */
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

/**
 * 
 * @author Velmurugan Moorthy
 * Question URL : https://www.hackerearth.com/challenge/hiring/cars24-java-hiring-challenge/problems/703b80c0a583473ea77c95fac73071ce/
 * 05.10.2018
 * Counting valid subsequnce
 */
class TestClass {
	public static void main(String args[] ) throws Exception {
		/* Sample code to perform I/O:
		 * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
                         // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

		 */
		Scanner inputReader = new Scanner(System.in);
		int arraySize = inputReader.nextInt();
		int[] inputArray = new int[arraySize];
		for(int loopIndex = 0 ; loopIndex < arraySize ; loopIndex++) {
			inputArray[loopIndex] = inputReader.nextInt();
		}
		int validDigitCount = inputReader.nextInt();
		// Write your code here

		SubsequenceCreator subsequenceCreatorObject = new SubsequenceCreator();
		subsequenceCreatorObject.formSubsequence(arraySize, inputArray, validDigitCount);
	}
}

class SubsequenceCreator {

	public void formSubsequence(int pArraySize, int[] pInputArray, int pTotalDigits) {

		/*System.out.println("arraySize : "+pArraySize);
		System.out.println("pInputArray : "+pInputArray);
		System.out.println("pTotalDigits : "+pTotalDigits);*/

		StringBuffer subsequenceSB = new StringBuffer();
	    int fixedPointer = 0; 
	    int rotatingPointer = fixedPointer + 1;
	    int subSequenceCount = 0;
	    while((fixedPointer < pArraySize && rotatingPointer < pArraySize) && (fixedPointer != rotatingPointer)) {
	    	if(pInputArray[fixedPointer] != 0 && rotatingPointer <= (pArraySize-2)) { 
	    		rotatingPointer+=2;
	    		subSequenceCount++;
	    	}
	    	else {
	    		fixedPointer++;
	    	}
	    }
	    System.out.println("subSequenceCount : "+subSequenceCount);
	}
}
