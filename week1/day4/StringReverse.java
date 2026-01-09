package week1.day4;
import java.util.Scanner;
public class StringReverse {
	public static String reverseString(String input) {
		
		 if (input == null || input.length() <= 1) {
           return "Invalid input";
       }
       
       char[] chars = input.toCharArray();
       int left = 0;
       int right = chars.length - 1;
       
       while (left < right) {
           char temp = chars[left];
           chars[left] = chars[right];
           chars[right] = temp;
           
           left++;
           right--;
       }
       
       return new String(chars);
   }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the String:");
 		String input=sc.nextLine();
 		String output=reverseString(input);
 		System.out.println("Reveresed String is "+output);
 		sc.close();

	}

}
