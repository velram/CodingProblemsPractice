package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Velmurugan Moorthy This program is a solution for pascal triangle
 *         problem. Please find the leetcode question given below for which
 *         we're trying to find a solution
 *         https://leetcode.com/problems/pascals-triangle/description/
 */
public class PascalTriangleTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pascalTriangleSize = 7;
		PascalTriangleGenerator triangleGenerator = new PascalTriangleGenerator();
		List<List<Integer>> pascalTriangle = triangleGenerator.generate(pascalTriangleSize);
		triangleGenerator.displayPascalTriangle(pascalTriangle);
	}

}

class PascalTriangleGenerator {
	
	public List<List<Integer>> generate(int numRows){
	
		List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
		int row = 0; 
		int column = 0;
		List<Integer> triangleRow = new ArrayList<>();
		if(numRows <= 0) {
			return pascalTriangle;
		}
		do {
			//System.out.println("row : "+row + "column : "+column);
			if(row == column) {
				triangleRow.add(1);
				pascalTriangle.add(triangleRow);
				triangleRow = new ArrayList<>();
				row++;
				column = 0;
			}
			else if(column == 0) {
				triangleRow.add(1);
				column++;
				//continue;
			}
			else {
				Integer leftColumn = null; 
				Integer rightColumn = null;
				leftColumn = pascalTriangle.get(row-1).get(column-1);
				rightColumn = pascalTriangle.get(row-1).get(column);
				if(null != leftColumn) {
					if(null != rightColumn) {
						triangleRow.add(leftColumn+rightColumn);
					}
					else {
						triangleRow.add(leftColumn+0);
					}
				}
				column++;
			}
		}while(pascalTriangle.size() < numRows);
		
		return pascalTriangle;
	}
	
	public void displayPascalTriangle(List<List<Integer>> pPascalTriangle) {
		System.out.println("Pascal Triangle is : START");
		for (Iterator pascalTriangleRowIterator = pPascalTriangle.iterator(); pascalTriangleRowIterator.hasNext();) {
			List<Integer> pascalTriangleRow = (List<Integer>) pascalTriangleRowIterator.next();
			for (Iterator pascalTriangleColumnIterator = pascalTriangleRow.iterator(); pascalTriangleColumnIterator.hasNext();) {
				Integer pascalTriangleColumn = (Integer) pascalTriangleColumnIterator.next();
				System.out.print(pascalTriangleColumn+" ");
			}
		  System.out.println();
		}
		System.out.println("Pascal Triangle is : END");
	}
}
