package week1.day4;
import java.util.Arrays;
public class PrintDuplicates {
	public static void main(String[] args) {
		int[] num = {2, 5, 7, 7, 5, 9, 2, 3};
    	Arrays.sort(num);
        
		// Sorted Array
        System.out.println("Sorted array: ");
        for (int i=0;i<num.length-1;i++) {
            System.out.print(num[i] + " ");  
        }
        System.out.println();
        
        // Find duplicates using for loop
        // Compare the value with next value, if the next value is same, 
        // then print the value as duplicate. Otherwise continue the loop
        System.out.println("Duplicates in array: ");
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] == num[i + 1]) {
                System.out.print(num[i]+" ");
            }
        }
	}
}
