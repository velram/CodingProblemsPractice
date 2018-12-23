package com.interviewbit.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntegerIncrementerTester {

	public static void main(String[] args) {
		//ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(0,0,9,9,9,9,9,9));
		ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(0,9,9,9,9,9));
     IntegerIncrementer integerIncrementerObject = new IntegerIncrementer();
     integerIncrementerObject.incrementByOne(inputArray);
     
	}
}

class IntegerIncrementer {
	
	Map<Integer,Integer> decimalPositionValueMap = new HashMap<>();
	
	public IntegerIncrementer() {
		populateDecimalPositionValueMap();
	}
	
	public long incrementByOne(ArrayList<Integer> pInputArray) {
		long incrementedValue = 0; 
		int carry = 0; 
		int decimalPoint = 0;
		int currentElement = 0;
		int updatedCurrentElement = 0;
		Map<Integer,Integer> decimalPointElementMap = new HashMap<>();
		for(int loopIndex = pInputArray.size()-1; loopIndex >= 0 ; loopIndex--) {
			if(loopIndex == pInputArray.size() -1) {
				currentElement = pInputArray.get(loopIndex);		
				updatedCurrentElement = (currentElement + 1) % 10;
				carry = (currentElement + 1) / 10;
			}
			else {
				currentElement = pInputArray.get(loopIndex);
				 updatedCurrentElement = (currentElement + carry) % 10;
				carry = (currentElement + carry) / 10;	
			}
			decimalPointElementMap.put(decimalPoint, updatedCurrentElement);
			decimalPoint++;
			System.out.println("loopIndex : "+loopIndex);
			System.out.println("updatedCurrentElement : "+updatedCurrentElement);
			//System.out.println("decimalPointElementMap : "+decimalPointElementMap);		
		}
		System.out.println("decimalPointElementMap : "+decimalPointElementMap);
		incrementedValue = constructIncrementedInteger(decimalPointElementMap);
		System.out.println("Constructed value : "+incrementedValue);
		return incrementedValue;
	}
	
	private long constructIncrementedInteger(Map<Integer, Integer> decimalPointElementMap) {
		
		long constructedInteger = 0;
		Map<Integer,Integer> decimalPositionValueMap = this.decimalPositionValueMap;
		for(Map.Entry<Integer, Integer> currentEntry : decimalPointElementMap.entrySet()) {
			int decimalPoint = currentEntry.getKey();
			int valueInArray = currentEntry.getValue();
			System.out.println("Decimal point index : "+decimalPoint);
			System.out.println("decimalPointValue : "+decimalPositionValueMap.get(decimalPoint));
			constructedInteger += (valueInArray * decimalPositionValueMap.get(decimalPoint));
		}
		
		return constructedInteger;
	}

	public void populateDecimalPositionValueMap() {

		this.decimalPositionValueMap.put(0, 1);
		this.decimalPositionValueMap.put(1, 10);
		this.decimalPositionValueMap.put(2, 100);
		this.decimalPositionValueMap.put(3, 1000);
		this.decimalPositionValueMap.put(4, 10000);
		this.decimalPositionValueMap.put(5, 100000);
		this.decimalPositionValueMap.put(6, 1000000);
		this.decimalPositionValueMap.put(7, 10000000);
		this.decimalPositionValueMap.put(8, 100000000);
		this.decimalPositionValueMap.put(9, 1000000000);
		
	}
}
