package ch1;
import java.util.*;

class calender {
	int month;
	int date;
	
	public calender(int month,int date){
		this.month=month;
		this.date=date;
	}
	
}
class b_day_check{
	public calender inputCalender(Scanner scan, String str){
		System.out.println(str);
		System.out.println("Enter month as a number:");
		int month = scan.nextInt();
		System.out.print("Enter the day of the month: ");
        int day = scan.nextInt();
        
        calender date=new calender(month, day);
        return date;
	}
	public void check_b_day(calender today,calender b_day) {
		System.out.println("Today's date is month = "+today.month+", day = "+today.date);
		System.out.println("Your birthday is month = "+b_day.month+", day = "+b_day.date);
		
		if(today.month==b_day.month && today.date==b_day.date) {
			System.out.println("Happy Birthday!");
		}
		else {
			System.out.println("Happy Unbirthday!");

		}
	}
}

public class ClassWorkExercise2 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		b_day_check check=new b_day_check();
		
		calender today= check.inputCalender(scanner,"Enter today's date:");
		calender b_day= check.inputCalender(scanner,"Enter your birthday:");
		
		check.check_b_day(today, b_day);
	}
}
