package ch1;
import java.util.*;

class student{
	String name;
	int Id;

	public student(String name,int Id) {
		this.name=name;
		this.Id=Id;
	}
}

public class ClassWorkExercise1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
    	
    	System.out.println("Student:1");
    	System.out.println("Name: ");
    	String name1=scan.nextLine();
    	System.out.println("Id: ");
    	int Id1=scan.nextInt();
    	student student1=new student(name1,Id1);

    	scan.nextLine();
    	
    	System.out.println("Student:2");
    	System.out.println("Name: ");
    	String name2=scan.nextLine();
    	System.out.println("Id: ");
    	int Id2=scan.nextInt();
    	student student2=new student(name2,Id2);
    	
    	System.out.println("\n*****Output*****");
    	if(student1.name.equals(student2.name)&&student1.Id==student2.Id) {
    		System.out.println("Duplicate entry");
    	}
    	else {
        	System.out.println("Student:1");
        	System.out.println("Name:"+student1.name+"\n"+"Id:"+student1.Id+"\n");
        	
        	System.out.println("Student:2");
        	System.out.println("Name:"+student2.name+"\n"+"Id:"+student2.Id+"\n");
    	}
    	
    }
}