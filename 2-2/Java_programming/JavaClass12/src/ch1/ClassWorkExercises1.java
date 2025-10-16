package ch1;

import java.util.*;
import javax.swing.*;
import java.awt.*;

class Java{
    int a;
    int b;
    Java(int a,int b){
        this.a = a;
        this.b = b;
    }
    Java(int a){
        this.a = a;
    }
    Java(){
        System.out.println("안녕하세용");
    }
}

public class ClassWorkExercises1 {
    public static void main(String[] args) {
        Java java2 = new Java(1,2);
        Java java1 = new Java(3);
        Java java0 = new Java();
    }
}
