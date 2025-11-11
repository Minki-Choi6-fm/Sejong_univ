package ch1;

import java.util.*;

class Student4{
    int age;
    String name;
    Scanner sc = new Scanner(System.in);
    void input() throws NumberFormatException, ArithmeticException{
        age = sc.nextInt();
        name = sc.nextLine();
    }
}

public class ExceptionExample3 {
    public static void main(String[] args) {
        Student4 st = new Student4();
        try{
            st.input();
        }
        catch(NumberFormatException|ArithmeticException e){
            System.out.println(e);
        }
    }
}
