package ch1;

import java.io.*;
import java.util.*;

public class ReadFile_Scanner {
	public static void main(String[] args) throws IOException{
		InputStream fin=new FileInputStream("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass21/src/test.txt");
		Scanner sc=new Scanner(fin);
		String str=sc.nextLine();
		System.out.println(str);
	}
}
