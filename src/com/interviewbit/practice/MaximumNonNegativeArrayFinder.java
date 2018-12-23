package com.interviewbit.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Velmurugan Moorthy
 * 
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 * 
 */
public class MaximumNonNegativeArrayFinder {

	public static void main(String[] args) {

		//ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421));
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(756898537, -1973594324, -2038664370, -184803526, 1424268980));
		/*
		 * 1, 2, 5, -7, 2, 3
		 * 0, 0, -1, 0
		 * 1967513926, 1540383426, -1303455736, -521595368
		 * 336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421
		 * 756898537, -1973594324, -2038664370, -184803526, 1424268980
		 **/
		
		List<Integer> maximumNonNegativeArray = null; 
		
		maximumNonNegativeArray = findMaxNonNegativeArray(inputArray);
		//System.out.println("Max Integer value : "+Integer.MAX_VALUE);
		System.out.println("maximumNonNegativeArray : "+maximumNonNegativeArray);
		//System.out.println("Is less than Max Integer : "+ Math.max(2417147951L, 1688136404L));
		
		
	}
	
	public static List<Integer> findMaxNonNegativeArray(ArrayList<Integer> pInputArray) {
		
		ArrayList<Integer> newArray = new ArrayList<>();
		//ArrayList<Integer> spaceHolderArray = new ArrayList<>();
		//
		ArrayList<Integer> maxNonNegativeArray = new ArrayList<>();
		ArrayList<Long> arraySumList = new ArrayList<>();
		Map<Long,ArrayList<Integer>> arraySumMap = new HashMap<>();
		long newArraySum = 0; 
		long maxArraySum = 0; 
		int currMaxArrayLength = 0; 
		
		for(int loopIndex = 0 ; loopIndex < pInputArray.size() ; loopIndex++) {
			//System.out.println("\n Current element : "+pInputArray.get(loopIndex));
			if(pInputArray.get(loopIndex) >= 0) {
				newArray.add(pInputArray.get(loopIndex));
				newArraySum += pInputArray.get(loopIndex);					
				//System.out.println("newArray : " + newArray + " newArraySum  : "+newArraySum + " maxArraySum : "+maxArraySum);
			}
			
			else if(pInputArray.get(loopIndex) < 0 && !newArray.isEmpty()){
				currMaxArrayLength = newArray.size();
				maxArraySum = populateArraySumArray(newArray, arraySumList, arraySumMap, newArraySum, maxArraySum,
						currMaxArrayLength);
				newArray = new ArrayList<>();
				newArraySum = 0; 
			}
			//System.out.println(" loopIndex : "+loopIndex + " pInputArray.size() -1 : "+ (pInputArray.size() -1));
			if ((loopIndex == pInputArray.size() -1) && maxArraySum < newArraySum) {
				maxArraySum = populateArraySumArray(newArray, arraySumList, arraySumMap, newArraySum, maxArraySum,
						currMaxArrayLength);
			}
		}
		System.out.println("maxArraySum : "+maxArraySum + " maxNonNegative array : "+arraySumMap.get(maxArraySum));
		if(null != arraySumMap.get(maxArraySum)) {
			maxNonNegativeArray.addAll(arraySumMap.get(maxArraySum));
		}
		return maxNonNegativeArray;
	}

	private static long populateArraySumArray(ArrayList<Integer> newArray, ArrayList<Long> arraySumList,
			Map<Long, ArrayList<Integer>> arraySumMap, long newArraySum, long maxArraySum, int currMaxArrayLength) {
		if(!arraySumList.contains(newArraySum)) {
			arraySumList.add(newArraySum);
			arraySumMap.put(newArraySum, newArray);
			maxArraySum = Collections.max(arraySumList);
		}
		else {
			//System.out.println("Inside #74 | arraySumList : "+arraySumList + " arraySumMap: "+arraySumMap);
			if(Math.max(currMaxArrayLength, newArray.size()) == newArray.size()) {
				arraySumMap.put(newArraySum, newArray);
			}
		}
		return maxArraySum;
	}
	
}
