package ch1;
import javax.swing.*;
import java.util.*;

class Number {
    int r_num;

    public Number() {
        Random random = new Random();
        r_num = random.nextInt(1000) + 1;
        JOptionPane.showMessageDialog(null,"Guess a number between 1 and 1000");
    }

    public boolean input_number() {
        while (true) {
            int input = Integer.parseInt(JOptionPane.showInputDialog(null,"Guess (0 to exit): ","Guess a number between 1 and 1000",JOptionPane.QUESTION_MESSAGE));

            if (input == 0) {
                JOptionPane.showMessageDialog(null,"Game exited.");
                return false;
            }
            else if (input > r_num) {
                JOptionPane.showMessageDialog(null,input + " is too high. Try again.");
            }
            else if (input < r_num) {
                JOptionPane.showMessageDialog(null,input + " is too low. Try again.");

            }
            else {
                return true;
            }
        }
    }
}

public class Q2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Number num = new Number();
            boolean guessed = num.input_number();

            if (guessed) {
                String ans= JOptionPane.showInputDialog(null,"Congratulations! You guessed the number!\nDo you want to play again? (y/n):","input",JOptionPane.QUESTION_MESSAGE);
                if (!ans.equalsIgnoreCase("y")) {
                    playAgain = false;
                    JOptionPane.showMessageDialog(null,"Thanks for playing!");
                }
            } else {
                playAgain = false;
            }
        }
    }
}
