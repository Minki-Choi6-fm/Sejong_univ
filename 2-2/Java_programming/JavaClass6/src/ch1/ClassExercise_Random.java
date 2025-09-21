package ch1;
import java.util.*;

class random_student{
	int a,b,c,d;
	
	public void input_and_check() {
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		a=scanner.nextInt();
		b=scanner.nextInt();
		c=random.nextInt(101);
		d=random.nextInt(101);
		
		System.out.println(c);
		System.out.println(d);

		
		int max=a;
		if(max<b) {
			max=b;
		}
		if(max<c) {
			max=c;
		}
		if(max<d) {
			max=d;
		}
		System.out.println(max);
	}
}

public class ClassExercise_Random {
	public static void main(String[] args) {
		random_student student=new random_student();
		
		student.input_and_check();
	}
}
