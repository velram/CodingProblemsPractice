/**
 * 
 */
package com.interviewbit.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Velmurugan Moorthy
 * 
 * This class aims to solve the "Hotel bookings" problem from InterviewBit
 * Question URL - https://www.interviewbit.com/problems/hotel-bookings-possible/
 * 
 */
public class HotelManagerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Test case #1 - Happy flow - basic inputs - rooms not available
		/*ArrayList<Integer> arrivalDates =  new ArrayList<>(Arrays.asList(1,3,5));
		ArrayList<Integer> departureDates =  new ArrayList<>(Arrays.asList(2,6,8));
		int roomCount = 1;
		*/
		
		//Test case #2 - same arrival & same departure date exists
		/*ArrayList<Integer> arrivalDates =  new ArrayList<>(Arrays.asList(3,3,5));
		ArrayList<Integer> departureDates =  new ArrayList<>(Arrays.asList(6,6,8));
		int roomCount = 2;*/
		
		//Test case #3 - Rooms not available scenario 
		 /*ArrayList<Integer> arrivalDates =  new ArrayList<>(Arrays.asList(1, 3, 4));
		 ArrayList<Integer> departureDates =  new ArrayList<>(Arrays.asList(12, 8, 6));
		 int roomCount = 2;
		 */
		
		 //Test case #3 - zero rooms & 1 booking scenario
		 /*ArrayList<Integer> arrivalDates =  new ArrayList<>(Arrays.asList(1 ));
		 ArrayList<Integer> departureDates =  new ArrayList<>(Arrays.asList(12));
		 int roomCount = 0;
		 */
		
		 //Test case #4 - zero rooms & multi-booking scenario
		/* ArrayList<Integer> arrivalDates =  new ArrayList<>(Arrays.asList(1,2));
		 ArrayList<Integer> departureDates =  new ArrayList<>(Arrays.asList(12,3));
		 int roomCount = 0;
		*/
		
		//Test case #5 - departure and arrival date are same
		 /*ArrayList<Integer> arrivalDates =  new ArrayList<>(Arrays.asList(1, 2, 3));
		 ArrayList<Integer> departureDates =  new ArrayList<>(Arrays.asList(2, 3, 4));
		 int roomCount = 1;*/
		 
		//Test case #5 - departure and arrival date are same
		 ArrayList<Integer> arrivalDates =  new ArrayList<>(Arrays.asList( 13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8 ));
		 ArrayList<Integer> departureDates =  new ArrayList<>(Arrays.asList( 28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53 ));
		 int roomCount = 23;

				 
		System.out.println("Rooms are availble : "+hotel(arrivalDates, departureDates, roomCount));
	}

    public static boolean hotel(ArrayList<Integer> arrivalDates, ArrayList<Integer> departureDates, int roomCount) {
    	int totalBookings = arrivalDates.size();
    	int bookingOverlaps = 0;
    	Collections.sort(arrivalDates);
    	Collections.sort(departureDates);
    	System.out.println("Sorted arrival dates : "+arrivalDates);
    	System.out.println("Sorted departure dates : "+departureDates);
    	System.out.println("totalBookings : "+totalBookings);
    	System.out.println("roomCount : "+roomCount);
    	if(totalBookings <= 1 || roomCount < 1) {
    		return (roomCount >= totalBookings);
    	}
    		for (int loopIndex = 1; loopIndex < totalBookings; loopIndex++) {
    			System.out.print("Arrival date(loopIndex) : "+arrivalDates.get(loopIndex));
    			System.out.print(" Arrival date(loopIndex-1) : "+arrivalDates.get(loopIndex-1));
    			System.out.print(" departureDates.get(loopIndex-1) : "+departureDates.get(loopIndex-1) +"\n"); 
    			if(!(arrivalDates.get(loopIndex) == departureDates.get(loopIndex-1)) && (arrivalDates.get(loopIndex) > departureDates.get(loopIndex-1)
    			   || arrivalDates.get(loopIndex) >= arrivalDates.get(loopIndex-1))) {
    				if(bookingOverlaps ==0)
    					bookingOverlaps+=2;
    				else if(bookingOverlaps > 0)
    					bookingOverlaps++;
    			}
    		}    		
    		System.out.println("bookingOverlaps : "+bookingOverlaps);
        	System.out.println("roomCount : "+roomCount);	
		return roomCount >= bookingOverlaps;
    }
}
