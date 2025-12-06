package chap12_2;

import java.io.*;
import java.util.*;

public class two {
    public static void main(String[] args) throws IOException {
        File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/Final_exam_practice/src/chap12_2/diary.txt");
        FileWriter fw=new FileWriter(f,true);
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        fw.write(s+"\n");
        fw.close();
    }
}
