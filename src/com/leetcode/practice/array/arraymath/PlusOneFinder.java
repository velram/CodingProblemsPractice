package com.leetcode.practice.array.arraymath;

/**
 * @author - Velmurugan Moorthy
 * 12.12.2019
 * Question URL : https://leetcode.com/problems/plus-one/
 */
public class PlusOneFinder {
    public static void main(String[] args) {

        //int[] inputArray = {0}; //Test case #1 - Only one element, tat too zero - PASS
        //int[] inputArray = {1,2,3}; //Test case #2 - Happy flow - PASS
        //int[] inputArray = {9,9,9}; // Test case #3 - Edge case - all elements are '9' - PASS
        //int[] inputArray = {0,0,0}; //Test case #4 - All elements are zero - PASS
        int[] inputArray = {1,8,9}; // Test case #3 - Edge case - only LSB is '9' - PASS
        //int[] inputArray = {9}; //Test case #1 - Only one element, tat too '9' - PASS
        Solution solutionObject = new Solution();
        int[] result = solutionObject.plusOne(inputArray);
        solutionObject.displayArray(result);
    }
}


class Solution {
    public int[] plusOne(int[] digits) {

        if(null == digits || digits.length == 0){
            return digits;
        }

        int arraySize = digits.length;
        int[] resultArray = new int[arraySize + 1];
        int carry = 0;

        /*
          * If the L.S.B is not 9, calculation is easy.
          * For, there'll be no change in the other elements.
          * Just add 1 to last element and return the array.
         */
        if(digits[arraySize - 1] != 9){
            digits[arraySize - 1] = digits[arraySize - 1] + 1;
            return digits;
        }

        /*
         * If the LSB i.e., last element is '9'
         * We had to carry '1' to the next elements
         * If the next elements are not '9' the calculation is easy.
         * But, if it's '9' we had to carry '1'
         */
        for (int loopIndex = arraySize - 1; loopIndex >= 0; loopIndex--) {

            if(digits[loopIndex] != 9){
                //digits[loopIndex] = digits[loopIndex] + carry;
                if(digits[0] == 9){
                    resultArray[loopIndex + 1] = digits[loopIndex] + carry;
                }
                else {
                    resultArray[loopIndex + 1] = digits[loopIndex] + carry;
                }

                carry = 0;
                //return resultArray;
            }
            else{
                if(loopIndex != 0){
                    resultArray[loopIndex + 1] = 0;
                    carry = 1;
                }
                else {
                    resultArray[loopIndex + 1] = 0;
                    resultArray[loopIndex] = 1;
                }
            }
        }

     return  resultArray;
    }

    public void displayArray(int[] inputArray){

        for ( int currentElement:
             inputArray) {
            System.out.println(currentElement);
        }
    }

}