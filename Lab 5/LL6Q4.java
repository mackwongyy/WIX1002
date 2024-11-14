//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

public class LL6Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] a = new int[3][3];
        
        System.out.println("3 by 3 Matrix");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = input.nextInt();
            }
        }

        System.out.println("After rotates 90 degrees clockwise");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(a[3 - j - 1][i] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}
