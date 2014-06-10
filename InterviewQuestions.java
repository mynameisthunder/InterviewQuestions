/*
Solutions By Omari Powell
ojp3@cornell.edu
Done for Tech Draft Application in 2014 to upload to github

*/

import java.util.ArrayList;
import java.util.HashSet;


public class InterviewQuestions {
	//Print all permutation of String both iterative and Recursive way?
	public String [] permutations(String s ) { 
		 if (s.length()<=1){
		 	return (new String[]{s});
		 }   
		 // get all permutations of length N-1 
			String [] perms=permutations(s.substring(1));
		//get the character you left out 
		 	String curr  = s.charAt(0) + "";
		 	ArrayList<String> result = new ArrayList<String>(); 

		 //iterate over all permutations of length N-1 
			for( String str  : perms ){
				//add the  curr character (curr ) to every location in str
				for ( int x = 0; x< str.length();x++){
					result.add( str.substring(0, x)  + curr + s.substring(x));

				}
				
			}
			return (String[]) result.toArray();
		 }
	
	
	/*
	 * Print  the union of two String arrays in O (n+m ) time
	 * 
	 * 
	 */
	public String[] union( String [] array1, String [] array2){
	HashSet<String> seen= new HashSet<String>(); 
	ArrayList<String> list= new ArrayList<String>();
	for ( String s : array1){
		if ( !seen.add(s) == true){
			System.out.println(s);
			list.add(s);
		};
	}
	for ( String s : array2){
		if ( !seen.add(s) == true){
			System.out.println(s);
			list.add(s);
		};
	} 
		return (String [])list.toArray();
	
	}
	
	/*
	 * How to tell if a number is to the power of 2?
	 */
	public boolean isPower2( int n){
		if( n< 1 ){
			return false;
		}
		//any numberer to the power of 2 bitwise is this 0100.
		//only has one one. so minus one and anding it will be all zeros
		return ( (n-1&n)  == 0);
	}
	
	/*
	 *  How do you find second highest number in an integer array?
	 * 
	 * 
	 */
	public int secondHighest( int [] array){
		int max  = Integer.MIN_VALUE;
		int secMax=  max;
		//keep track of the second highest
		for( int x : array){
			if( x >=max ) {
				secMax=  max;
				max =x;
			}
			else{
				
				if(  x>=secMax){
					secMax = x;
				}
			}
		}
		
		return secMax;
	}
	
	/*
	 *  Given two arrays, 1,2,3,4,5 and 2,3,1,0,5 find which number is not present in the second array.

	 * 
	 * returns null if nothing found 
	 */
	
	public Integer difference(int [] array1, int[] array2){
		HashSet<Integer> seen = new HashSet<Integer>();
		for( int  x :  array1){
			seen.add(x );
		}
		for( int  x :  array2){
			if ( !seen.contains(x)){
				 return x;
			}
		}
		return null;
	}
	
	/*
	 * In an array 1-N numbers are stored randomly in an array (no duplicates)
	 * .One number is missing how do you find it?
	 * 
	 */
	public int findIt(int[] array){
		//n(n+1)/2
		int sum = (array.length)* (array.length-1)/2;
		int arraySum = 0;
		for( int x  : array){
			arraySum+=x;

		}
		return sum - arraySum;

		
	}
	/*
	 * 
	 * How can you tell if a String is a palindrome or not ?
	 * ere is the detail of parameters: fo substring 

		beginIndex -- the begin index, inclusive.

	endIndex -- the end index, exclusive.
	 */
	
	public boolean isPalindrome(String s){
		if (s.length() <2){
			return true; 
		}
		//are the last characters the same or nah
		return s.charAt(0) == s.charAt(s.charAt(s.length() - 1)) ? 
				isPalindrome( s.substring(1, s.length()-1))  : false; 
	}
	
	
	/*
	 * Write a function to find out longest palindrome in a given string
	 */
	
	public int longestPal ( String s){
		//this is actually pretty easy 
		 return longestPalHelper( s, 0,0);
	}
	public int longestPalHelper( String s, int max, int currNum){
		if (s.length() <2){
			return max; 
		}
		if(  s.charAt(0)== s.charAt(s.length()-1)){
			//its still a palindrome
			currNum++;
			if( currNum>max ){
				max=currNum;
			}
			return longestPalHelper(s.substring(1, s.length()-1), max, currNum);

		}
		//its no loneger  a pal currently
		
		return longestPalHelper(s.substring(1, s.length()-1), max, 0);
	}
	
	/*
	 * Write a method which will remove any given character from a String
	 * 
	 */
	
	//Remember you cannot cast from a character to a string like so (String )c however you can do this c+"" which is easier
	public String  removeChar ( String s, char c ){
		return s.replace(String.valueOf(c), "");
	}



	//How to tell if  a number is the power of 2 ?



	public boolean isPowerTwo( int n){
	if( n< 1 ){
		return false;
	}
	//basically in binary form a power of two only as one "1". So in binary  n-1 wl be all ones 
	//but not the shifted  over right by 1. So anding it should always be zero.
	//any false positives?
	
	return ( ((n-1)&n)  == 0);
}
	
}
