Java Challenge (4/20)
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NonReapetingValue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        
        System.out.println("Enter " + size + " numbers:");
        for (int i=0;i<size;i++) {
            nums[i]=sc.nextInt();
        }
        
        // Find single occurrence numbers using HashSet
        Set<Integer> singles=new HashSet<>();
        for (int num:nums) {
            if (!singles.add(num)) {  // add() returns false if duplicate
                singles.remove(num);  // Remove pair
            }
        }
        
        // Print all Non repetitive values (handles your Example 1 case)
        System.out.print("Single numbers: ");
        singles.forEach(num->System.out.print(num+" "));
        System.out.println();
        sc.close();
	}
}
