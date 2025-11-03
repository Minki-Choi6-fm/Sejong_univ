package ch1;
import java.util.*;
interface AA1{
    void input();
}
interface AA2{
    void input1();
}
interface AA extends AA1, AA2{
    void display();
}
class AAA implements AA{
    int id;
    String name;
    Scanner sc = new Scanner(System.in);
    public void input(){
        id=sc.nextInt();
    }
    public void input1(){
        name=sc.nextLine();
    }
    public void display(){
        System.out.println(id+" "+name);
    }
}

public class Multiple_Inheritance_Example1 {
    public static void main(String[] args) {
        AAA obj = new AAA();
        obj.input1();
        obj.input();
        obj.display();
    }
}
