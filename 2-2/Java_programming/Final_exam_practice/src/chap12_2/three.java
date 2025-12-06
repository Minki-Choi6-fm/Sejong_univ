package chap12_2;

import java.io.*;
import java.util.*;

public class three {
    public static void main(String[] args)throws IOException {
        File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/Final_exam_practice/src/chap12_2/numbers.txt");
        Scanner sc=new Scanner(f);
        int sum=0;
        int count=0;
        while(sc.hasNext()) {
            int a=sc.nextInt();
            sum+=a;
            count++;
        }
        System.out.println(sum);
        System.out.println(sum/count);
    }
}
