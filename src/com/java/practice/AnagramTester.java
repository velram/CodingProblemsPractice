package com.java.practice;

import java.util.Arrays;

public class AnagramTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstString = "army";
		String secondString = "ymra";
		int MAX_NO_CHARS = 256; 
		anagrams(firstString,secondString);
	}
	
	public static boolean anagrams(String s,String t)
	{
	    if (s.length() != t.length())
	        return false;
	    int letters[] = new int[256];
	    Arrays.fill(letters, 0);
	    System.out.println(letters[s.charAt(0)]);
	    /*for(int i=0;i<s.length();i++)
	    {
	        letters[s[i]]++;
	        letters[t[i]]--;
	    }
	    for (int i = 0; i < 256; i++)
	    {
	        if(letters[i])
	            return false;
	    }*/
	    return true;
	}

}
