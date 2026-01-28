public class MissingElementsInArray {
	public static void main(String[] args) {
        // Declare an array {1,2,3,4,10,6,8}.
        int[] arr = {1,2,3,4,10,6,8};
        
        // Convert array to List
        List<Integer> list = new ArrayList<>();
        for (int num:arr) list.add(num);
        
        // Arrange collection in ascending order
        Collections.sort(list);
        
        System.out.print("Missing numbers: ");
        
        // Do a comparison check if there is a gap in the sequence of numbers.
        for (int i=0;i<list.size()-1;i++) {
        	//Use the get() method to get an element from the list
            int current=list.get(i);
            int next=list.get(i+1);
            
            //Inside the loop, check the current element + 1 is not equal to the next element. 
            //This comparison checks if there is a gap in the sequence of numbers
            if (current+1!=next) {
                // Print all missing numbers in gap
                for (int missing=current+1;missing<next;missing++) {
                    System.out.print(missing + " ");
                }
            }
        }
        System.out.println();
    }
}
