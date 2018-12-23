package com.interviewbit.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Velmurugan Moorthy
 *         https://www.interviewbit.com/problems/anti-diagonals/ This program is
 *         to find the solution for diagonal order display of a square matrix
 */

public class DiagonalTraverseTester3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[][] inputMatrix = {};
		// int[][] inputMatrix = {{}};
		// int[][] inputMatrix = {{1}};
		// int[][] inputMatrix = {{1,2},{3,4}};
		ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> innerList = new ArrayList<>();
		innerList.add(1);
		innerList.add(2);
		innerList.add(3);
		group.add(innerList);
		 innerList = new ArrayList<>();
			innerList.add(4);
			innerList.add(5);
			innerList.add(6);
		group.add(innerList);
		innerList = new ArrayList<>();
		innerList.add(7);
		innerList.add(8);
		innerList.add(9);
		group.add(innerList);
		// int[][] inputMatrix = {{1,2,3,4,},{5,6,7,8,},{9,10,11,12},{13,14,15,16}};
		// int[][] inputMatrix =
		// {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		// int[][] inputMatrix =
		// {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
		// row != column
		//int[][] inputMatrix = { { 1 }, { 2, 3 } };
		/**
		 * Test case input - of order 10 (array with size 10 * 10)
		 * [[1,2,3,4,5,6,7,8,9,10],[11,12,13,14,15,16,17,18,19,20],[21,22,23,24,25,26,27,28,29,30],[31,32,33,34,35,36,37,38,39,40],[41,42,43,44,45,46,47,48,49,50],[51,52,53,54,55,56,57,58,59,60],[61,62,63,64,65,66,67,68,69,70],[71,72,73,74,75,76,77,78,79,80],[81,82,83,84,85,86,87,88,89,90],[91,92,93,94,95,96,97,98,99,100]]
		 */
		DiagonalArrayListTraverser diagonalTraverser = new DiagonalArrayListTraverser();
		 ArrayList<ArrayList<Integer>> diagonalOrderMatrix = diagonalTraverser.findDiagonalOrder(group);
		diagonalTraverser.dispalyDiagonalOrder(diagonalOrderMatrix);
	}
}

class DiagonalArrayListTraverser {
	public ArrayList<ArrayList<Integer>> findDiagonalOrder(ArrayList<ArrayList<Integer>> matrix) {
		int inputRowSize = matrix.size();
		if (inputRowSize == 0) {
			return new ArrayList<>();
		}
		int inputColumnSize = matrix.get(0).size();
		int outputArraySize = inputRowSize * inputColumnSize;
		ArrayList<ArrayList<Integer>> outputArray = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> diagonalElements = new ArrayList<>();
		int outputIndex = 0;
		int row = 0;
		int column = 0;
		int direction = 0;
		//System.out.println("inputRowSize : " + inputRowSize + " inputColumnSize : " + inputColumnSize);
		assert inputRowSize == inputColumnSize;
		if (inputColumnSize == 0) {
			return new ArrayList<>();
		}
		/*
		 * if(arraySize == 1) { diagonalOrder = matrix[0]; return diagonalOrder; }
		 */
		//System.out.println("arraySize : " + inputColumnSize);
		while (row <= (inputRowSize - 1) && column <= (inputColumnSize - 1)) {
			/*System.out.println("direction : " + direction + " Row : " + row + " column : " + column + " outputIndex : "
					+ outputIndex);*/
			if(row < (inputRowSize - 1) && column > 0 && column < (inputColumnSize - 1)) {
				diagonalElements.add(matrix.get(row++).get(column--));
			}
			else if(row < (inputRowSize - 1) && column == 0) {
				diagonalElements.add(matrix.get(row).get(column));
				column = row+1;
				row = 0;
				outputArray.add(diagonalElements);
				diagonalElements = new ArrayList<>();
			}
			else if( row < (inputRowSize - 1) && column == (inputColumnSize - 1)) {
				diagonalElements.add(matrix.get(row++).get(column--));
				//outputArray.add(diagonalElements);
				//diagonalElements = new ArrayList<>();
			}
			
			else if(row == (inputRowSize - 1) && column < (inputColumnSize - 1)) {
				diagonalElements.add(matrix.get(row).get(column));
				row = column + 1; 
				column = (inputColumnSize - 1);
				outputArray.add(diagonalElements);
				diagonalElements = new ArrayList<>();
			}
			else if(row == (inputRowSize - 1) && column == (inputColumnSize - 1)) {
				diagonalElements.add(matrix.get(row).get(column));
				outputArray.add(diagonalElements);
				diagonalElements = new ArrayList<>();
				break;
			}
		}
		return outputArray;
	}

	public void dispalyDiagonalOrder(ArrayList<ArrayList<Integer>>   pInputMatrix) {
		System.out.println("Diagonal Order - START");
		
		for (Iterator outerListIterator = pInputMatrix.iterator(); outerListIterator.hasNext();) {
			ArrayList<Integer> innerList = (ArrayList<Integer>) outerListIterator.next();
			for (Iterator innerListIterator = innerList.iterator(); innerListIterator.hasNext();) {
				Integer currentElement = (Integer) innerListIterator.next();
				System.out.print(currentElement+ " ");
			}
			System.out.println();
		}
		
		/*for (int loopIndex = 0; loopIndex < pInputMatrix.size(); loopIndex++) {
			//System.out.print(pInputMatrix[loopIndex] + " ");
			System.out.print(pInputMatrix.get(loopIndex) + " ");
		}*/
		System.out.println("Diagonal Order - END");
	}
}