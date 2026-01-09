package week1.day4;
import java.util.Arrays;
import java.util.Scanner;
public class AnagramString {
	public static boolean isAnagram(String input1, String input2) {

	// Handle null cases
    if (input1 == null || input2 == null) {
        return false;
    }
    
    // Check if lengths are different
    if (input1.length() != input2.length()) {
        return false;
    }
    
    // Convert to character arrays and sort
    char[] chars1 = input1.toCharArray();
    char[] chars2 = input2.toCharArray();
    
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    
    // Check if sorted arrays are equal
    return Arrays.equals(chars1, chars2);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the String1:");
 		String s1=sc.nextLine();
 		System.out.println("Enter the String2:");
 		String s2=sc.nextLine();
 		if(isAnagram(s1,s2)){
 			System.out.println("true");
 		} else {
 			System.out.println("false");
 		}
 		sc.close();
	}

}
