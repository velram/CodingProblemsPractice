package com.interviewbit.practice;

import java.util.ArrayList;

public class FlipDigitsTester2 {

	public static void main(String[] args) {
		DigitsFlipper2 digitsFlipperObject = new DigitsFlipper2();
		//String inputString = "01010";
		//String inputString = "0";
		String inputString = "010";
		//String inputString = "111";
		//String inputString = "1101010001";
		//String inputString = "0000000000";
		 //String inputString = "1111111111";
		//System.out.println("Total number of zeros in inputString  : "+inputString.indexOf("0"));
		System.out.println(digitsFlipperObject.findLeftRightIndices(inputString));
	}
}

class DigitsFlipper2 {
	
 
	public ArrayList<Integer> findLeftRightIndices(String pInputString) {
		
		  ArrayList<Integer> leftRightIndices = new ArrayList<Integer>();
	        int currentLeftIndex = -1;
	        int currentRightIndex = -1; 
	        int finalLeftIndex = 0;
	        int finalRightIndex = 0;
	        int maxZeroCount = 0; 
	        int currentZeroCount = 0;
	        
	        char[] inputChars = pInputString.toCharArray();
	        if(pInputString.indexOf("0") == -1) {
	            //System.out.println("Input has no Zeros");
	            return leftRightIndices;
	        }
	        else if (pInputString.length() < 2) {
	            leftRightIndices.add(1);
	            leftRightIndices.add(1);
	            return leftRightIndices;
	        }
	        for(int loopIndex = 0; loopIndex < pInputString.length(); loopIndex++) {
	            //System.out.println("\n loopIndex : "+loopIndex);
	            /*System.out.println("\n loopIndex : "+loopIndex);
	            System.out.println("inputChars[loopIndex] : "+inputChars[loopIndex]);
	            System.out.println("currentLeftIndex : "+currentLeftIndex);
	            System.out.println("currentRightIndex : "+currentRightIndex);
	            System.out.println("currentZeroCount : "+currentZeroCount);*/

	            if(currentLeftIndex == -1 && inputChars[loopIndex] == '0') {
	                currentLeftIndex = loopIndex + 1;
	                currentZeroCount++;
	            }
	            else if(loopIndex == pInputString.length() -1 ||  currentLeftIndex != -1 && currentRightIndex == -1 && inputChars[loopIndex] == '1') {
	                currentRightIndex = (loopIndex - 1) + 1;
	                if(inputChars[loopIndex] == '0') {
	                    currentRightIndex = loopIndex + 1;
	                }
	                if(maxZeroCount < currentZeroCount ) {
	                    maxZeroCount = currentZeroCount;
	                    finalLeftIndex = currentLeftIndex;
	                    finalRightIndex = currentRightIndex;
	                }
	                else if(maxZeroCount == currentZeroCount) {
	                    if(currentLeftIndex < finalLeftIndex) {
	                        finalLeftIndex = currentLeftIndex;
	                        finalRightIndex = currentRightIndex;
	                        //currentLeftIndex = currentRightIndex = 1;
	                    }
	                    else if(currentLeftIndex == finalLeftIndex) {
	                        if(currentRightIndex < finalRightIndex) {
	                            finalLeftIndex = currentLeftIndex;
	                            finalRightIndex = currentRightIndex;
	                            //currentLeftIndex = currentRightIndex = 1;
	                        }
	                    }
	                }
	                /*System.out.println("\n loopIndex : "+loopIndex);
	                System.out.println("inputChars[loopIndex] : "+inputChars[loopIndex]);
	                System.out.println("currentLeftIndex : "+currentLeftIndex);
	                System.out.println("currentRightIndex : "+currentRightIndex);
	                System.out.println("finalRightIndex : "+finalRightIndex);
	                System.out.println("finalLeftIndex : "+finalLeftIndex);
	                System.out.println("currentZeroCount : "+currentZeroCount);
	                System.out.println("maxZeroCount : "+maxZeroCount);*/
	                currentLeftIndex = currentRightIndex = -1;
	                currentZeroCount = 0;
	            }
	            else if(inputChars[loopIndex]== '0') {
	                currentZeroCount++;
	            }
	        }
	        
	        /*leftRightIndices[0] = finalLeftIndex;
	        leftRightIndices[1] = finalRightIndex;
	        */
	        leftRightIndices.add(finalLeftIndex);
	        leftRightIndices.add(finalRightIndex);
	        
	        return leftRightIndices;
	}
}