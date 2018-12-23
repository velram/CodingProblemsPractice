package com.interviewbit.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntegerIncrementerTester3 {

	public static void main(String[] args) {
		//ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(0,0,9,9,9,9,9,9));
		//ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
		int[] inputArray = {0,0,0,0,0,0};
     incrementByOne(inputArray);
     
	}
	
	public static int[] incrementByOne(int[] digits) {
		ArrayList<Integer> resultArrayList = new ArrayList<>();
		ArrayList<Integer> pInputArray = new ArrayList(Arrays.asList(digits));
		ArrayList<Integer> tempArrayList = new ArrayList<>(pInputArray.size());
		long incrementedValue = 0; 
		int carry = 0; 
		int currentElement = 0;
		int updatedCurrentElement = 0;
		int[] resultArray = new int[pInputArray.size()];
		tempArrayList.addAll(pInputArray);
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
			tempArrayList.set(loopIndex, updatedCurrentElement);
			/*System.out.println("loopIndex : "+loopIndex);
			System.out.println("updatedCurrentElement : "+updatedCurrentElement);
			System.out.println("pInputArray : "+pInputArray);
			System.out.println("tempArray : "+tempArray);*/
		}
		int firstNonZeroElementIndex = 0;
		for(int loopIndex = 0 ; loopIndex <tempArrayList.size() ; loopIndex++) {
			if(tempArrayList.get(loopIndex)  != 0) {
				firstNonZeroElementIndex = loopIndex;
				break;
			}
		}
		//System.out.println("NonZeroElementIndex : "+firstNonZeroElementIndex);
		int arrayIndex = 0;
		for(int loopIndex = firstNonZeroElementIndex; loopIndex < pInputArray.size() ; loopIndex++) {
			resultArrayList.add(tempArrayList.get(loopIndex));
			resultArray[arrayIndex++] = tempArrayList.get(loopIndex);
		}
		//System.out.println("resultArray : "+resultArray[0]);
		return resultArray;
	}
	
}
