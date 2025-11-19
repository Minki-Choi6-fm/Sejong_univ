package ch1;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Random rand = new Random();
        for(int i=0;i<20;i++){
            System.out.print(rand.nextInt(6)+1+" ");
        }
    }
}
