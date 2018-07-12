package com.github.clashcoder;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printJumpingNumbers(100);
		System.out.println("");
		printJumpingNumbers(0);
	}
	
	/**
	 * Prints out all "Jumping Numbers" less than 'x'.
	 * 'x' must be a positive integer. 
	 * A number is a Jumping Number if all adjacent digits 
	 * have a difference of 1 (e.g. 765)
	 * 
	 * @param x   Integer representing up to which number to check for Jumping Number.
	 */
	public static void printJumpingNumbers(int x) {
	    
		if (x <= 0) {
			System.out.println("Value must be a positive integer!");
			return;
		}
		
		//Since x should be a positive integer, 0 should always be printed first.
	    System.out.print(0 + " ");
	    
	    Queue<Integer> q = new LinkedList<>();
	    
	    for (int i = 1; i <= 9; i++) {
	    		
	    		// single digit values are always a possible Jumping Number
	        q.add(i);
	        
	        while (!q.isEmpty()) {
	        		
	        		// get next value in queue
	            int temp = q.poll();
	            
	            // if current value in queue is greater than x, omit from result
	            if (temp > x) {
	                continue;
	            }
	            
	            // Print out popped value since valid Jumping Number
	            System.out.print(temp + " ");
	            
	            // Get the last digit of the popped value
	            int lastDigit = temp % 10;
	            
	            // Add the next possible Jumping Numbers to the queue
	            if (lastDigit > 0) {
	                q.add(temp * 10 + (lastDigit -1));
	            }
	            
	            if (lastDigit < 9) {
	                q.add(temp * 10 + (lastDigit + 1));
	            }
	        }
	    }
	}

}
