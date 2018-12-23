package com.interviewbit.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntegerIncrementerTester2 {

	public static void main(String[] args) {
		//ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(0,0,9,9,9,9,9,9));
		ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(9,9,9,9,9,9));
		//ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(0));
     System.out.println(incrementByOne(inputArray));
     
	}
	
	public static ArrayList<Integer> incrementByOne(ArrayList<Integer> pInputArray) {
		ArrayList<Integer> resultArray = new ArrayList<>();
		ArrayList<Integer> tempArray = new ArrayList<>(pInputArray.size());
		ArrayList<Integer> newArray = new ArrayList<>(pInputArray.size());
		long incrementedValue = 0; 
		int carry = 0; 
		int currentElement = 0;
		int updatedCurrentElement = 0;
		tempArray.addAll(pInputArray);
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
			tempArray.set(loopIndex, updatedCurrentElement);
			System.out.println("loopIndex : "+loopIndex);
			System.out.println("updatedCurrentElement : "+updatedCurrentElement);
			System.out.println("pInputArray : "+pInputArray);
			System.out.println("tempArray : "+tempArray);
		}
		if(carry > 0) {
			//tempArray.set(index, carry);
			newArray.add(0, carry);
			for(int loopIndex = 0; loopIndex < pInputArray.size() ; loopIndex++) {
				newArray.add(tempArray.get(loopIndex));
			}
		}
		int firstNonZeroElementIndex = 0;
		if(newArray.size() > 1) {
			for(int loopIndex = 0 ; loopIndex <newArray.size() ; loopIndex++) {
				if(newArray.get(loopIndex)  != 0) {
					firstNonZeroElementIndex = loopIndex;
					break;
				}
			}	
		}
		
		System.out.println("NonZeroElementIndex : "+firstNonZeroElementIndex);
		System.out.println("newArray : "+newArray);
		for(int loopIndex = firstNonZeroElementIndex; loopIndex < pInputArray.size() ; loopIndex++) {
			if(newArray.size() > 0) {
			resultArray.add(newArray.get(loopIndex));
			}
		   else if(tempArray.size() > 0){
				resultArray.add(tempArray.get(loopIndex));
			}
		}
		
		System.out.println("resultArray : "+resultArray);
		return resultArray;
	}
	
}
