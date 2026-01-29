import java.util.*;

public class ReverseStringCollection {
    public static void main(String[] args) {
        //Declare a String array and add the values as {HCL, Wipro, Aspire Systems, CTS}
        String[] companies={"HCL","Wipro","Aspire Systems","CTS"};
        
        //Add collection to List
        List<String> list=new ArrayList<>();
        for (String company:companies) list.add(company);
        
        //Arrange collection in ascending order (as per hint)
        Collections.sort(list);
        
        //Use reverse loop to iterate and print
        System.out.print("Reversed: ");
        for (int i=list.size()-1;i>=0;i--) {
            System.out.print(list.get(i));
            if (i>0) System.out.print(", ");
        }
        System.out.println();
    }
}

