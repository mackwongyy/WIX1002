//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

public class LL6Q5 {
    public static int binarySearch(int[] a, int first, int last, int key) {  
        int count = 1;
        
        while(first <= last) {
            int mid = (first + last) / 2;
            
            if(a[mid] < key) {
                first = mid + 1;
            } else if(a[mid] == key) {
                System.out.println("found");
                return count;
            } else {  
                last = mid - 1;
            }
           
            count++;
        }

        System.out.println("not found");
        return count;
    }  

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int LIMIT = 100;
        int[] a = new int[20];
        Random r = new Random();

        System.out.println("A list of 20 random integers within 0 to 100:");
        for(int i = 0; i < 20; i++) {
            a[i] = r.nextInt(LIMIT) + 1;
            System.out.print(a[i] + (i < 19 ? ", " : "\n"));
        }

        Arrays.sort(a);
        System.out.println("Array in descending order:");
        for(int i = 19; i >= 0; i--) {
            System.out.print(a[i] + (i > 0 ? ", " : "\n"));
        }

        System.out.print("Enter a number to search: ");
        int number = input.nextInt();

        int linearCount = 0;
        boolean found = false;
        for(int i = 0; i < 20; i++) {
            linearCount++;
            if(number == a[i]) {
                found = true;
                break;
            }
        }

        System.out.print(number + " ");
        if(found) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
        System.out.println("Linear Search - " + (20 - linearCount + 1) + " loop(s)");

        System.out.print(number + " ");
        int binaryCount = binarySearch(a, 0, 19, number);
        System.out.println("Binary Search - " + binaryCount + " loop(s)");
        
        input.close();
    }
}
