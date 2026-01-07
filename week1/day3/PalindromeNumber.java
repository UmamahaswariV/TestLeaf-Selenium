package week1.day3;
import java.util.Scanner;
public class PalindromeNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the Numbers:");
	    // Declare two variables of int data type such as    
	    //- ‘input’ to assign the given number    
	    //- ‘output’ to store the reversed form of the input number  
	    int input = sc.nextInt();
	    int output = reverseDigits(input);
	    //Use ‘if’ statement to compare the output with the given input.
	    //compare ‘input’ with ‘output’ to print whether the given input is a palindrome or not. 
	    if(input==output){
	      System.out.println("It is Palindrome"); }
	    else {
	      System.out.println("It is Not Palindrome");
	    }
	    sc.close();
	  }
	public static int reverseDigits(int input){
	    int output = 0;
	  //Implement a 'for' loop where the control variable ‘i’ starts with the 
	  // value of the ‘input’ variable, continues as long as 
	  // ‘i’ is greater than 0, and update ‘i’ by dividing it by 10 in each iteration
	 	for(int i=input;i>0;i/=10) {
	 //Use appropriate operator to calculate the remainder by dividing the ‘input’ by 10. 
	 //Assign this value to an integer variable ‘rem’. 
	        int rem = i % 10;
	        output = output * 10 + rem;
	    }
	    return output;  
	    }

	}
