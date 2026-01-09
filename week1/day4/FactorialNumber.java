package week1.day4;
import java.util.Scanner;
public class FactorialNumber {
	public static int getFactorial(int num) {	
	      if(num<0)
	        {
	          System.out.println("Factorial Not defined for Negative numbers");
	        }
	        int fact=1;
	          for(int i=1;i<=num;i++)
	          {
	            fact*=i;
	          }
	        return fact;
	      }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the Number:");
	    int input=sc.nextInt();
	    int output=getFactorial(input);
	    System.out.println(output);
	    sc.close();
	}

}
