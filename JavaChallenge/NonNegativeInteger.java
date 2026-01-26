Java Challenge (2/20)
Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
Example 1:
Input: x = 4
Output: 2
Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

import java.util.Scanner;
public class NonNegativeInteger {
	public static int mySqrt(int input) {
		int temp=0;
		while(temp*temp<=input)
			temp++;
		return temp-1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the Number for Square root:");
 		int input=sc.nextInt();
 		if(input==0) {
 			System.out.println("Given Number should be above 0");		}
 		else if(input<0) {
 			System.out.println("Given Number is Negative");
 		} else if(input>0) {
 			int output=mySqrt(input);
 			System.out.println(output);
 		}
 		sc.close();
	}
}
