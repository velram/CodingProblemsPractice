package com.interviewbit.practice.array;

import java.util.*;

/**
 * @author Velmurugan Moorthy
 * 28.11.2019
 *  Question URL : https://www.interviewbit.com/problems/set-matrix-zeros/
 */
public class ZeroMatrixTester {
    public static void main(String[] args) {

        //int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}}; //Test case #1 - Normal test case wit 3*3 matrix
        //int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}}; //Test case #2 - Normal test case wit 4*4 matrix
        //int[][] matrix = {{0,1,2,1}, {3,0,5,2}, {1,3,0,5},{5,5,5,0}}; //Test case # - 4*4 matrix with diagonal as zeroes
        //int[][] matrix = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}}; //Test case # - All zero cells
        //int[][] matrix = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}}; //Test case # - No zero cells

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        //matrix.add(1,1,1,1);
        /*matrix.addAll(new int[]{1, 1, 1, 1});
        matrix.add(Arrays.asList(1,1,1,1));
        matrix.add(Arrays.asList(1,1,1,1));
        matrix.add(Arrays.asList(1,1,1,1));*/

        //ArrayList<Integer> pInputList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5),);
        Solution solutionObject = new Solution();
        solutionObject.displayMatrix(matrix);
        solutionObject.setZeroes(matrix);
        System.out.println("After populating zeros the matrix is ");
        solutionObject.displayMatrix(matrix);
    }
}

class Solution {

    public static final String ROWS_TEXT = "rows";
    public static final String COLUMNS_TEXT = "columns";

    public void setZeroes(ArrayList<ArrayList<Integer>> matrix) {

        int rowSize = matrix.size();
        if(rowSize < 0){
            return;
        }
        int columnSize = matrix.get(0).size();
        Map<String, Set<Integer>> zeroValRowColMap = fetchZeroValRowColMap(matrix, rowSize, columnSize);

        //Step #3 - Populate matrix with zeros
        populateMatrixWithZero(matrix,rowSize, columnSize, zeroValRowColMap);
    }

    private void populateMatrixWithZero(ArrayList<ArrayList<Integer>> matrix, int rowSize, int columnSize, Map<String, Set<Integer>> zeroValRowColMap) {
        System.out.println("Entering populateMatrixWithZero | rowSize : " + rowSize + " | columnSize : "+columnSize);
        int row = 0;
        int column = 0;

        //Iterate thru zero value rows ;
        Set<Integer> zeroValRows = zeroValRowColMap.get(ROWS_TEXT);
        Set<Integer> zeroValColumns = zeroValRowColMap.get(COLUMNS_TEXT);

        while(row < rowSize && column < columnSize){
            System.out.println("Entering while loop #1 | row : " + row + " | column : " + column);
            if(zeroValRows.contains(row)){
                //matrix[row][column] = 0;
                matrix.get(row).set(column,0);
            }

            if(column < columnSize - 1  && row < rowSize){
                column++;
            }
            //Move to next row & reset column
            else if(column == columnSize -1 && row < rowSize){
                column = 0;
                row++;
            }
            System.out.println("Exiting while loop #1 | row : " + row + " | column : " + column + "\n");
        }

        displayMatrix(matrix);

        row = 0;
        column = 0;
        while(row < rowSize && column < columnSize){
            System.out.println("Entering while loop #2 | row : " + row + " | column : " + column);
            if(zeroValColumns.contains(column)){
                //matrix[row][column] = 0;
                matrix.get(row).set(column,0);
            }

            if(row < rowSize - 1  && column < columnSize){
                row++;
            }

            else if(row == rowSize -1 && column < columnSize){
                row = 0;
                column++;
            }
            System.out.println("Exiting while loop #2 | row : " + row + " | column : " + column + "\n");
        }
        /*zeroValRowColMap.get(ROWS_TEXT).stream().forEach(System.out::println);
        zeroValRowColMap.get(COLUMNS_TEXT).stream().forEach(System.out :: println);*/
        System.out.println("Exiting populateMatrixWithZero");
    }

    private Map<String, Set<Integer>> fetchZeroValRowColMap(ArrayList<ArrayList<Integer>> matrix, int rowSize, int columnSize) {

        int row = 0;
        int column = 0;

        Map<String, Set<Integer>> zeroValRowColMap = new HashMap<>();
        Set<Integer> zeroValueRows = new HashSet<>();
        Set<Integer> zeroValueColumns = new HashSet<>();

        System.out.println("While entering method | rowSize : "+rowSize + " columnSize : "+columnSize);

        displayMatrix(matrix);

        //Step #1 - Parse thru array
        while(row < rowSize && column < columnSize){
            System.out.println("While entering loop | row : "+row + " column : "+column);

            //Step #2 - Prepare collection of rows & columns

            //Find zero value cells
            //if(matrix[row][column] == 0){
                if(matrix.get(row).get(column) == 0){
                zeroValueColumns.add(column);
                zeroValueRows.add(row);
                System.out.println("ZeroValue columns : "+zeroValueColumns + " ZeroValueRows : "+zeroValueRows);
            }
            //Move to next column
            if(column < columnSize - 1  && row < rowSize){
                column++;
            }
            //Move to next row & reset column
            else if(column == columnSize -1 && row < rowSize){
                column = 0;
                row++;
            }
            System.out.println("While exiting loop | row : "+row + " column : "+column +"\n");
        }
        zeroValRowColMap.put(ROWS_TEXT,zeroValueRows);
        zeroValRowColMap.put(COLUMNS_TEXT,zeroValueColumns);

        return  zeroValRowColMap;
    }

    public void displayMatrix(ArrayList<ArrayList<Integer>> inputArray){

        for(List<Integer> innerList : inputArray){
            for(Integer currentElement : innerList){
                System.out.print(currentElement + " ");
            }
            System.out.println();
        }
    }
}
