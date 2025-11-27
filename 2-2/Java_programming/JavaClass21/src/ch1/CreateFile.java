package ch1;

import java.io.*;

public class CreateFile {
	public static void main(String[] args) {
		File f1=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass21/src/test.txt");
		System.out.println("Is exist: "+f1.exists());
	}
}
