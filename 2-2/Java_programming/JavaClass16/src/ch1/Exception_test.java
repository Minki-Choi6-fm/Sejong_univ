package ch1;

import java.util.*;

class ExceptionTest1{
    int a,b;
    Scanner sc = new Scanner(System.in);
    void input(){
        try{
            a=sc.nextInt();
            b=sc.nextInt();
            if(b==0) throw new ArithmeticException ("Divide by zero");
            System.out.println(a/b);                // a에 10, b에 0 들어가면 exception 에러 메세지가 뜸
        }
        catch(ArithmeticException e){               //그냥 Exception은 모든 exception에 대응, 저건 저 예외에만 대응
            System.out.println("Divide by zero is not possible");
            System.out.println(e);
        }
    }
}

public class Exception_test {
    public static void main(String[] args) {
        ExceptionTest1 ex1 = new ExceptionTest1();
        ex1.input();
    }
}
