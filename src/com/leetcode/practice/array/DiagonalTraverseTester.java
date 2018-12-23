/**
 * 
 */
package com.leetcode.practice.array;

/**
 * @author Velmurugan Moorthy
 * https://leetcode.com/problems/diagonal-traverse/description/
 * This program is to find the solution for diagonal order display of a square matrix
 */
public class DiagonalTraverseTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//int[][] inputMatrix = {};
		//int[][] inputMatrix = {{}};
		//int[][] inputMatrix = {{1}};
		//int[][] inputMatrix = {{1,2},{3,4}};
		//int[][] inputMatrix = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][] inputMatrix = {{1,2,3,4,},{5,6,7,8,},{9,10,11,12},{13,14,15,16}};
		//int[][] inputMatrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		//int[][] inputMatrix = {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
		
		// Test cases with scenario totalRows != totalColumns
		//int[][] inputMatrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
		//int[][] inputMatrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int[][] inputMatrix = {{1,2,3,4},{5,6,7,8}};
		/**
		 * Test case input - of order 10 (array with size 10 * 10)
		 * [[1,2,3,4,5,6,7,8,9,10],[11,12,13,14,15,16,17,18,19,20],[21,22,23,24,25,26,27,28,29,30],[31,32,33,34,35,36,37,38,39,40],[41,42,43,44,45,46,47,48,49,50],[51,52,53,54,55,56,57,58,59,60],[61,62,63,64,65,66,67,68,69,70],[71,72,73,74,75,76,77,78,79,80],[81,82,83,84,85,86,87,88,89,90],[91,92,93,94,95,96,97,98,99,100]]
		 */
		DiagonalTraverser diagonalTraverser = new DiagonalTraverser();
		int[] diagonalOrderMatrix = diagonalTraverser.findDiagonalOrder(inputMatrix);
		diagonalTraverser.dispalyDiagonalOrder(diagonalOrderMatrix);
	}

}

class DiagonalTraverser {

	public int[] findDiagonalOrder(int[][] matrix) {
		int inputRowSize = matrix.length;
		if(inputRowSize == 0) {
			return new int[]{};
		}
		int inputColumnSize = matrix[0].length;
		int outputArraySize = inputRowSize * inputColumnSize;
		int[] diagonalOrder = new int [outputArraySize];
		int outputIndex = 0; 
		int row = 0; 
		int column = 0; 
		int direction = 0; 
		System.out.println("inputRowSize : "+ inputRowSize + " inputColumnSize : "+inputColumnSize);
		assert inputRowSize == inputColumnSize;
		if(inputColumnSize == 0) {
			return new int[]{};
		}
		/*if(arraySize == 1) {
			diagonalOrder = matrix[0];
			return diagonalOrder;
		}*/
		System.out.println("arraySize : "+inputColumnSize);
		while(row <= (inputRowSize -1)  && column <= (inputColumnSize - 1)) {
		 System.out.println("direction : " + direction + " Row : "+row + " column : "+column + " outputIndex : "+outputIndex);	
			if(row == 0 && column == 0) {
				diagonalOrder[outputIndex++] = matrix[row][column++];
				direction = 1;
				continue;
			}
			
			//Downwards traversal
			if(direction == 1) {
			 	if(row < (inputRowSize - 1 ) && column > 0) {
			 		diagonalOrder[outputIndex++] = matrix[row++][column--];
			 	}
			 	else if(row < (inputRowSize - 1) && column == 0) {
			 		System.out.println("Inside 54 : "+outputIndex);
			 		diagonalOrder[outputIndex++] = matrix[row++][column];
			 		direction = 0;
			 	}
			 	else if(row == (inputRowSize - 1) && column > (inputColumnSize - 1) ) {
			 	 diagonalOrder[outputIndex++] = matrix[row--][column--];
			 	 direction = 0;
			 	}
			 	else if(row == (inputRowSize - 1) && column == (inputColumnSize - 1)  || (row == (inputRowSize - 1) &&  column == 0)) {
				 	 diagonalOrder[outputIndex++] = matrix[row][column++];
				 	 direction = 0;
				 }
			}
			
			//Upwards traversal
			if(direction == 0) {
				if(row > 0 && row < (inputRowSize - 1) && column < (inputColumnSize - 1)) {
					diagonalOrder[outputIndex++] = matrix[row--][column++];
				}
				else if(row == 0 && column < (inputColumnSize -1)) {
					diagonalOrder[outputIndex++] = matrix[row][column++];
					direction = 1;
				}
				else if(row == 0 && column == (inputColumnSize - 1) || row < (inputColumnSize -1 ) && column == (inputColumnSize - 1)) {
					System.out.println("Inside 73 : "+outputIndex);
					diagonalOrder[outputIndex++] = matrix[row++][column];
					direction = 1;
				}
				/*else if(row < (arraySize -1 ) && column == (arraySize - 1)) {
					diagonalOrder[outputIndex++] = matrix[row++][column];
					direction = 1;
				}*/
				else if(row == (inputRowSize -1 ) && column == (inputColumnSize - 1)) {
					diagonalOrder[outputIndex++] = matrix[row][column];
					break;
				}
			}
		}
		return diagonalOrder;
	}
	
	public void dispalyDiagonalOrder(int[] pInputMatrix) {
		System.out.println("Diagonal Order - START");
		for (int loopIndex = 0; loopIndex < pInputMatrix.length; loopIndex++) {
			System.out.print(pInputMatrix[loopIndex] + " ");
		}
		System.out.println("Diagonal Order - END");
	}
}