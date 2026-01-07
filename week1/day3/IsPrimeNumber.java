package week1.day3;
import java.util.Scanner;
//Create a Java class named IsPrimeNumber. 
public class IsPrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        boolean isPrime = true;
        
        if (n <= 1) {
            isPrime = false;
        }
        // Iterate through all numbers from 2 to n-1 (input) 
        // and for every number check if it divides n (input).  
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
       // If we find any number that divides, print non-prime. 
       // If nothing divides, then print prime 
        if (isPrime) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is non-prime");
        }
        sc.close();
	}

}
