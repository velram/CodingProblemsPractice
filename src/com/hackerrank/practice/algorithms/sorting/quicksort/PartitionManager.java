/**
 * 
 */
package com.hackerrank.practice.algorithms.sorting.quicksort;

/**
 * @author velmurugan.moorthy
 * HackerRank question URL : https://www.hackerrank.com/challenges/quicksort1/problem
 * 
 */
public class PartitionManager {

	public int[] performPartition(int[] inputArray) {
		int[] resultArray = new int[inputArray.length];
		System.out.println(" Printing input array");
		printArray(inputArray);
		
		int[] leftArray = new int[inputArray.length];
		int[] rightArray = new int[inputArray.length];
		int[] middleArray = new int[inputArray.length];
		int leftArraySize = 0; 
		int rightArraySize = 0; 
		int medianArraySize = 0; 
		int pivot = inputArray[0];
		
		for(int loopIndex = 0 ; loopIndex < inputArray.length ; loopIndex++) {
			
			if(inputArray[loopIndex] < pivot) {
				leftArray[leftArraySize++] = inputArray[loopIndex];
			}
		}	
		
		for(int loopIndex = 0 ; loopIndex < inputArray.length ; loopIndex++) {
			if(inputArray[loopIndex] > pivot) {
				rightArray[rightArraySize++] = inputArray[loopIndex];
			}
		}
		
		for(int loopIndex = 0 ; loopIndex < inputArray.length ; loopIndex++) {
			if (inputArray[loopIndex] == pivot) {
				middleArray[medianArraySize++] = inputArray[loopIndex];				
			}
		}		
		
		resultArray = mergePartitions(leftArray, rightArray, middleArray, leftArraySize, rightArraySize,
				medianArraySize);
		// resultArray = populateResultArray(leftArray,leftArraySize,resultArray);
		
		
		System.out.println("\n Printing Left array");
		printArray(leftArray);
		System.out.println("\n Printing middle array");
		printArray(middleArray);
		System.out.println("\n Printing right array");
		printArray(rightArray);		
		System.out.println("\n Printing resultArray array");
		printArray(resultArray);	
		
		return resultArray;
	}

	private int[] mergePartitions(int[] leftArray, int[] rightArray, int[] middleArray,
			int leftArraySize, int rightArraySize, int equalValueArraySize) {
		int[] resultArray = new int[leftArraySize + rightArraySize + equalValueArraySize];
		for(int loopIndex = 0 ; loopIndex < leftArraySize ; loopIndex++) {
			resultArray[loopIndex] = leftArray[loopIndex];
		}
		int tempArrayLoopIndex = 0;
		for(int loopIndex = leftArraySize ; loopIndex < (leftArraySize + equalValueArraySize) ; loopIndex++, tempArrayLoopIndex++) {
			resultArray[loopIndex] = middleArray[tempArrayLoopIndex];
		}
		tempArrayLoopIndex = 0;
		for(int loopIndex = (leftArraySize + equalValueArraySize) ; loopIndex < (leftArraySize + equalValueArraySize + rightArraySize) ; loopIndex++, tempArrayLoopIndex++) {
			resultArray[loopIndex] = rightArray[tempArrayLoopIndex];
		}
		return resultArray;
	}

	public void printArray(int[] inputArray) {
		System.out.println("==================================");
		for(int loopIndex = 0; loopIndex < inputArray.length ; loopIndex++) {
			System.out.print(" "+inputArray[loopIndex]);
		}			
		System.out.println("\n==================================");
	}
	
}
