package ch1;
import java.util.*;

class Number {
    int r_num;
    Scanner scanner = new Scanner(System.in);

    public Number() {
        Random random = new Random();
        r_num = random.nextInt(1000) + 1; 
        System.out.println("Guess a number between 1 and 1000");
    }

    public boolean input_number() {
        while (true) {
            System.out.print("Guess (0 to exit): ");
            int input = scanner.nextInt();
            
            if (input == 0) {
                System.out.println("Game exited.");
                return false; 
            } 
            else if (input > r_num) {
                System.out.println(input + " is too high. Try again.");
            } 
            else if (input < r_num) {
                System.out.println(input + " is too low. Try again.");
            } 
            else {
                System.out.println("Congratulations! You guessed the number!");
                return true; 
            }
        }
    }
}

public class ClassWorkExercise {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Number num = new Number();
            boolean guessed = num.input_number();

            if (guessed) {
                System.out.print("Do you want to play again? (y/n): ");
                String ans = sc.next();
                if (!ans.equalsIgnoreCase("y")) {
                    playAgain = false;
                    System.out.println("Thanks for playing!");
                }
            } else {
                playAgain = false;
            }
        }
    }
}
