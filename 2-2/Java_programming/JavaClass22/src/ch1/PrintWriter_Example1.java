package ch1;

import java.io.*;
import java.util.*;

public class PrintWriter_Example1 {
	public static void main(String[] args) throws IOException{
		File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass22/src/ch1/test.txt");
		PrintWriter fw=new PrintWriter(f);
		Scanner sc=new Scanner(System.in);
		String str1=sc.nextLine();
		fw.println(str1);
		fw.close();
	}
}

