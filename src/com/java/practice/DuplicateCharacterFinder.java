package com.java.practice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateCharacterFinder {

	public static void main(String[] args) {

		String inputString = "geeksForGeeks";
		if(!inputString.isEmpty())
		findDuplicates(inputString);
	}

	private static void findDuplicates(String inputString) {
		
		StringBuffer uniqueString = new StringBuffer();
		Set<Character> charactersList = new HashSet<>();
		
		for(int loopIndex = 0; loopIndex < inputString.length(); loopIndex++) {
			char currentChar = inputString.charAt(loopIndex);
			if(!charactersList.contains(currentChar)) {
				charactersList.add(currentChar);
				uniqueString.append(currentChar);
			}
		}
		System.out.println(uniqueString.toString());
	}

}
