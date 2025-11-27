package ch1;

import java.io.*;
import java.util.*;

public class ReadingFile {
	public static void main(String[] args) throws IOException {
		InputStream f= new FileInputStream("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass22/src/ch1/test.txt");
		Scanner sc=new Scanner(f);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}
}
