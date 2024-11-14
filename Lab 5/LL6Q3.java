//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

public class LL6Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int HOURS = 8;
        int n = input.nextInt();
        int[][] a = new int[n][7];
        Random r = new Random();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 7; j++) {
                a[i][j] = r.nextInt(HOURS) + 1;
            }
        }

        System.out.printf("\t\t\t\t     %5s, %5s, %5s, %5s, %5s, %5s, %5s, %5s\n", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Total");
        for(int i = 0; i < n; i++) {
            System.out.print("Seven-Day Work Hours of Employee " + (i + 1) + ": ");
            int total = 0;
        
            for(int j = 0; j < 6; j++) {
                System.out.printf("%6s,", a[i][j]);
                total += a[i][j];
            }
            System.out.printf("%6s,", a[i][6]);
            total += a[i][6];
            System.out.printf("%6s\n", total);
        }
    
        input.close();
    }
}
