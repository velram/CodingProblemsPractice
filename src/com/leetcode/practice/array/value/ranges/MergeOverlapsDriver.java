package com.leetcode.practice.array.value.ranges;

import java.util.Arrays;

/**
 * @author Velmurugan Moorthy
 * 06.12.2019
 *
 */
public class MergeOverlapsDriver {
    public static void main(String[] args) {
        //int[][] inputArray = {}; // Test case #1 - empty array - PASS
        //int[][] inputArray = {{1,2}}; // Test case #2 - only one set - PASS
        int[][] inputArray = {{1,3},{2,6},{8,10},{15,18}};
        Solution solutionObject = new Solution();
        int[][] mergedArray = solutionObject.merge(inputArray);
        solutionObject.displayArray(inputArray);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] mergedIntervals = null;

        //case #1 - empty array
        if(null == intervals || intervals.length == 0){
            return null;
        }

        int rowSize = intervals.length;
        System.out.println("row size : "+rowSize);
        //case #2 - only one row
        if(rowSize == 1){
            return  intervals;
        }

        int columnSize = intervals[0].length;
        int mergedArrayRowIndex = 0;
        int mergerArrayColumnIndex = 0;
        mergedIntervals = new int[rowSize][columnSize];
        int rowIndex = 0;

        while (rowIndex < rowSize && mergedArrayRowIndex < rowSize){
            System.out.println("rowIndex : " + rowIndex +
                    " intervals[rowIndex][1] : "
                    +intervals[rowIndex][1]
                    + " intervals[rowIndex+1][0] "
                    + intervals[rowIndex+1][0]);
            if(intervals[rowIndex][1] >= intervals[rowIndex+1][0]){
                //merge
                mergedIntervals[mergedArrayRowIndex][0] = intervals[rowIndex][0];
                mergedIntervals[mergedArrayRowIndex++][1] = intervals[rowIndex+1][1];
                if(rowIndex + 2 <= (rowSize - 1)){
                    rowIndex +=2;
                }
                else {
                    rowIndex++;
                }
            }
            else {
                rowIndex++;
            }
        }

        return mergedIntervals;
    }

    public void displayArray(int[][] inputArray){
        for(int rowIndex = 0 ; rowIndex < inputArray.length ; rowIndex++){
            for(int columnIndex = 0; columnIndex < inputArray[0].length; columnIndex++){
                System.out.println(inputArray[rowIndex][columnIndex]);
            }
        }
    }
}