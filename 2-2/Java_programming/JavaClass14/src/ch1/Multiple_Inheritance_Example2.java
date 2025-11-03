package ch1;
import java.util.*;

interface manager{
    public void getdata();
}
class Branch{
    String place;
    void getplace(){
        place = "Korea";
    }
}
class Bank extends Branch implements manager{
    int id; String name;
    public void getdata(){
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        id = sc.nextInt();
    }
    void display(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Place: " + place);
    }
}
public class Multiple_Inheritance_Example2 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.getdata();
        bank.getplace();
        bank.display();
    }
}
