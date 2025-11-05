package ch1;
import java.util.*;

class Test3{
    int id;
    String name;
    void input(){
        Scanner sc = new Scanner(System.in);
        name=sc.nextLine();
        id=sc.nextInt();
    }
    void display(){
        System.out.println(id);
        System.out.println(name);
    }
}
class Test4 extends Test3{
    String dept;

    void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        dept=sc.nextLine();
    }
    void display(){
        System.out.println(dept);
    }
}
public class Method_Overriding {
    public static void main(String[] args) {
        Test4 t1 = new Test4();
        t1.input();
        t1.display();
    }
}
