package com.interviewbit.practice.array.missing.repeating.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Velmurugan Moorthy
 * 06.12.2019
 * Question URL : https://www.interviewbit.com/problems/n3-repeat-number/
 *
 */

public class MajorityElementFinder {
    public static void main(String[] args) {
        Solution solutionFinder = new Solution();
        //List<Integer> inputList = new ArrayList<>(); //Test case #1 - Empty list - PASS
        //List<Integer> inputList = new ArrayList<>(Arrays.asList(1)); //Test case #2 - only one element / PASS
        //List<Integer> inputList = new ArrayList<>(Arrays.asList(3,2,3)); //Test case #3 - PASS
        List<Integer> inputList = new ArrayList<>(Arrays.asList(1,1,1,3,3,2,2,2)); //Test case #4 - PASS
        //List<Integer> inputList = new ArrayList<>(Arrays.asList(1,2,3));//Test case #5 - no Major elements - PASS
        int majorElement = solutionFinder.repeatedNumber(inputList);
        System.out.println("Main() :: Major element is : " + majorElement);
    }
}

class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> inputList) {
        List<Integer> majorityElements = new ArrayList<>();
        //System.out.println("Input array : "+inputList);

        // If empty array return the empty list
        if(inputList == null || inputList.size() == 0){
            //System.out.println("Majority element : "+majorityElements);
            return  -1;
        }

        //If array had only one element
        if(inputList.size() == 1){
            //majorityElements.add(inputList[0]);
            //System.out.println("Majority elements : "+majorityElements);
            return  inputList.get(0);
        }

        Integer firstMajorElement = null;
        Integer secondMajorElement = null;
        int finalResult = -1;
        int firstMajorElementCount = 0;
        int secondMajorElementCount = 0;
        final int MAJORITY_SIZE_THRESHOLD = inputList.size() / 3;
        // Step #1 - Iterate thru array
        for(int currentElement : inputList){
            /*System.out.println("current element : "+currentElement);
            System.out.println("1st element : " + firstMajorElement
                    + " 1st element count : "+firstMajorElementCount);
            System.out.println("2nd element : " + secondMajorElement
                    + " 2nd element count : "+secondMajorElementCount);*/
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

        for (int currentElement : inputList){
            if(currentElement == firstMajorElement.intValue()){
                firstMajorElementCount++;
            }
            else if(currentElement == secondMajorElement.intValue()){
                secondMajorElementCount++;
            }
        }

       /* System.out.println("1st element count : " + firstMajorElementCount
                + " 2nd element count : " + secondMajorElement);*/

        if(firstMajorElementCount > MAJORITY_SIZE_THRESHOLD){
          //  majorityElements.add(firstMajorElement);
            finalResult = firstMajorElement;
        }
        if(secondMajorElementCount > MAJORITY_SIZE_THRESHOLD){
            //majorityElements.add(secondMajorElement);
            finalResult = secondMajorElement;
        }

        if(firstMajorElement == null && secondMajorElement == null){
            finalResult = -1;
        }
        /*System.out.println("Before existing majority elements method ");
        majorityElements.stream().forEach(System.out::println);*/
        return finalResult;
    }
}

