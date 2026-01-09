package week1.day4;
import java.util.Scanner;
public class ArmstrongNumber {
	public static boolean isArmStrong(long num) {
		if (num < 0) {
        return false;  }
    long original = num;
    int digits = String.valueOf(num).length();
    long sum = 0;
    while (num != 0) {
        long digit = num % 10;
        sum += Math.pow(digit, digits);
        num /= 10;
    }
    return sum == original;
	}
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		    System.out.println("Enter the Number:");
		    long num=sc.nextInt();
		    if(isArmStrong(num)) {
		       System.out.println("true"); }
		   else {
		       System.out.println("false"); }
		    sc.close();
	}

}
