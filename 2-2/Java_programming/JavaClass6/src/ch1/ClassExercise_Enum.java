package ch1;

import java.util.*;

public class ClassExercise_Enum {
	enum Month{ dec,feb,jul};
	public static void main (String[] args) {
		Month winter,summer;
		Scanner scanner= new Scanner(System.in);
		String a=scanner.next();
		String b=scanner.next();
		String c=scanner.next();
		
		winter=Month.valueOf(a);
		winter=Month.valueOf(b);
		summer=Month.valueOf(c);
	}
}
