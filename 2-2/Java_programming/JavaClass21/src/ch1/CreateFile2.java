package ch1;

import java.io.*;

public class CreateFile2 {
	public static void main(String[] args){
		try {
			File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass21/src/test.txt");
			if(f.createNewFile()) {
				System.out.println("File created");
			}
			else {
				System.out.println("Already exists");
			}
		}
		catch(IOException e) {
			System.out.println("Exception");
		}
	}
}
