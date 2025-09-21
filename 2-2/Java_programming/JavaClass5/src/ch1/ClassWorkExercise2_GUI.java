package ch1;
import javax.swing.*;

class calender_1 {
	int month;
	int date;
	
	public calender_1(int month, int date){
		this.month = month;
		this.date = date;
	}
}

class b_day_check_1 {
	
	public calender_1 inputCalender(String str){
		int month = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter month as a number:", str));
		int day = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the day of the month:", str));

        calender_1 date = new calender_1(month, day);
        return date;
	}

	public void check_b_day(calender_1 today, calender_1 b_day) {
		String str = "Today's date is month = " + today.month + ", day = " + today.date + "\n"
                   + "Your birthday is month = " + b_day.month + ", day = " + b_day.date + "\n\n";

		if(today.month == b_day.month && today.date == b_day.date) {
			str = str + "Happy Birthday!";
		} else {
			str = str + "Happy Unbirthday!";
		}
		
		JOptionPane.showMessageDialog(null, str);
	}
}

public class ClassWorkExercise2_GUI {
	public static void main(String[] args) {
		b_day_check_1 check = new b_day_check_1();
		
		calender_1 today = check.inputCalender("Enter today's date:");
		calender_1 b_day = check.inputCalender("Enter your birthday:");
		
		check.check_b_day(today, b_day);
	}
}