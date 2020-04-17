package com.leetcode.practice.array.matrix;

/**
 * @author Velmurugan Moorthy
 * Question : Find transpose of a given matrix
 * Question URL : https://leetcode.com/problems/transpose-matrix/
 */
public class TransposeMatrixDriver {
    public static void main(String[] args) {
        MatrixTransposeTool transposeTool = new MatrixTransposeTool();
        //Test case #1 - Square matrix - Even size
      /* int[][] inputArray = {
                            {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}
                           };*/

        //Test case# 2 - Min size - Square matrix - Even size
       /* int[][] inputArray = {
                {1,2},
                {3,4}
        };*/

    //Test case #3 - Square matrix - odd size


        int[][] inputArray = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        //Test case # - Non-Square matrix -
/*

        int[][] inputArray = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };*/
        transposeTool.printArray(transposeTool.transposeMatrix(inputArray));

    }
}

class MatrixTransposeTool {
    public int[][] transposeMatrix(int[][] inputArray){
        int arrayLength = inputArray.length;
        System.out.println("Array length : "+arrayLength);


        /*
         * Steps
         * 1. Transpose the matrix
         */

        int row = 0;
        int column = row + 1;
        System.out.println("Input array before processing \n ");
        printArray(inputArray);

        //Transpose
        System.out.println();

        //while(row < (arrayLength - 2) && column < (arrayLength-1)) { // odd matrix
        while(row < (arrayLength - 1) && column < (arrayLength)) { // Even matrix
            int temp = inputArray[row][column];
            inputArray[row][column] = inputArray[column][row];
            inputArray[column][row] = temp;
            System.out.println("\n row : "+ row + " column : "+column);
            System.out.println("array[row][col] : "+ inputArray[row][column]);
            System.out.println("array[col][row]: "+ inputArray[column][row]);
            column++;
            if(column == (arrayLength)){
                column = row + 1;
                row++;
            }
        }
        System.out.println("\n Transpose of input matrix is : ");
        printArray(inputArray);
        return inputArray;
    }

    public void printArray(int[][] inputArray) {
        int row = 0;
        int column = 0;
        int arrayLength = inputArray.length;
        //Solution to iterate thru 2D array with O(n) time
        while (row < arrayLength  && column < arrayLength ){
            System.out.print(inputArray[row][column++] + " ");
            if(column == arrayLength){
                column = 0;
                row++;
                System.out.println();
            }
        }
    }
}
