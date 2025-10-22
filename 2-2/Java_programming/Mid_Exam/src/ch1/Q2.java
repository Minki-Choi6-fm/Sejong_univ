package ch1;

import java.util.*;

public class Q2 {
    public static void main(String[] args){
        Random random=new Random();
        int[] die1=new int[6];
        int[] die2=new int[6];

        for(int j=0;j<18000;j++){
            int die= random.nextInt(6)+1;
            die1[die-1]++;
        }
        for(int j=0;j<18000;j++){
            int die= random.nextInt(6)+1;
            die2[die-1]++;
        }
        System.out.println("Face\tFrequency (die1 & die2)");
        for(int i=0;i<6;i++){
            System.out.println((i+1)+"\t\t"+die1[i]+"\t\t\t\t"+die2[i]);
        }
    }
}
