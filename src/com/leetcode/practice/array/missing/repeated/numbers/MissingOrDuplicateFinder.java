package com.leetcode.practice.array.missing.repeated.numbers;

public class MissingOrDuplicateFinder {
    public static void main(String[] args) {
        System.out.println("sumOfSq/sumOfNum = "+(0/1));
        Solution solutionObject = new Solution();
        int[] inputArray = {3,1,2,5,3}; // Test case #1 - All zeros - PASS
        int[] repeatedAndMissingNumber = solutionObject.repeatedNumber(inputArray);
        System.out.println("Repeated number : "+repeatedAndMissingNumber[0]);
        System.out.println("Missing number : "+repeatedAndMissingNumber[1]);
    }
}

class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int n = A.length;

        long sumOfNum = (((long) n) * ((long) n + 1)) / 2;
        long sumOfSq = (((long) n) * ((long) n + 1) * ((long) 2*n + 1)) / 6;

        System.out.println("Sum of squares : "+sumOfSq);

        for (int i=0; i < n; i++) {
            sumOfNum -= (long) A[i];
            sumOfSq -= (long) A[i] * (long) A[i];
        }

        System.out.println("Sum Of Numbers : "+sumOfNum);
        System.out.println("Sum of squares : "+sumOfSq);

        long sumNum = sumOfSq/sumOfNum;

        int missing = (int) (sumNum + sumOfNum)/2;
        int repeated = (int) (sumNum - missing);
        return new int[]{repeated, missing};
    }
}
