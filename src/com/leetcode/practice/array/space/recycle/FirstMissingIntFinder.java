package com.leetcode.practice.array.space.recycle;

/**
 * @author Velmurugan Moorthy
 * 28.11.2019
 * Find first missing positive integer
 * Question URL : https://leetcode.com/problems/first-missing-positive/submissions/
 */
public class FirstMissingIntFinder {
    public static void main(String[] args){

        Solution solutionObject = new Solution();

        //int[] inputArray = {0,0,0}; // Test case #1 - All zeros - PASS
        //int[] inputArray = {1,1,1};   // Test case #2 - All 1's (duplicate value) - PASS
        int[] inputArray = {-1,-2, -3};   // Test case #3 - All unique negative values - PASS
        //int[] inputArray = {1,2,3};   // Test case #4 - All unique negative values - PASS
        //int[] inputArray = {1};   // Test case #5 - Only one value present and it's "1" - PASS
        //int[] inputArray = {0};   // Test case #6 - Only one value present and it's "0" - PASS
        //int[] inputArray = {-1};   // Test case #7 - Only one value present and it's "-1"
        //int[] inputArray = {-32};   // Test case #8 - Only one value present and it's negative value
        //int[] inputArray = {7,8,9,11,12};   // Test case #9 - Only positive values (unique) - missing element - PASS
        //int[] inputArray = {0,2,2,1,1}; //PASS
        //int[] inputArray = {1,1,1,1,2,2,5,0}; //PASS
        int firstMissingPositiveInt = solutionObject.firstMissingPositive(inputArray);
        //System.out.println("First missing positive int : "+firstMissingPositiveInt);

    }
}

class Solution {
    public int firstMissingPositive(int[] inputArray) {

        int index = 0;
        int arraySize = inputArray.length;
        //Iterate thru the array
        while (index < arraySize ){

            //Negative integers - Ignore & move to next element
            if(inputArray[index] <= 0 ){
                index++;
            }
            else{ //Positive Integers

                //Beyond array index - Ignore & move to next element
                if(inputArray[index] >= arraySize+1){
                    index++;
                }
                //Number in correct index - Ignore & move to next element
                else if(inputArray[index] == index + 1){
                    index++;
                }
                //Duplicate element & original already exists in correct index - Ignore & move to next element
                else if(inputArray[index] == inputArray[inputArray[index] - 1]){
                    index++;
                }

                else { // Element is unique and is in an incorrect place do swap
                    swap(inputArray, index, inputArray[index]-1);
                }

            }
        }

        index = 0;

        while (index < arraySize  && inputArray[index] == (index + 1)  ){
            //System.out.println("index : "+index + " inputArray[index] : "+inputArray[index]);
            index++;
        }


        return index+1;
    }

    private void swap(int[] inputArray, int sourceIndex, int destinationIndex) {
        //System.out.println("Entering swap | sourceIndex : " + sourceIndex + " destinationIndex : "+destinationIndex);
        int tempVariable = inputArray[sourceIndex];
        inputArray[sourceIndex] = inputArray[destinationIndex];
        inputArray[destinationIndex] = tempVariable;
    }

    private void displayArray(int[] nums) {
        System.out.println("\n Printing the array");
        for (int currentElement : nums) {
            System.out.print(currentElement + " ");
        }
        System.out.println("\n displayArray() - END \n");
    }
}