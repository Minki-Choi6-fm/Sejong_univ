package ch1;

import javax.swing.*;
import java.util.Random;

class Program{
    int r_num;
    Program(){
        Random random=new Random();
        r_num=random.nextInt(1000)+1;
        JOptionPane.showMessageDialog(null,"Guess a number between 1 and 1000");
    }
    int guessNumber(){
        while(true){
            int num=Integer.parseInt(JOptionPane.showInputDialog("Guess (0 to exit):"));
            if(num==r_num){
                JOptionPane.showMessageDialog(null,"Congratulations! You guessed it!!");
                int again=JOptionPane.showConfirmDialog(null,"Do you want to play again?","Play Again",JOptionPane.YES_NO_OPTION);
                if(again==JOptionPane.NO_OPTION){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else if(num==0){
                return 1;
            }
            else if(num>r_num){
                JOptionPane.showMessageDialog(null,num+" is too high. Try again.");
            }
            else{
                JOptionPane.showMessageDialog(null,num+" is too low. Try again.");
            }
        }
    }
}

public class P1 {
    public static void main(String[] args) {
        while(true){
            Program p1=new Program();
            int a=p1.guessNumber();
            if(a==1){
                break;
            }
        }
    }
}
