//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

public class LL6Q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of row of Pascal Triangle to generate: ");
        int n = input.nextInt();
        int[][] a = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= i; j++) {
                if(i == j) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}
