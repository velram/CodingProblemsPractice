package com.java.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class is to understand the basic fundamentals and working of a comparator
 * @author Velmurugan Moorthy
 *
 */
public class ComparatorTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> inputList = new ArrayList<>();
		inputList.add(89);
		inputList.add(32);
		inputList.add(14);
		inputList.add(54);
		inputList.add(511);
		inputList.add(104);
		
		System.out.println("Before sorting " + inputList);
		Collections.sort(inputList, new SampleComparator());
		System.out.println("After sorting " + inputList);
		
	}

}


class SampleComparator implements Comparator<Integer> {

	//return o1.compareTo(o2); - sorts the input in ascending order
	//return o2.compareTo(o1); - sorts the input in descending order
	
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		//return o1.compareTo(o2);
		return o2.compareTo(o1);
	}

	
}