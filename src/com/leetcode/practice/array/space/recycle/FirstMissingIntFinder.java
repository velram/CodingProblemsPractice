package com.leetcode.practice.array.space.recycle;

import java.util.Arrays;

public class FirstMissingIntFinder {
    public static void main(String[] args){

        Solution solutionObject = new Solution();

        //int[] inputArray = {0,0,0}; // Test case #1 - All zeros - PASS
        //int[] inputArray = {1,1,1};   // Test case #2 - All 1's (duplicate value) - PASS
        //int[] inputArray = {-1,-2, -3};   // Test case #3 - All unique negative values - PASS
        //int[] inputArray = {1,2,3};   // Test case #4 - All unique negative values - PASS
        //int[] inputArray = {1};   // Test case #5 - Only one value present and it's "1" - PASS
        //int[] inputArray = {0};   // Test case #6 - Only one value present and it's "0" - PASS
        int[] inputArray = {-1};   // Test case #7 - Only one value present and it's "-1"
        //int[] inputArray = {-32};   // Test case #8 - Only one value present and it's negative value
        //int[] inputArray = {7,8,9,11,12};   // Test case #9 - Only positive values (unique) - missing element - PASS
        solutionObject.firstMissingPositive(inputArray);

    }
}

class Solution {

    public int firstMissingPositive(int[] nums) {

        int firstMissingPositiveInt = 0;
        //Step #1 - sort array
        Arrays.sort(nums);
        displayArray(nums);

        //Step #2 - Create new array with sorted postive ints oly
        int[] sortedPositiveArray = populateSortedArray(nums);
        displayArray(sortedPositiveArray);

        //Step #3 - Compare values from 1 to n
        firstMissingPositiveInt = findFirstMissingPositiveInt(sortedPositiveArray);

        System.out.println("First missing positive integer is : "+firstMissingPositiveInt);
        return firstMissingPositiveInt;
    }

    private int findFirstMissingPositiveInt(int[] sortedPositiveArray) {
        int firstMissingPositiveInt = 0;
        int arraySize = sortedPositiveArray.length;
        for (int loopIndex = 0; loopIndex < arraySize; loopIndex++) {
            if((loopIndex + 1) != sortedPositiveArray[loopIndex]){
                firstMissingPositiveInt = (loopIndex + 1);
                break;
            }
        }
        // If no value is missing return last index + 1
        if(firstMissingPositiveInt == 0){
            firstMissingPositiveInt = sortedPositiveArray[arraySize-1] + 1;
        }
        return firstMissingPositiveInt;
    }

    private int[] populateSortedArray(int[] nums) {
        int[] positiveValArray = new int[nums.length];
        int positiveIntCount = 0;
        for (int loopIndex = 0; loopIndex < nums.length; loopIndex++) {
            if(nums[loopIndex] > 0){
                positiveValArray[positiveIntCount++] = nums[loopIndex];
            }
        }
        return positiveValArray;
    }

    private void displayArray(int[] nums) {
        System.out.println("\n Printing the array");
        for (int currentElement : nums) {
            System.out.print(currentElement + " ");
        }
        System.out.println("\n displayArray() - END \n");
    }
}
