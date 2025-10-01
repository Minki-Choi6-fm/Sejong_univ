package ch1;
import java.util.*;
interface Example1 {
    void input();
    void display();
}
class Example implements Example1 {
    int id;
    String name;
    public void input() {
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        name = sc.next();
        display();
    }
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}
public class InterfaceExample1 {
    public static void main(String[] args) {
        Example example = new Example();
        example.input();
    }
}
