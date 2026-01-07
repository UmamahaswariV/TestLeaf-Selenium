package week1.day3;
import java.util.Scanner;
public class FibonacciSeries {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

    //User input for the desired range of the Fibonacci series. 
	        System.out.print("Enter the range for Fibonacci series: ");
	        int range = sc.nextInt();
	       
	  //Initialize variables to keep track of Fibonacci numbers
	         int first = 0, second = 1, next = 0;
	        
	        System.out.print("Fibonacci series up to " + range + ": ");
	       //Use a loop to generate the Fibonacci series within the specified range. 
	        for (int i = 0; i <= range; i++) {
	       
	        //Ensure the loop continues until the next Fibonacci number exceeds the given range.
	            if (first > range) {
	                break;
	            }
	            System.out.print(first + " ");
	            //update the initialized variables iteratively
	            next = first + second;
	            first = second;
	            second = next;
	        }
	      sc.close();
	}
}
