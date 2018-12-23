/**
 * 
 */
package com.interviewbit.practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Velmurugan Moorthy
 * 
 * Solution for the interviewBit question.
 * Find largest number from the input
 * 
 */
public class LargestNumberTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = {3, 30, 34, 5, 9};
		LargestNumberCreator largestNumberCreatorObj = new LargestNumberCreator();
		largestNumberCreatorObj.createLargestNumber(inputArray);
		System.out.println("34 / 10 = "+(9934/10));
	}

}


class LargestNumberCreator {
	
	private static final int DIGIT_ONE = 1;
	private static final int DIGIT_TW0 = 2;
	private static final int DIGIT_THREE = 3;
	private static final int DIGIT_FOUR = 4;
	private static final int DIGIT_FIVE = 5;
	private static final int DIGIT_SIX = 6;
	private static final int DIGIT_SEVEN = 7;
	private static final int DIGIT_EIGHT = 8;
	private static final int DIGIT_NINE = 9;
	private static final int DIGIT_ZERO = 0;
	
	public String createLargestNumber(int[] pInputArray) {
		
		String result = "0";
		Map<Integer,List<Integer>> digitNumbersMap = new HashMap<>();
		populateDigitNumbersMap(digitNumbersMap);
		createNumberBuckets(digitNumbersMap,pInputArray);
		System.out.println("DigitNumbersMap : " + digitNumbersMap);
		return result;
		
	}

	private void createNumberBuckets(Map<Integer, List<Integer>> digitNumbersMap, int[] pInputArray) {
		// TODO Auto-generated method stub
		for (int loopIndex = 0; loopIndex < pInputArray.length; loopIndex++) {
			//TODO handle less than zero 
			
			if(pInputArray[loopIndex] == 0) {
				if(digitNumbersMap.get(0) != null & !digitNumbersMap.get(0).isEmpty()) {
					digitNumbersMap.get(0).add(pInputArray[loopIndex]);
					digitNumbersMap.put(0, digitNumbersMap.get(0));
				}
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_ONE) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_ONE);
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_TW0) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_TW0);
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_THREE) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_THREE);
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_FOUR) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_FOUR);
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_FIVE) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_FIVE);
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_SIX) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_SIX);
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_SEVEN) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_SEVEN);
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_EIGHT) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_EIGHT);
			}
			else if(findFirstDigit(pInputArray[loopIndex]) == DIGIT_NINE) {
				populateDigitNumberListMap(digitNumbersMap, pInputArray, loopIndex,DIGIT_NINE);
			}
		}
		
	}

	/**
	 * @param digitNumbersMap
	 * @param pInputArray
	 * @param loopIndex
	 */
	private void populateDigitNumberListMap(Map<Integer, List<Integer>> digitNumbersMap, int[] pInputArray,
			int loopIndex, int firstDigit) {
		if(null != digitNumbersMap && null != digitNumbersMap.get(firstDigit) && !digitNumbersMap.get(firstDigit).isEmpty()) {
			digitNumbersMap.get(firstDigit).add(pInputArray[loopIndex]);
			digitNumbersMap.put(firstDigit, digitNumbersMap.get(firstDigit));
		}
		else {
			List<Integer> tempList = new ArrayList<>();
			tempList.add(pInputArray[loopIndex]);
			digitNumbersMap.put(firstDigit, tempList);
		}
	}

	private void populateDigitNumbersMap(Map<Integer, List<Integer>> digitNumbersMap) {
		// TODO Auto-generated method stub
		
		for(int i = 0 ; i < 10 ; i++ ) {
			digitNumbersMap.put(i, null);
		}
	}
	
	public int findFirstDigit(int pInputNumer) {
		int digits = (int)(Math.log10(pInputNumer));
/*		System.out.println("Total digits in inputNumber is : "+Math.log10(pInputNumer));
		System.out.println("(Math.pow(10, digits) is : "+(Math.pow(10, digits)));*/
		int firstDigit = (int)(pInputNumer / (int)(Math.pow(10, digits)));
		return firstDigit;
	}
}