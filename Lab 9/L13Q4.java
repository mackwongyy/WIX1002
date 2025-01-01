//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

class DiceGame {
    private int playerScore;

    public DiceGame() {
        this.playerScore = 0;
    }

    public int rollDie() {
        Random g = new Random();
        return g.nextInt(6) + 1;
    }

    public void playFirstDiceGame() {
        while(playerScore < 100) {
            int die1 = rollDie();
            int die2 = rollDie();
            playerScore += (die1 + die2);
            System.out.println("You rolled: " + die1 + " and " + die2);

            if(die1 == die2) {
                System.out.println("You've rolled a double! Roll again.");
            } else {
                System.out.println("Your current score: " + playerScore);
            }
        }

        System.out.println("Congratulations! You won and your score is " + playerScore);
    }

    public void playSecondDiceGame() {
        while(playerScore < 100) {
            int die1 = rollDie();
            System.out.println("You rolled: " + die1);

            if(die1 == 6) {
                System.out.println("You've rolled a 6! Roll again.");
                int die2 = rollDie();
                System.out.println("Your second roll score: " + die2);

                if(die2 == 6) {
                    System.out.println("You rolled a number 6 again. No score for this round.");
                    playerScore += die1;
                } else {
                    playerScore += (die1 + die2);
                    System.out.println("Your current score: " + playerScore);
                }
            } else {
                playerScore += die1;
                System.out.println("Your current score: " + playerScore);
            }

            if(playerScore >= 100) {
                System.out.println("Congratulations! You won and your score is " + playerScore);
            }
        }
    }
}

public class L13Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DiceGame game1 = new DiceGame();
        System.out.println("First Dice Game:-");
        game1.playFirstDiceGame();
        System.out.println();

        System.out.println("Second Dice Game:-");
        DiceGame game2 = new DiceGame();
        game2.playSecondDiceGame();
        input.close();
    }
}
