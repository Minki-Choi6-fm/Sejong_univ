package ch1;

import java.util.*;
import java.io.*;

public class ReadFile_BufferedReader {
	public static void main(String[] args)throws FileNotFoundException{
		BufferedReader fr=new BufferedReader(new FileReader("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass21/src/test.txt"));
		Scanner sc=new Scanner(fr);
		String str=sc.nextLine();
		System.out.println(str);
	}
}
