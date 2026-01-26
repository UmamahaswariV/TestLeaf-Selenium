/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/
package javaChallange;
import java.util.Scanner;
public class PalindromeString {
	public static String CleanString(String str) {
		 String clean = "";  
		   // Check characters at string for comparison
		    for (int i = 0; i < str.length(); i++) {
		        char c = str.charAt(i);
		        if (isValid(c)) {
		            clean += Character.toLowerCase(c);
		        }
		    }
		    return clean;
	}
	public static String Reverse(String str) {
		 String reversed = "";
		 //Reverse the string for comparision
		    for (int i = str.length() - 1; i >= 0; i--) {
		        reversed += str.charAt(i);
		    }
		    return reversed;	    
	}
	//Check the Character is Alphabets and Numbers only
    private static boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || 
               (c >= 'A' && c <= 'Z') || 
               (c >= '0' && c <= '9');
    }
    //Compare both Strings
    public static boolean isPalindrome(String str1,String str2) { 
	    return str1.equals(str2);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the String:");
 		String input=sc.nextLine();
 		String clean=CleanString(input);
 		String output=Reverse(clean);
 		if(isPalindrome(clean,output)) {
 			System.out.println(isPalindrome(clean,output));
 			System.out.println(output +" is a Palindrome");
 		} else {
 			System.out.println(isPalindrome(clean,output));
 			System.out.println(output +" is Not a Palindrome");
 		}
 		
 		sc.close();
	}
}
