package ch1;

import java.util.Random;
import java.util.Scanner;

class ParentA {
    protected int a;
    protected int b;

    public void generateNumbers() {
        Random rand = new Random();
        this.a = rand.nextInt(100) + 1;
        this.b = rand.nextInt(100) + 1;
    }
}

class ChildB extends ParentA {
    protected int c;
    protected int d;

    public void takeUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 숫자 입력: ");
        this.c = sc.nextInt();
        System.out.print("두 번째 숫자 입력: ");
        this.d = sc.nextInt();
    }

    public void displayTotalSum() {
        int total = a + b + c + d;
        System.out.println("--- 결과 ---");
        System.out.println("부모 숫자 (a, b): " + a + ", " + b);
        System.out.println("자식 숫자 (c, d): " + c + ", " + d);
        System.out.println("총합 (a+b+c+d): " + total);
    }
}

public class ClassWorkExercise1 {
    public static void main(String[] args) {
        ChildB obj = new ChildB();
        obj.generateNumbers();
        obj.takeUserInput();
        obj.displayTotalSum();
    }
}