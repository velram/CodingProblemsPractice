package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerOverflowTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(1101513929, 1315634022));
		
		System.out.println("sum is :"+ (1101513929+1315634022));
		System.out.println("Integer max : "+Integer.MAX_VALUE);
		System.out.println("13 Mod 10 " + (13 % 10));
		System.out.println("14 Div 10 " + (7/ 10));
	}

}
