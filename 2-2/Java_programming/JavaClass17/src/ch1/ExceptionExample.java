package ch1;

import java.util.*;

class Student5{
    int age;
    String name;
    Scanner sc = new Scanner(System.in);
    void input(){
        String check=sc.nextLine();
        try{
            age=Integer.parseInt(check);
            if(age<=18)throw new Exception("Check Input");
            name=sc.nextLine();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

public class ExceptionExample {
    public static void main(String[] args) {
        Student5 s1 = new Student5();
        s1.input();
    }
}
