import java.util.*;

public class SecondLargestInArray {
    public static void main(String[] args) {
        // Declare an array {3,2,11,4,6,7}.
        int[] arr = {3,2,11,4,6,7};
        
        // Convert array to List
        List<Integer> list = new ArrayList<>();
        for (int num:arr) list.add(num);
      
        // Arrange collection in ascending order
        Collections.sort(list);
        
        // Sorted array list
        System.out.print("Sorted Array ");
        list.forEach(num->System.out.print(num+" "));
        System.out.println();
        
        // Print 2nd element from last (second largest) using get method
        System.out.println("Second Largest: "+list.get(list.size()-2));
    }
}
