/**
 * 
 */
package com.hackerrank.practice.algorithms.sorting.quicksort;

/**
 * @author velmurugan.moorthy
 * Problem : Quick sort part-1 (Partitioning alone)
 * HackerRank question URL : https://www.hackerrank.com/challenges/quicksort1/problem
 *
 */
public class QuickSortMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PartitionManager partitioner = new PartitionManager();
		
		int[] inputArray = {5,7,4,3,8}; //Test #1 - Normal test case
		//int[] inputArray = {1,1,1,1,1,1}; //Test #2 -  All inputs are 1
		//int[] inputArray = {0,0,0,0,0};//Test #3 - All inputs are 0
		//int[] inputArray = {-1,-1,-1,-1,-1};//Test #4 - All inputs are -1
		//int[] inputArray = {-5, -7, -4, -3, -8};//Test #5 - All inputs are negative values
		//int[] inputArray = {1,2,3,4,5}; //Test #6 - Already sorted
		//int[] inputArray = {5,4,3,2,1}; //Test #7 - Descending order
		
		partitioner.performPartition(inputArray);		
		
	}

}
