package com.leetcode.practice.array.missing.repeated.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Velmurugan Moorthy
 * 03.12.2019
 * Question URL : https://leetcode.com/problems/majority-element-ii/
 *
 */
public class MajorityElementsFinder {
    public static void main(String[] args) {
        MajorityElementsSolution majorityElementsSolution = new MajorityElementsSolution();
        //int[] inputArray = {}; //Test case #1 - empty array - PASS
        //int[] inputArray = {1}; //Test case #2 - only one element - PASS
        //int[] inputArray = {3,2,3}; //Test case #3 - Normal inputs
        int[] inputArray = {1,1,1,3,3,2,2,2}; //Test case #4 - Normal inputs

       List<Integer> majorityElements = majorityElementsSolution.majorityElement(inputArray);

       int majorityThreshold = inputArray.length / 3;
       float floatMajorityThreshold = inputArray.length / 3;
        System.out.println("int Majority threshold : " + majorityThreshold);
        System.out.println("float Majority threshold : " + floatMajorityThreshold);
        System.out.println(" \n Main() - Final list of majority elements are : ");
        majorityElements.stream().forEach(System.out::println);
    }
}

class MajorityElementsSolution {

    public List<Integer> majorityElement(int[] inputArray) {

        List<Integer> majorityElements = new ArrayList<>();
        System.out.println("Input array : "+inputArray);

        // If empty array return the empty list
        if(inputArray == null || inputArray.length == 0){
            System.out.println("Majority elements : "+majorityElements);
            return  majorityElements;
        }

        //If array had only one element
        if(inputArray.length == 1){
            majorityElements.add(inputArray[0]);
            System.out.println("Majority elements : "+majorityElements);
            return  majorityElements;
        }

        Integer firstMajorElement = null;
        Integer secondMajorElement = null;

        int firstMajorElementCount = 0;
        int secondMajorElementCount = 0;
        final int MAJORITY_SIZE_THRESHOLD = inputArray.length / 3;
        // Step #1 - Iterate thru array
        for(int currentElement : inputArray){
            System.out.println("current element : "+currentElement);
            System.out.println("1st element : " + firstMajorElement
                    + " 1st element count : "+firstMajorElementCount);
            System.out.println("2nd element : " + secondMajorElement
                    + " 2nd element count : "+secondMajorElementCount);
            //Case 1 : First major element already exists and encountered again
            if(firstMajorElement != null
                    && currentElement == firstMajorElement.intValue()){
                firstMajorElementCount++;
            }

            //Case 2 : Second major element already exists and encountered again
            else if(secondMajorElement != null
                     && currentElement == secondMajorElement.intValue() ){
                secondMajorElementCount++;
            }

            /*Case 3 : First major element found first time
                       (or) current element assumed as first major element
             */
            else if(firstMajorElementCount ==0){
                firstMajorElement = currentElement;
                firstMajorElementCount = 1;
            }

            /*Case 4 : Second major element found first time
                       (or) current element assumend as second major element
             */

            else if(secondMajorElementCount ==0){
                secondMajorElement = currentElement;
                secondMajorElementCount = 1;
            }

            /*
              Case 5 : All above 4 cases not matched.
              So, new element encountered (not matching with 1st & 2nd)
              decrement the count of majority elements
             */
            else {
                firstMajorElementCount--;
                secondMajorElementCount--;
            }
            System.out.println();
        }

        firstMajorElementCount = secondMajorElementCount = 0;

        for (int currentElement : inputArray){
            if(currentElement == firstMajorElement.intValue()){
                firstMajorElementCount++;
            }
            else if(currentElement == secondMajorElement.intValue()){
                secondMajorElementCount++;
            }
        }

        System.out.println("1st element count : " + firstMajorElementCount
                            + " 2nd element count : " + secondMajorElement);

        if(firstMajorElementCount > MAJORITY_SIZE_THRESHOLD){
            majorityElements.add(firstMajorElement);
        }
        if(secondMajorElementCount > MAJORITY_SIZE_THRESHOLD){
            majorityElements.add(secondMajorElement);
        }

        System.out.println("Before existing majority elements method ");
        majorityElements.stream().forEach(System.out::println);
        return majorityElements;
    }
}