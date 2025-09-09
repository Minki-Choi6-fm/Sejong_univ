package ch1;
import java.util.*;

class Max{
    int a=10;
    int b=20;
    int c=30;

    int max=a>b?(c>a?c:a):(c>b?c:b);
}
class Min{
    int a=10;
    int b=20;
    int c=30;

    int min=a<b?(c<a?c:a):(c<b?c:b);
}
class Compare{
    String str_a;
    String str_b;
}
public class main {
    public static void main(String[] args) {
        Max obj1 = new Max();
        Min obj2 = new Min();
        Compare obj3 = new Compare();

        System.out.println(obj1.max);
        System.out.println(obj2.min);

        Scanner scan=new Scanner(System.in);
        obj3.str_a=scan.nextLine();
        obj3.str_b=scan.nextLine();
        if(obj3.str_a.equals(obj3.str_b)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}