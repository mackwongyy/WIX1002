//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

public class LL6Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int LIMIT = 20;
        int[] array = new int[10];
        Random r = new Random();
        int count = 0;

        for(int i = 0; i < 10; i++) {
            array[i] = -100;
        }

        while(true) {
            if(count == 10) {
                break;
            }

            int number = r.nextInt(LIMIT) + 1;
            boolean found = false;

            for(int i = 0; i < count; i++) {
                if(number == array[i]) {
                    found = true;
                    break;
                }
            }

            if(!found) {
                array[count] = number;
                count++;
            }
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
        
        input.close();
    }
}
