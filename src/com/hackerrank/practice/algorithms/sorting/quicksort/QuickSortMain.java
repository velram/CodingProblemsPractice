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
		
		//int[] inputArray = {5,7,4,3,8}; //Normal test case
		//int[] inputArray = {1,1,1,1,1,1}; // All inputs are 1
		//int[] inputArray = {0,0,0,0,0};//All inputs are 0
		//int[] inputArray = {-1,-1,-1,-1,-1};//All inputs are -1
		int[] inputArray = {-5, -7, -4, -3, -8};//All inputs are negative values
		partitioner.performPartition(inputArray);
		
		
	}

}
