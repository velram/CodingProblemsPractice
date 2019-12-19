package com.interviewbit.practice.array.arraymath;

/**
 * @author Velmurugan Moorthy
 * 13.12.2019
 * Question URL : https://www.interviewbit.com/problems/add-one-to-number/
 */
public class AddOneToNumber {
    public static void main(String[] args) {
        //int[] inputArray = {0}; //Test case #1 - Only one element, tat too zero - PASS
        //int[] inputArray = {1,2,3}; //Test case #2 - Happy flow - PASS
        //int[] inputArray = {9,9,9}; // Test case #3 - Edge case - all elements are '9' - PASS
        //int[] inputArray = {0,0,0}; //Test case #4 - All elements are zero - PASS
        //int[] inputArray = {1,8,9}; // Test case #5 - Edge case - only LSB is '9' - PASS
        //int[] inputArray = {9}; //Test case #6 - Only one element, tat too '9' - PASS
        //int[] inputArray = {2,4,9,3,9}; //Test case #7 - Edge case if any one of the digits in the middle has '9'
        /*
           Test case #8 - Edge case
            if any one of the digits in the middle has '9'
            and MSB is '9' with no carry prior to it
         */
        int[] inputArray = {9,4,9,3,9};
        Solution solutionObject = new Solution();
        int[] resultArray = solutionObject.plusOne(inputArray);
        solutionObject.displayArray(resultArray);

    }
}

class Solution {
    public int[] plusOne(int[] digits) {

        for( int loopIndex = digits.length - 1 ; loopIndex >= 0 ; loopIndex--){
            if(digits[loopIndex] < 9){
                digits[loopIndex]++;
                return  digits;
            }
            digits[loopIndex] = 0;
        }
        int newArray[] = new int[digits.length + 1];
        newArray[0] = 1;
        return newArray;
    }

    public void displayArray(int[] inputArray){

        for ( int currentElement:
                inputArray) {
            System.out.println(currentElement);
        }
    }

}
