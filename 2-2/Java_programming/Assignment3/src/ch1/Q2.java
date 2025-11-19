package ch1;

import java.util.*;

class Rand{
    Random rand = new Random();
    int Next(){
        return rand.nextInt(6)+1;
    }
    void Print(){
        int[] arr=new int[7];
        for(int i=0; i<60000000; i++){
            int a=Next();
            arr[a]++;
        }
        System.out.println("Face\t\tFrequency");
        for(int i=1; i<7; i++){
            System.out.println(i+"\t\t\t"+arr[i]);
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Rand r = new Rand();
        r.Print();
    }
}
