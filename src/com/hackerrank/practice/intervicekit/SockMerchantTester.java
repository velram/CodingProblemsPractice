/**
 * 
 */
package com.hackerrank.practice.intervicekit;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Velmurugan Moorthy
 * 
 * This program tries to solve the HackerRank problem given below
 * Question URL : https://www.hackerrank.com/challenges/sock-merchant/problem
 *
 */
public class SockMerchantTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Scanner inputReader = new Scanner(System.in);
		int socksCount = inputReader.nextInt();
		int[] socksColors = new int[socksCount];
		SockMerchant sockMerchantObject = new SockMerchant();
		
		for(int loopIndex = 0; loopIndex < socksCount ; loopIndex++) {
			socksColors[loopIndex] = inputReader.nextInt();
		}
		
		sockMerchantObject.findPairs(socksCount, socksColors);
		//System.out.println(" 9/2 is : " + (9/2));
	}
}


class SockMerchant {
	public int findPairs(int socksCount, int[] socksColors) {
		int pairCount = 0; 
		Map<Integer,Integer> sockColorFrequencyMap = new HashMap<>();
		for(int loopIndex = 0 ; loopIndex < socksCount ; loopIndex++) {
			if(sockColorFrequencyMap.containsKey(socksColors[loopIndex])) {
				int frequency = sockColorFrequencyMap.get(socksColors[loopIndex]);
				sockColorFrequencyMap.put(socksColors[loopIndex], frequency+1);
			}
			else {
				sockColorFrequencyMap.put(socksColors[loopIndex], 1);
			}
		}

		for(Map.Entry<Integer, Integer> sockColorFreqMapEntry : sockColorFrequencyMap.entrySet()) {
			pairCount += (sockColorFreqMapEntry.getValue()/2);
		}
		
		/*System.out.println("Map : "+sockColorFrequencyMap);
		System.out.println("pairCount : "+pairCount);*/
		return pairCount;
	}
}