package ch1;
import java.util.*;
interface Student {
    void getInfo();
    void display();
}
class Computer implements Student {
    int id;
    int weight;
    public void getInfo(){
        Scanner sc = new Scanner(System.in);
        id=sc.nextInt();
        weight=sc.nextInt();
        display();
    }
    public void display(){
        System.out.println("ID: "+id);
        System.out.println("Weight: "+weight);
    }
}
public class ClassExercise1 {
    public static void main(String[] args) {
        Student s1 = new Computer();
        s1.getInfo();
        Student s2 = new Computer();
        s2.getInfo();
    }
}
