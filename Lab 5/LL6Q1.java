//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

public class LL6Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int UPPER_BOUND = 100;
        int n = input.nextInt();
        int[] a = new int[n];
        Random r = new Random();
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        System.out.print("The array of randomly generated numbers: [");
        for(int i = 0; i < n - 1; i++) {
            a[i] = r.nextInt(UPPER_BOUND + 1);
            sum += a[i];
            System.out.print(a[i] + ", ");
        }

        a[n - 1] = r.nextInt(UPPER_BOUND + 1);
        sum += a[n - 1];
        System.out.println(a[n - 1] + "]");
        double average = (double) sum / (double) n;

        for(int i = 0; i < n; i++) {
            if(a[i] < min) {
                min = a[i];
            }

            if(a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("The highest score is: " + max);
        System.out.println("The lowest score is: " + min);
        System.out.println("The average score is: " + average);
        input.close();
    }
}
