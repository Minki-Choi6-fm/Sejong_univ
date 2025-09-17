package ch1;
import javax.swing.*;

class today{
	int date;
	int month;
}
class birthday{
	int date;
	int month;
}

public class ClassWorkExercise2 {
	public static void main(String[] args) {
        today today = new today();
        birthday birthday = new birthday();

		System.out.println("Enter today's date:\n");
        today.date=Integer.parseInt(JOptionPane.showInputDialog("Enter month as a number:"));
        today.month=Integer.parseInt(JOptionPane.showInputDialog("Enter the day of the month:"));
        System.out.println("Enter your birthday:\n");   
        birthday.date=Integer.parseInt(JOptionPane.showInputDialog("Enter month as a number:"));
        birthday.month=Integer.parseInt(JOptionPane.showInputDialog("Enter the day of the month:"));
        
        System.out.println("Today's date is month ="+today.date+", day ="+today.month+"\n");
        System.out.println("Your birthday is month = "+birthday.date+", day ="+birthday.month);

	}
}
