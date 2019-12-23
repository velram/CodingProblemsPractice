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

        if(null == digits || digits.length == 0)
            return null;

        int arraySize = digits.length;
        int[] result = null;
        int carry = 1;

        // Add carry to number

        for (int loopIndex = arraySize - 1; loopIndex >= 0 ; loopIndex--) {
            System.out.println(" START | carry : " + carry + " | digits[loopIndex] " + digits[loopIndex]);
            int sum = digits[loopIndex] + carry;
            digits[loopIndex] = sum % 10;
            carry = sum / 10;
            System.out.println(" END | carry : " + carry + " | digits[loopIndex] " + digits[loopIndex] + "\n");
        }


        // If the MSB carry is greater than '0' then create new array with increased size

        if(carry > 0){
         int[] extendedArray = new int[arraySize + 1];
          extendedArray[0] = carry;
          int extendedArraySize = extendedArray.length;
          for(int loopIndex = 1; loopIndex < extendedArraySize ; loopIndex++ ){
              extendedArray[loopIndex] = digits[loopIndex - 1];
          }

            System.out.println(" extended array : ");
          displayArray(extendedArray);
            System.out.println();
          return  extendedArray;
        }

        // If the last carry is '0' Go ahead with filtering zeros at MSB
        else {

            int msbZeroCount = 0;

            while (digits[msbZeroCount] == 0){
                msbZeroCount++;
            }
            result = new int[arraySize - msbZeroCount];
            for (int loopIndex = msbZeroCount; loopIndex < arraySize; loopIndex++) {
                result[loopIndex - msbZeroCount] = digits[loopIndex];
            }
            displayArray(result);
            System.out.println();
        }

        return result;
    }

    public void displayArray(int[] inputArray){

        for ( int currentElement:
                inputArray) {
            System.out.println(currentElement);
        }
    }

}
