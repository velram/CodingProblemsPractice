package com.interviewbit.practice.array.arraymath;

/**
 * @author Velmurugan
 * 19.12.2019
 * Question URL : https://www.interviewbit.com/problems/maximum-absolute-difference/
 *
 */
public class MaximumAbsoluteDifferenceFinder {
    public static void main(String[] args) {

     //int[] inputArray = {}; // case #1 - empty array
     //int[] inputArray = {0}; // case #2 - only one element (non-zero)
     //int[] inputArray = {1}; // case #3 - only one element (non-zero)
     //int[] inputArray = {1,3,-1}; // case #4 - happy flow
     int[] inputArray = {55, -8, 43, 52, 8, 59, -91, -79, -18, -94}; // case #5 - random test case

     MaxAbsDiffSolution solutionObject = new MaxAbsDiffSolution();
     int result = solutionObject.maxArr(inputArray);
        System.out.println(" Max Abs diff is : " + result);
    }
}

class MaxAbsDiffSolution {
    public int maxArr(int[] inputArray) {

        if(null == inputArray || inputArray.length == 0){
            return 0; // Return 'null' or '0' based on the question's requirement
        }

        if(inputArray.length == 1){
            return inputArray[0];
        }

        int maxAbsoluteDifference = 0;

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;

        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int loopIndex = 0; loopIndex < inputArray.length; loopIndex++) {

            /*
            System.out.println("\n Max1 : " + max1 + " Min1 : " + min1
                    + " LoopIndex : " + loopIndex + " inputArray[loopIndex] : " + inputArray[loopIndex]);
            */

            max1 = Math.max(max1, inputArray[loopIndex] + loopIndex);
            min1 = Math.min(min1, inputArray[loopIndex] + loopIndex);

            //System.out.println("Max2 : " + max2 + " Min2 : " + min2);

            max2 = Math.max(max2, inputArray[loopIndex] - loopIndex);
            min2 = Math.min(min2, inputArray[loopIndex] - loopIndex);

            /*
            System.out.println("Max1 : " + max1 + " Min1 : " + min1);
            System.out.println("Max2 : " + max2 + " Min2 : " + min2);
             */
        }

        maxAbsoluteDifference = Math.max(max1 - min1, max2 - min2);

        return maxAbsoluteDifference;
    }
}
