package com.leetcode.practice.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This is solution to the Leetcode problem "Set Matrix zeroes"
 * Problem URL : https://leetcode.com/problems/set-matrix-zeroes/
 */
public class ZeroMatrixTester {
    public static void main(String[] args) {

        //int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}}; //Test case #1 - Normal test case
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}}; //Test case #2 - Normal test case
        /*
        [0,1,2,0],
        [3,4,5,2],
        [1,3,1,5]
         */
        Solution solutionObject = new Solution();
        solutionObject.displayInputArray(matrix);
        solutionObject.setZeroes(matrix);
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = 0;
        int column = 0;
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;

        Map<String, Set<Integer>> zeroValRowColMap = new HashMap<>();
        Set<Integer> zeroValueRows = new HashSet<>();
        Set<Integer> zeroValueColumns = new HashSet<>();

        System.out.println("While entering method | rowSize : "+rowSize + " columnSize : "+columnSize);

        displayInputArray(matrix);

        //Step #1 - Parse thru array
        while(row < rowSize && column < columnSize){
            System.out.println("While entering loop | row : "+row + " column : "+column);
            //Step #2 - Prepare collection of rows & columns
            if(matrix[row][column] == 0){
                zeroValueColumns.add(column);
                zeroValueRows.add(row);
                System.out.println("ZeroValue columns : "+zeroValueColumns + " ZeroValueRows : "+zeroValueRows);
            }
             //Increment column
                if(column < columnSize - 1  && row < rowSize){
                    column++;
                }
                //Increment row & reset column
                else if(column == columnSize -1 && row < rowSize){
                    column = 0;
                    row++;
                }
            System.out.println("While exiting loop | row : "+row + " column : "+column +"\n");
        }
        zeroValRowColMap.put("rows",zeroValueRows);
        zeroValRowColMap.put("columns",zeroValueColumns);

        //Step #3 - Populate matrix with zeros

    }

    public void displayInputArray(int[][] inputArray){
        for(int row = 0 ; row < inputArray.length ; row++){
            for(int column = 0 ; column < inputArray[row].length ; column++){
                System.out.print(inputArray[row][column] +" ");
            }
            System.out.println();
        }
    }
}