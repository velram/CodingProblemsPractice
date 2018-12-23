/**
 * 
 */
package com.interviewbit.practice.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Velmurugan Moorthy
 * 29.10.2018
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 * 
 */
public class DuplicateFinderTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuplicateFinder duplicateFinder = new DuplicateFinder();
		List<Integer> inputList = new ArrayList<>();
		inputList.add(3);
		inputList.add(4);
		inputList.add(1);
		inputList.add(4);
		inputList.add(1);
		int repeatedNumber = duplicateFinder.repeatedNumber(inputList);
		System.out.println("repeatedNumber is : "+repeatedNumber);
		
	}

}

class DuplicateFinder {
	
	public int repeatedNumber(final List<Integer> inputList) {
      int repeatedNumber = 0; 
      int[] occurenceCount = new int[inputList.size()];
      
      for (Iterator inputListIterator = inputList.iterator(); inputListIterator.hasNext();) {
		Integer currentNumber = (Integer) inputListIterator.next();
		occurenceCount[currentNumber]++;
		if(occurenceCount[currentNumber] > 1) {
			repeatedNumber = currentNumber;
			break;
		}
	}
      return repeatedNumber;
	}
}
