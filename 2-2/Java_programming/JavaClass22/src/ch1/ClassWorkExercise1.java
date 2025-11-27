package ch1;

import java.io.*;
import java.util.*;

public class ClassWorkExercise1 {
	public static void main(String[] args)throws IOException{
		Scanner sc=new Scanner(System.in);
		File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass22/src/ch1/cw1.txt");
		FileWriter fw=new FileWriter(f);
		
		System.out.print("Enter your name:");
		String name=sc.nextLine();
		System.out.print("Enter your id:");
		String id=sc.nextLine();
		System.out.print("Enter your Age:");
		String age=sc.nextLine();
		
		f.createNewFile();
		String input="NAME:"+name+"\n"+"ID:"+id+"\n"+"Age:"+age;
		fw.write(input);
		fw.close();
	}
}
