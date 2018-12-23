package com.codility.practice;

import java.util.ArrayList;
import java.util.List;

public class MinimumPositiveNumberFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] inputArray = {1, 3, 6, 4, 1, 2};
		int[] inputArray = { 1, 2, 3 };

		System.out.println(findMinimumPositive(inputArray));
	}

	public static int findMinimumPositive(int[] inputArray) {
		int smallestPositiveNumber = 0;
		List<Integer> inputList = new ArrayList<>();
		for (int loopIndex = 0; loopIndex < inputArray.length; loopIndex++) {
			inputList.add(inputArray[loopIndex]);
		}
		System.out.println("Input list : " + inputList);
		for (int loopIndex = 0; loopIndex < inputArray.length; loopIndex++) {
			if (!inputList.contains(loopIndex) && loopIndex != 0) {
				smallestPositiveNumber = loopIndex;
				break;
			} else if (inputList.get(loopIndex) < 0) {
				smallestPositiveNumber = 1;
			} else if (loopIndex == inputArray.length-1 && smallestPositiveNumber == 0) {
				smallestPositiveNumber = loopIndex + 2;
			}
		}
		return smallestPositiveNumber;
	}

}
