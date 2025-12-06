package chap12_2;

import java.io.*;
import java.util.*;

class Student{
    String name;
    int age;
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class four {
    public static void main(String[] args) throws IOException {
        File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/Final_exam_practice/src/chap12_2/score.txt");
        f.createNewFile();

        PrintWriter fw=new PrintWriter(f);
        Student[] s=new Student[3];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;i++){
            String name=sc.nextLine();
            int age=sc.nextInt();
            s[i]=new Student(name,age);
            sc.nextLine();
        }
        for(int i=0;i<3;i++){
            fw.println(s[i].name);
            fw.println(s[i].age);
        }
        fw.close();
        double avg=0;
        Scanner sc1=new Scanner(f);
        for(int i=0;i<3;i++){
            sc1.nextLine();
            avg+=sc1.nextInt();
            sc1.nextLine();
        }
        avg=avg/3;
        System.out.println("평균" +avg);
    }
}
