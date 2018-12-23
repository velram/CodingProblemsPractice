package com.interviewbit.practice.array;

import java.util.Arrays;

/**
 * This class tries to solve the "Wave array" problem 
 * InterviewBit question URL  - https://www.interviewbit.com/problems/wave-array/
 * @author Velmurugan Moorthy
 *
 */
public class WaveArrayTester {

	public static void main(String[] args) {

		//int[] inputArray = new int[]{1,2,3,4,5};//Test case #1 - Odd number of entries -  Happy flow - basic test case 
		//int[] inputArray = new int[]{0};//Test case #2 - single entry - value is '0'
		//int[] inputArray = new int[]{1};//Test case #3 - single entry - value is '1'
		//int[] inputArray = new int[]{1,2,3,4};//Test case #4 - Even number of entries
		//int[] inputArray = new int[]{1,2,3,4,5,6,7,8,9,10};//Test case #5 -  Even number of entries with basic decimal set
		//int[] inputArray = new int[]{97,124,56,99,31,13,108,1}; //Test case #6 - Array of elements with double & triple digit entries
		//int[] inputArray = new int[]{34,86,12,-1,0,-3,10}; //Test case #7 - Array with double digit entries & few negative numbers
		//int[] inputArray = new int[]{-1,-1,-1,-1,-1};//Test case #8 - Array with negative numbers - same negative number
		//int[] inputArray = new int[]{1,1,1,1,1,1};//Test case #9 - All entries are same - single number only (value is 1)
		//int[] inputArray = new int[]{};//Test case #10 - Empty array
		//int[] inputArray = null;//Test case #11 - Null array
		//int[] inputArray = new int[]{0,0,0,0,0};//Test case #12 - all entries are zero
		//int[] inputArray = new int[]{-1};//Test case #13 - single entry - negative integer - value is -1
		//int[] inputArray = new int[]{2};//Test case #14 - single entry - positive integer - value is 2
		//int[] inputArray = new int[]{1,2,3,4,5,6,7,8,9};//Test case #15 - (ascending order) odd number of entries with basic decimal set
		int[] inputArray = new int[]{9,8,7,6,5,4,3,2,1};//Test case #16 - Descending order odd number of entries with basic decimal set
		//int[] inputArray = new int[]{9,8,7,6,1,2,3,4,5};//Test case #17 - Mixed inputs 
		
		WaveArrayGenerator waveArrayGenerator = new WaveArrayGenerator();
		
		int[] waveArray = waveArrayGenerator.generateWaveArray(inputArray);
		
		waveArrayGenerator.printWaveArray(waveArray);
	}
}


class WaveArrayGenerator {
	
	public int[] generateWaveArray(int[] pInputArray) {
		if(null == pInputArray || pInputArray.length == 0) {
			return pInputArray;
		}
		int arrayLength = pInputArray.length;
		int[] waveArray = new int[arrayLength];
		
		Arrays.sort(pInputArray);

		for (int loopIndex = 0; loopIndex < arrayLength; ) {
			
			if(arrayLength > 1 && loopIndex <= arrayLength - 1) {
				waveArray[loopIndex] = pInputArray[loopIndex+1];
				waveArray[loopIndex+1] = pInputArray[loopIndex];
				loopIndex = loopIndex + 2;
			}
			if((arrayLength % 2 != 0)) {
				if(loopIndex == arrayLength - 1) {
					waveArray[loopIndex] = pInputArray[loopIndex];
					break;
			   }
			}
		}
		return waveArray;
	}

	public void printWaveArray(int[] waveArray) {
       System.out.println("Printing Wave array starts : ");
		for (int loopIndex = 0; loopIndex < waveArray.length; loopIndex++) {
			System.out.print(" " +waveArray[loopIndex]);
		}
		System.out.println("\nPrinting Wave array ends : ");;
	}
}
