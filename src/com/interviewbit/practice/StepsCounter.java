package com.interviewbit.practice;

public class StepsCounter {

	private static int ERROR = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int destination = 6;

		System.out.println("Minimum steps to destination : "+destination + " is : " + countSteps(0, 0, destination));
	}

	public static int countSteps(int pSource, int pSteps, int pDestination) {

		System.out.println("No Condition : pSource : " + pSource);
		System.out.println("No Condition : pDestination : " + pDestination);
		System.out.println("No Condition : pSteps : " + pSteps);
		
		if (Math.abs(pSource) > (pDestination)) {
			System.out.println("Condition 1 : pSource : " + Math.abs(pSource));
			System.out.println("Condition 1 : pDestination : " + pDestination);
			return ERROR;
		}
		
		if(pSource == pDestination) {
			System.out.println("Condition 2 : pSource : " + pSource);
			System.out.println("Condition 2 : pDestination : " + pDestination);
			System.out.println("Condition 2 : pSteps : " + pSteps);
			return pSteps;
		}
		int forwardSteps = countSteps(pSource + pSteps + 1, pSteps + 1, pDestination);

		int backwardSteps = countSteps(pSource - pSteps - 1, pSteps + 1, pDestination);
		
		System.out.println("forwardSteps : "+forwardSteps + " backwardSteps : "+backwardSteps);
		return Math.min(forwardSteps, backwardSteps);
	}

}
