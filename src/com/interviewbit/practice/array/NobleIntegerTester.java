/**
 * 
 */
package com.interviewbit.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Velmurugan Moorthy
 * 
 * https://www.interviewbit.com/problems/noble-integer/ 
 * 
 * This class is to find solution for the given InterviewBit question. 
 * This class find the NobleInteger in the array. 
 * If there's any noble integer in the array returns 1. Else, -1.
 * 
 */
public class NobleIntegerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NobleIntegerFinder nobleIntegerFinder = new NobleIntegerFinder();
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList()); // Test case #1 - Input list empty | expected output : -1 | PASS
		//ArrayList<Integer> pInputList = null; // Test case #2 - Input list null | expected output : -1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(-1));// Test case #3 - Single entry with negative value | expected output : -1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(0));// Test case #4 - Single entry with value = ZERO | expected output : 1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(1));// Test case #5 Single entry with value = ONE | expected output : -1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(3));// Test case #6 Single entry with value = greater than one | expected output : -1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(6,21,28,32,34,39,41));// Test case #7 - Noble integer @ the beginning of the (sorted) list | expected output : 1 | PASS 
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(-21,-17,-12,-8,-7,-6,0));// Test case #8 | Noble integer @ the end of the (sorted) list |  expected output : 1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(-8,-5,0,2,8,9));// Test case #9 | Noble integer @ the middle of the (sorted) list |  expected output : 1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(-2,0,2,3));// Test case #10 No noble integers in the list | expected output : -1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(-3,-2,-1,0,0,0));// Test case #11 | Duplicate noble integers |  expected output : 1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));// Test case #12 | No noble integers in the input list |  expected output : -1 | PASS 

		//TODO - cover Edge cases missed - duplicate entries of non-zero integer which should also be accounted for
		ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)); //Test case #13 - Multi-element list - all entries are zero |  expected output : 1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(1,1,1,1,1)); //Test case #14 - Multi-element list - all entries are same (value more than or equal to 1) |  expected output : -1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(3,3,4,4,4));//Test case #15 - Multi-element list with duplicate entries (at beginning) - one noble integer is present |  expected output : 1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(-9,-1,3, 4, 5, 5, 7, 8 ));//Test case #16 - Multi-element list with duplicate entries (in middle) - one noble integer is present -  |  expected output : 1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(-9,-23,-84,-15,0,0,0));//Test case #17 - Multi-element list with duplicate entries (at last) - one noble integer is present -  |  expected output : 1 | PASS
		//ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(1, 2, 7, 0, 9, 3, 6, 0, 6)); //Test case #18 - multiple element list with duplicate entries -   |  expected output : -1 | PASS
		
		int result = nobleIntegerFinder.findNobleInteger(pInputList);
		System.out.println("Noble integer result is : "+result);
		
	}

}

class NobleIntegerFinder {
	
	public int findNobleInteger(ArrayList<Integer> pInputList) {

		final int NO_NOBLE_INTEGER = -1; 
		final int NOBLE_INTEGER_EXISTS = 1; 
		System.out.println("Input list is : "+pInputList);
		
		if(null == pInputList || pInputList.size() == 0) {
			System.out.println("Input list is null or empty");
			return NO_NOBLE_INTEGER;
		}
		int arraySize = pInputList.size();
		/*Set<Integer> sortedUniqueSet = new HashSet<>();
		ArrayList<Integer> sortedUniqueList = new ArrayList<>();
		sortedUniqueSet.addAll(pInputList);
		sortedUniqueList.addAll(sortedUniqueSet);*/
		Collections.sort(pInputList);
		System.out.println("Sorted  list is : "+pInputList);
		
		for(int loopIndex = 0; loopIndex < arraySize ; loopIndex++) {
			boolean nobleInteger = isNobleInteger(pInputList,loopIndex,pInputList.get(loopIndex));
			if(nobleInteger) {
				return NOBLE_INTEGER_EXISTS;
			}
		}
		return NO_NOBLE_INTEGER; 
	}

	private boolean isNobleInteger(ArrayList<Integer> pInputList, int pLoopIndex, Integer pCurrentElement) {

		final boolean IS_NOBLE_INTEGER = true; 
		final boolean IS_NOT_NOBLE_INTEGER = false; 
		int arraySize = pInputList.size();
		
		if(arraySize == 1 && (pCurrentElement >= 1 || pCurrentElement < 0)) {
			System.out.println("arraySize is 1 and element is greater than or equal to one or lesser than zero | "+pCurrentElement);
			return IS_NOT_NOBLE_INTEGER;
		}
		else if(arraySize == 1 && pCurrentElement == 0 ) {
			System.out.println("arraySize is 1 and element is ZERO | pCurrentElement : "+pCurrentElement);
			return IS_NOBLE_INTEGER;
		}
		else if(arraySize > 1 && pLoopIndex < (arraySize - 1)) {
			
			int nextElement = pInputList.get(pLoopIndex + 1);
			System.out.println("arraySize is greater than ZERO | nextElement is : "+nextElement);
			if(pCurrentElement == nextElement) {
				System.out.println("Duplicate entry found | pCurrentElement : " + pCurrentElement +  " | nextElement : " + nextElement + " | pLoopIndex : "+pLoopIndex);
				return IS_NOT_NOBLE_INTEGER;
			}
			return isMatchingElementAndDifference(pLoopIndex, pCurrentElement, arraySize);
		}
		else if(arraySize > 1 && pLoopIndex == (arraySize - 1)) {
			return isMatchingElementAndDifference(pLoopIndex, pCurrentElement, arraySize);
		}
		return IS_NOT_NOBLE_INTEGER;
	}

	/**
	 * @param pLoopIndex
	 * @param pCurrentElement
	 * @param IS_NOBLE_INTEGER
	 * @param IS_NOT_NOBLE_INTEGER
	 * @param arraySize
	 * @return
	 */
	private boolean isMatchingElementAndDifference(int pLoopIndex, Integer pCurrentElement,
			int arraySize) {
		final boolean IS_NOBLE_INTEGER = true; 
		final boolean IS_NOT_NOBLE_INTEGER = false; 
		int difference = arraySize - (pLoopIndex + 1);
		System.out.println("difference: " + difference + " | pCurrentElement : "+pCurrentElement);
		if(difference == pCurrentElement) {
			return IS_NOBLE_INTEGER;
		}
		else {
			return IS_NOT_NOBLE_INTEGER;
		}
	}
}