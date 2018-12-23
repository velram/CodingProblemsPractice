package com.interviewbit.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * This class is to find solution for the "Largest Number" problem
 * https://www.interviewbit.com/problems/largest-number/
 * @author Velmurugan Moorthy
 * 18.09.2018
 */
public class LargestNumberMakerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String largestNumber = "";
		List<Integer> inputList = new ArrayList<>();
		//int[] inputArray = {8,80,834,8888,3,2};//Test case #1 - PASS 
		//int[] inputArray = {511,89,32,14,54,104}; //Test case #2 - PASS
		//int[] inputArray = {}; //Test case #3 - PASS
		//int[] inputArray = {0};//Test case #4 - PASS 
		//{0, 0, 0, 0, 0} - //Test case #5 - PASS
		//9775076860243460
		inputList.add(97750768);
		inputList.add(60243460);
		/*inputList.add(0);
		inputList.add(0);
		inputList.add(0);
		inputList.add(0);
		inputList.add(0);*/
		/*inputList.add(80);
		inputList.add(834);
		inputList.add(8888);
		inputList.add(3);
		inputList.add(2);*/
		System.out.println("Before sorting " + inputList);
		Collections.sort(inputList, new IntegerStringComparator());
		System.out.println("After sorting " + inputList);
		LargestNumberMarker largestNumberMaker = new LargestNumberMarker();
		largestNumber = largestNumberMaker.createLargestNumber(inputList);
		System.out.println(largestNumber);
	}
}

class LargestNumberMarker {

	public String createLargestNumber(List<Integer> inputList) {
		StringBuilder largestNumberSB = new StringBuilder();
		int inputNumbersSum = 0; 
		for (Iterator inputListIterator = inputList.iterator(); inputListIterator.hasNext();) {
			Integer currentNumber = (Integer) inputListIterator.next();
			inputNumbersSum += currentNumber;
			largestNumberSB.append(currentNumber.toString());
		}
		if(inputNumbersSum == 0) {
			return "0";
		}
		return largestNumberSB.toString();
	} 

}

class IntegerStringComparator implements Comparator<Integer> {

	//return o1.compareTo(o2); - sorts the input in ascending order
	//return o2.compareTo(o1); - sorts the input in descending order

	@Override
	public int compare(Integer firstNumber, Integer secondNumber) {
		// TODO Auto-generated method stub
		//return o1.compareTo(o2);
		String combination1 = String.valueOf(firstNumber) + String.valueOf(secondNumber);
		String combination2 = String.valueOf(secondNumber) + String.valueOf(firstNumber);
		//return Integer.valueOf(combination1).compareTo(Integer.valueOf(combination2));
		/*System.out.println("combination 1 : "+combination1);
		System.out.println("combination 2 : "+combination2);*/
		/*return combination1.compareTo(combination2);*/
		//return Integer.valueOf(combination2).compareTo(Integer.valueOf(combination1));
		//return Integer.valueOf(combination1).compareTo(Integer.valueOf(combination2));
		return Long.valueOf(combination2).compareTo(Long.valueOf(combination1));
	}


}
