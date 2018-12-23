package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner inputReader = new Scanner(System.in);
        List<IntegerSequence> initalSequences = new ArrayList<>();
        SequenceCreator sequenceCreatorObject = new SequenceCreator();
        int[] inputSequence = sequenceCreatorObject.readInput(inputReader);
        initalSequences = sequenceCreatorObject.createSequences(inputSequence);
        initalSequences.get(0).getSequentialNumber();
        System.out.println("Sequential number : "+initalSequences.get(1));

    }
}

class SequenceCreator {
    private int MINIMUM_SEQUENCE_SIZE = 3; 
    private int SEQUENCE_DIFFERENCE = 1;
    public int[] readInput(Scanner pInputReader) {
        int inputSize = pInputReader.nextInt();
        int[] inputSequence = new int[inputSize];
        for(int loopIndex = 0; loopIndex < inputSize ; loopIndex++) {
            inputSequence[loopIndex] = pInputReader.nextInt();
        }
        //System.out.println("input sequence : "+inputSize);
        return inputSequence;
    }
    
    public List<IntegerSequence> createSequences(int[] pInputArray) {
        List<IntegerSequence> sequences = new ArrayList<>();
        if(null != pInputArray){
        	int arraySize = pInputArray.length;
        	int sequenceSize = 0;
        	List<Integer> tempSequentialNumbers = new ArrayList<>();
            /*
            int previousInteger = 0; 
            int currentInteger = 0; 
            ;*/
            for(int loopIndex=0; loopIndex < arraySize; loopIndex++) {
                if( (loopIndex != arraySize -1)) {
                System.out.println(" pInputArray[loopIndex+1] : "+pInputArray[loopIndex+1] + " pInputArray[loopIndex] "+pInputArray[loopIndex]);
                 if(pInputArray[loopIndex+1] - pInputArray[loopIndex] == 1 && !tempSequentialNumbers.contains(pInputArray[loopIndex]) && !tempSequentialNumbers.contains(pInputArray[loopIndex])) {
                    tempSequentialNumbers.addAll(Arrays.asList(pInputArray[loopIndex],pInputArray[loopIndex+1]));
                   sequenceSize+=2;
                 } 
                   System.out.println("sequenceSize : "+sequenceSize +" tempSequentialNumbers : "+tempSequentialNumbers);
                  System.out.println(sequenceSize >= MINIMUM_SEQUENCE_SIZE); 
                  System.out.println((SEQUENCE_DIFFERENCE != pInputArray[loopIndex+1] - pInputArray[loopIndex]));
                   if(sequenceSize >= MINIMUM_SEQUENCE_SIZE && (SEQUENCE_DIFFERENCE != pInputArray[loopIndex+1] - pInputArray[loopIndex])) {
                	   System.out.println("Inside line 82");
                       IntegerSequence newSequence = new IntegerSequence();
                       newSequence.setSequentialNumbers(tempSequentialNumbers);
                       sequences.add(newSequence);
                       tempSequentialNumbers.clear();
                       //tempSequentialNumbers = new ArrayList<>();
                   }
                }     
            }
        }
        return sequences;
    }
    
    public void parseInput(int[] pInputArray) {
        
    }
}

class IntegerSequence {
    
    List<Integer> sequentialNumbers = new ArrayList<>();
    
    public List<Integer> getSequentialNumber() {
        return this.sequentialNumbers;
    }
    
    public void setSequentialNumbers(List<Integer> pSequentialNumbers) {
        this.sequentialNumbers = pSequentialNumbers;
    }
}

class IntegerSequenceGroup {
    
    int sequenceSize; 
    List<IntegerSequence> sortedSequences;
}
