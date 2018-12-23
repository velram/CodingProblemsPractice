package com.codility.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MaxZeroFinderTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inputArray = { 7, 15, 6, 20, 5, 10 };
		//ArrayList<Integer> inputArrayList = new ArrayList(Arrays.asList(inputArray));
		//System.out.println("initial array list : " + inputArrayList.get(1));
		MaxZeroFinder maxZeroFinderObj = new MaxZeroFinder();
		//System.out.println("Hello world");
		int maxZeros = maxZeroFinderObj.findMaxZeros(inputArray);
		System.out.println("MaxZeros : " +maxZeros);

	}
}

class MaxZeroFinder {
	public int findMaxZeros(int[] pInputArray) {
		int maxZeroCount = 0;

		List<Integer> divisibleByTenList = new ArrayList<>();
		List<Integer> divisibleByFiveList = new ArrayList<>();
		List<Integer> divisibleByTwoList = new ArrayList<>();
        System.out.println("Line #34");
		for (int loopIndex = 0; loopIndex < pInputArray.length; loopIndex++) {

			int currentElement = pInputArray[loopIndex];

			if ((currentElement % 10 == 0) && (divisibleByTenList.size() < 3)) {
				divisibleByTenList.add(currentElement);
				if(divisibleByTenList.size() == 3) {
					break;
				}
			}
			else if ((currentElement % 5 == 0) && (divisibleByFiveList.size() < 3)) {
				divisibleByFiveList.add(currentElement);
			}
			else if ((currentElement % 2 == 0) && (divisibleByTwoList.size() < 3)) {
				divisibleByTwoList.add(currentElement);
			}
		}
		System.out.println("Line #52");
		//TODO generate divisibleByTen and product
		
		/*Map<Integer,List<Integer>> divisbleByTenNumsProductMap = new HashMap<>();
		Map<Integer,List<Integer>> divisbleByFiveNumsProductMap = new HashMap<>();
		Map<Integer,List<Integer>> divisbleByTwoNumsProductMap = new HashMap<>();
		
		divisbleByTenNumsProductMap = generateDivisibleByTenProduct(divisibleByTenList);
		divisbleByFiveNumsProductMap = generateDivisibleByFiveProduct(divisibleByFiveList);
		divisbleByTwoNumsProductMap = generateDivisibleByTwoProduct(divisibleByTwoList);*/
		
		int maxElementCount = 0;
		int product = 1;
		for(int loopIndex = 0; loopIndex < 3; loopIndex++) {
			System.out.println("maxElementCount "+maxElementCount);
			if(maxElementCount < divisibleByTenList.size()) {
				System.out.println("divisibleByTenList.size() "+divisibleByTenList.size());
				product *= divisibleByTenList.get(maxElementCount++);
			}
			else if(maxElementCount < divisibleByFiveList.size()) {
				System.out.println("divisibleByFiveList.size() "+divisibleByFiveList.size());
				product *= divisibleByTenList.get(maxElementCount++);
			}
			else if(maxElementCount < divisibleByTwoList.size()) {
				System.out.println("divisibleByTwoList.size() "+divisibleByTwoList.size());
				product *= divisibleByTenList.get(maxElementCount++);
			}
		}
		
		System.out.println("Line #77 | product : "+product/10);
		//int quotient = product/10;
		while(product%10 == 0 && product/10 != 0) {
			System.out.println("maxZeroCount"+maxZeroCount);
			product /= 10;
			maxZeroCount++;
		}
		System.out.println("Line #81");
		return maxZeroCount;
	}

	private Map<Integer, List<Integer>> generateDivisibleByTwoProduct(List<Integer> divisibleByTwoList) {
		Map<Integer,List<Integer>> divisbleByTwoNumsProductMap = new HashMap<>();
		int product = 1;
		for(int loopIndex = 0 ; loopIndex < divisibleByTwoList.size() ; loopIndex++) {
			product *= divisibleByTwoList.get(loopIndex);
		}
		divisbleByTwoNumsProductMap.put(product, divisibleByTwoList);
		return divisbleByTwoNumsProductMap;
	}

	private Map<Integer, List<Integer>> generateDivisibleByFiveProduct(List<Integer> divisibleByFiveList) {
		Map<Integer,List<Integer>> divisbleByFiveNumsProductMap = new HashMap<>();
		int product = 1;
		for(int loopIndex = 0 ; loopIndex < divisibleByFiveList.size() ; loopIndex++) {
			product *= divisibleByFiveList.get(loopIndex);
		}
		divisbleByFiveNumsProductMap.put(product, divisibleByFiveList);
		return divisbleByFiveNumsProductMap;
	}

	private Map<Integer, List<Integer>> generateDivisibleByTenProduct(List<Integer> divisibleByTenList) {
		Map<Integer,List<Integer>> divisbleByTenNumsProductMap = new HashMap<>();
		int product = 1;
		for(int loopIndex = 0 ; loopIndex < divisibleByTenList.size() ; loopIndex++) {
			product *= divisibleByTenList.get(loopIndex);
		}
		divisbleByTenNumsProductMap.put(product, divisibleByTenList);
		return divisbleByTenNumsProductMap;
	}
}