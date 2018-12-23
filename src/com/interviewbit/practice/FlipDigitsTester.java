package com.interviewbit.practice;

public class FlipDigitsTester {

	public static void main(String[] args) {
		DigitsFlipper digitsFlipperObject = new DigitsFlipper();
		//String inputString = "01010";
		//String inputString = "0";
		//String inputString = "010";
		//String inputString = "111";
		//String inputString = "1101010001";
		//String inputString = "0000000000";
		  String inputString = "1111111111";
		//System.out.println("Total number of zeros in inputString  : "+inputString.indexOf("0"));
		int[] leftRightIndices = digitsFlipperObject.findLeftRightIndices(inputString);
		System.out.println(leftRightIndices[0]);
		System.out.println(leftRightIndices[1]);
	}
}

class DigitsFlipper {
	
 
	public int[] findLeftRightIndices(String pInputString) {
		
		int[] leftRightIndices = new int[2];
		int currentLeftIndex = -1;
		int currentRightIndex = -1; 
		int finalLeftIndex = 0;
		int finalRightIndex = 0;
		int maxZeroCount = 0; 
		int currentZeroCount = 0;
		
		char[] inputChars = pInputString.toCharArray();
		if(pInputString.indexOf("0") == -1) {
			//System.out.println("Input has no Zeros");
			return new int[]{};
		}
		else if (pInputString.length() < 2) {
			return new int[]{1,1};
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
		
		leftRightIndices[0] = finalLeftIndex;
		leftRightIndices[1] = finalRightIndex;
		
		return leftRightIndices;
	}
}