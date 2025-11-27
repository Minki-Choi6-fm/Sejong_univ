package ch1;

import java.io.*;
import java.util.*;

public class FileWriter_Example1 {
	public static void main(String[] args) throws IOException{
		File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass22/src/ch1/test.txt");
		FileWriter fw=new FileWriter(f);
		fw.write("Welcome");
		fw.close();
		Scanner sc=new Scanner(f);
		String data=sc.nextLine();
		System.out.println(data);
	}
}
