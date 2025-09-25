package ch1;
import java.util.*;

class Date {
    int month;
    int day;
    Date(int month, int day) {
        this.month = month;
        this.day = day;
    }
}

public class ClassAssignment_3 {
    public Date input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter today's date:");
        System.out.print("Enter the month as a number: ");
        int month = scanner.nextInt();
        System.out.print("Enter the day of the month: ");
        int day = scanner.nextInt();
        return new Date(month, day);
    }
    public void output(Date today,Date birthday){
        System.out.println("Today's date is month = " + today.month + ", day = " + today.day);
        System.out.println("The birthday is month = " + birthday.month + ", day = " + birthday.day);

        if (today.month == birthday.month && today.day == birthday.day) {
            System.out.println("Happy Birthday!");
        } else {
            System.out.println("Happy Unbirthday!");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassAssignment_3 obj = new ClassAssignment_3();

        Date birthday = new Date(3, 21);
        Date today=obj.input();

        obj.output(today,birthday);
        scanner.close();
    }
}
