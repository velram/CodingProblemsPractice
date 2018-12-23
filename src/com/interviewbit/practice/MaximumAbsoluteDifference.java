package com.interviewbit.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1, 3, -1));
		MaximumAbsoluteDifferenceFinder maxAbsoluteDiffFinderObject = new MaximumAbsoluteDifferenceFinder();
		long maxAbsoluteDifference = maxAbsoluteDiffFinderObject.findMaxAbsoluteDifference(inputArray);
		System.out.println("maxAbsoluteDifference : "+maxAbsoluteDifference);
	}

}

class MaximumAbsoluteDifferenceFinder {

	public long findMaxAbsoluteDifference(ArrayList<Integer> pInputArray) {
		int maxAbsoluteDifference = 0;
		int absoluteDifference = 0;
		List<Integer> absoluteDifferenceList = new ArrayList<>();
		for (int loopIndex = 0; loopIndex < pInputArray.size(); loopIndex++) {
				for (int innerLoopIndex = 0; innerLoopIndex < pInputArray.size(); innerLoopIndex++) {
					if(loopIndex != innerLoopIndex) {
					absoluteDifference = Math.abs(pInputArray.get(loopIndex) - pInputArray.get(innerLoopIndex))
							+ Math.abs(loopIndex - innerLoopIndex);
					absoluteDifferenceList.add(absoluteDifference);
				}	
			}
		}
		maxAbsoluteDifference = Collections.max(absoluteDifferenceList);
		return maxAbsoluteDifference;
	}
}