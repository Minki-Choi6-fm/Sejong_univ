package ch1;

import java.util.*;
import javax.swing.*;
import java.awt.*;

class Student{
    private String name;
    private int ID;
    private double average;
    private int[] score;
    void getdata(Scanner s){
        System.out.println("Student detail");
        System.out.print("Name: ");
        name=s.next();
        System.out.print("ID: ");
        int ID=s.nextInt();
    }
    void score(Scanner s){
        System.out.println("Subject Category:");
        average=0.0;
        score=new int[3];
        for(int i=0;i<3;i++){
            this.score[i]=s.nextInt();
            average+=score[i];
        }
        average=average/3;
        String pf=(average>50?"Pass":"Fail");
        System.out.println(average+"/"+pf);
        System.out.println("****************************************");
    }
}

public class Q1 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.print("Number of Student: ");
        int num=s.nextInt();
        for(int i=0;i<num;i++){
            Student student=new Student();
            student.getdata(s);
            student.score(s);
        }
    }
}
