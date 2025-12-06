package chap9;

//Chapter 9, p.23
import java.util.*;

class A{
    Random rand = new Random();
    int a;
    int b;
    public A(){
        a=rand.nextInt(100);
        b=rand.nextInt(100);
    }
}
class B extends A{
    int c;
    int d;
    void userInput(){
        Scanner sc = new Scanner(System.in);
        c=sc.nextInt();
        d=sc.nextInt();
    }
    void print(){
        int sum=a+b+c+d;
        System.out.println(sum);
    }
}

public class CWE1_9 {
    public static void main(String[] args) {
        B b = new B();
        b.userInput();
        b.print();
    }
}
