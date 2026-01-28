import java.util.*;

public class ArrayIntersection {
    public static void main(String[] args) {
        
    	//Declare an array for {3,2,11,4,6,7}
        int[] arr1 = {3,2,11,4,6,7};
        
        //Declare another array for {1,2,8,4,9,7}
        int[] arr2 = {1,2,8,4,9,7};
        
        // Convert arrays to Lists
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        
        // Add array elements to a list
        for (int num:arr1) list1.add(num);
        for (int num:arr2) list2.add(num);
        
        //Use an appropriate conditional statement to compare the values
        List<Integer> intersection=new ArrayList<>();
        
        // Iterate through first list
        for (int i=0;i<list1.size();i++) {
            // Iterate through second list
            for (int j=0;j<list2.size();j++) {
                // Compare values - if equal, add to intersection
                if (list1.get(i)==list2.get(j)) {
                    intersection.add(list1.get(i));
                    break; // Avoid duplicates from same list1 element
                }
            }
        }
        
        // Print intersection values
        System.out.print("Intersection: ");
        intersection.forEach(num->System.out.print(num +" "));
    }
}
