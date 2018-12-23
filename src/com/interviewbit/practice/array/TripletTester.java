package com.interviewbit.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TripletTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TripletFinder tripletFinder = new TripletFinder();
		// String[] triplet =
		// {"0.1","0.183","0.0123","0.00123","0.2","0.8","0.7","0.01"};
		// String[] triplet = {"0.503094", "0.648924", "0.999298"};
		String[] triplet = { "0.366507", "0.234601", "2.126313", "1.372403", "2.022170", "0.308558", "2.120754",
				"1.561462" };
		System.out.println("Triplet result : " + tripletFinder.isTriplet(triplet));
	}

}

class TripletFinder {

	private static final String CONSTANT_CHARACTER_A = "A";
	private static final Object CONSTANT_CHARACTER_B = "B";
	private static final Object CONSTANT_CHARACTER_C = "C";

	public int isTriplet(String[] pInputArray) {
		final int TRIPLET_EXISTS = 1;
		final int TRIPLET_NOT_PRESENT = 0;

		final String BUCKET_A = "A";
		final String BUCKET_B = CONSTANT_CHARACTER_A;
		final String BUCKET_C = "C";
		int arraySize = pInputArray.length - 1;
		System.out.println("arraySize : " + arraySize);
		if (arraySize == 0 || arraySize < 2) {
			return TRIPLET_EXISTS;
		}

		Map<String, List<Double>> inputBuckets = createBucketArrays(pInputArray);

		System.out.println("before sorting : parsedInputArray : " + inputBuckets);
		//Arrays.sort(inputBuckets);
		System.out.println("before sorting : parsedInputArray : " + inputBuckets);

		return TRIPLET_NOT_PRESENT;
	}

	private Map<String, List<Double>> createBucketArrays(String[] pInputArray) {
		// List<Double> parsedInput = new ArrayList<>();
		final int TRIPLET_MIN_VALUE = 1;
		final int TRIPLET_MAX_VALUE = 2;
		final int TRIPLET_EXISTS = 1;
		final int TRIPLET_NOT_PRESENT = 0;
		double[] parsedInputArray = new double[pInputArray.length];
		Map<String, List<Double>> parsedInputBuckets = new HashMap<>();
		List<Double> parsedInputList = new ArrayList<>();
		populateInputBuckets(pInputArray, parsedInputArray, parsedInputBuckets, parsedInputList);
		System.out.println("ParsedInput list is : "+parsedInputList);
		int firstBucketCount = 0; 
		int secondBucketCount = 0;
		int thirdBucketCount = 0; 
		System.out.println("parsedInputList.size() : "+parsedInputList.size());
		for (int loopIndex = 0; loopIndex < parsedInputList.size() ; loopIndex++) {
			if (loopIndex < (parsedInputList.size() - 2)) {
			Double firstElement = (Double) parsedInputList.get(loopIndex);
			Double secondElement = (Double) parsedInputList.get(loopIndex + 1);
			Double thirdElement = (Double) parsedInputList.get(loopIndex + 2);
			
			  if(null != parsedInputBuckets.get(CONSTANT_CHARACTER_A) && (parsedInputBuckets.get(CONSTANT_CHARACTER_A).contains(firstElement) || parsedInputBuckets.get(CONSTANT_CHARACTER_A).contains(secondElement) || parsedInputBuckets.get(CONSTANT_CHARACTER_A).contains(thirdElement))) {
					firstBucketCount++;	
				}
				if(null != parsedInputBuckets.get(CONSTANT_CHARACTER_B) && (parsedInputBuckets.get(CONSTANT_CHARACTER_B).contains(firstElement) || parsedInputBuckets.get(CONSTANT_CHARACTER_B).contains(secondElement) || parsedInputBuckets.get(CONSTANT_CHARACTER_B).contains(thirdElement))) {
					secondBucketCount++;	
				}				
				if(null != parsedInputBuckets.get(CONSTANT_CHARACTER_C) && (parsedInputBuckets.get(CONSTANT_CHARACTER_C).contains(thirdElement) || parsedInputBuckets.get(CONSTANT_CHARACTER_C).contains(secondElement) || parsedInputBuckets.get(CONSTANT_CHARACTER_C).contains(thirdElement))) {
					thirdBucketCount++;	
				}
				System.out.println("firstBucketCount : "+firstBucketCount + " secondBucketCount : "+secondBucketCount + " thirdBucketCount : "+thirdBucketCount);
				if(!(thirdBucketCount  > 1) && (firstBucketCount <= 3 && secondBucketCount <=3 )) {
					System.out.println("firstBucketCount : "+firstBucketCount + " secondBucketCount : "+secondBucketCount + " thirdBucketCount : "+thirdBucketCount);
					if(firstBucketCount == 0) {
						
					}
					
				}
			
		}
			firstBucketCount = secondBucketCount = thirdBucketCount = 0; 
	   }
		return parsedInputBuckets;
	}

	/**
	 * @param pInputArray
	 * @param parsedInputArray
	 * @param parsedInputBuckets
	 * @param parsedInputList
	 * @param BUCKET_A
	 * @param BUCKET_B
	 * @param BUCKET_C
	 * @param CONSTANT_ZERO
	 * @param TWO_BY_THREE_CONSTANT
	 * @param CONSTANT_ONE
	 * @param CONSTANT_TWO
	 */
	private void populateInputBuckets(String[] pInputArray, double[] parsedInputArray,
			Map<String, List<Double>> parsedInputBuckets, List<Double> parsedInputList) {
		final String BUCKET_A = "A";
		final String BUCKET_B = CONSTANT_CHARACTER_A;
		final String BUCKET_C = "C";
		final int CONSTANT_ZERO = 0;
		final double TWO_BY_THREE_CONSTANT = 2 / 3;
		final int CONSTANT_ONE = 1;
		final int CONSTANT_TWO = 2;
		List<Double> tempContainer = new ArrayList<>();
		for (int loopIndex = 0; loopIndex < pInputArray.length; loopIndex++) {

			if (null != pInputArray[loopIndex] && !pInputArray[loopIndex].isEmpty()) {
				// parsedInput.add(Double.parseDouble(pInputArray[loopIndex]));
				parsedInputArray[loopIndex] = Double.parseDouble(pInputArray[loopIndex]);
				System.out.println("pInputArray[loopIndex] : "+parsedInputArray[loopIndex]);
				if (CONSTANT_ZERO < parsedInputArray[loopIndex] && parsedInputArray[loopIndex] < TWO_BY_THREE_CONSTANT
						&& null == parsedInputBuckets.get(BUCKET_A)) {
					tempContainer.add(parsedInputArray[loopIndex]);
					parsedInputList.add(parsedInputArray[loopIndex]);
					parsedInputBuckets.put(BUCKET_A, tempContainer);
					tempContainer = new ArrayList<>();
				} else if (CONSTANT_ZERO < parsedInputArray[loopIndex]
						&& parsedInputArray[loopIndex] < TWO_BY_THREE_CONSTANT
						&& null != parsedInputBuckets.get(BUCKET_A)) {
					System.out.println("Bucket A | list alreadyExists | element : "+parsedInputArray[loopIndex]);
					parsedInputBuckets.get(BUCKET_A).add(parsedInputArray[loopIndex]);
					parsedInputList.add(parsedInputArray[loopIndex]);
				} else if (TWO_BY_THREE_CONSTANT < parsedInputArray[loopIndex]
						&& parsedInputArray[loopIndex] < CONSTANT_ONE && null == parsedInputBuckets.get(BUCKET_B)) {
					tempContainer.add(parsedInputArray[loopIndex]);
					parsedInputList.add(parsedInputArray[loopIndex]);
					parsedInputBuckets.put(BUCKET_B, tempContainer);
					tempContainer = new ArrayList<>();
				} else if (TWO_BY_THREE_CONSTANT < parsedInputArray[loopIndex]
						&& parsedInputArray[loopIndex] < CONSTANT_ONE && null != parsedInputBuckets.get(BUCKET_B)) {
					parsedInputBuckets.get(BUCKET_B).add(parsedInputArray[loopIndex]);
					parsedInputList.add(parsedInputArray[loopIndex]);
				} else if (CONSTANT_ONE < parsedInputArray[loopIndex] && parsedInputArray[loopIndex] < CONSTANT_TWO
						&& null == parsedInputBuckets.get(BUCKET_C)) {
					tempContainer.add(parsedInputArray[loopIndex]);
					parsedInputList.add(parsedInputArray[loopIndex]);
					parsedInputBuckets.put(BUCKET_C, tempContainer);
					tempContainer = new ArrayList<>();
				} else if (CONSTANT_ONE < parsedInputArray[loopIndex] && parsedInputArray[loopIndex] < CONSTANT_TWO
						&& null != parsedInputBuckets.get(BUCKET_C)) {
					parsedInputBuckets.get(BUCKET_C).add(parsedInputArray[loopIndex]);
					parsedInputList.add(parsedInputArray[loopIndex]);
				}
			}
		}
	}
}