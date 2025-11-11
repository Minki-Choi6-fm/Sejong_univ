package ch1;

import java.util.*;

class Student3{
    int age;
    String name;
    Scanner sc = new Scanner(System.in);
    void input(){
        String check = sc.nextLine();
        try{
            age = Integer.parseInt(check);
            name = sc.nextLine();
            if(age<=18)throw new ArithmeticException("Under age");
            if(name.matches("\\d+"))throw new NumberFormatException("Give String");
        }   //저거 \\d+ 숫자임을 나타내는 거래용
        catch(ArithmeticException|NumberFormatException e){
            System.out.println(e);
        }
    }
}

public class ExceptionExample2 {
    public static void main(String[] args) {
        Student3 st = new Student3();
        st.input();
    }
}
