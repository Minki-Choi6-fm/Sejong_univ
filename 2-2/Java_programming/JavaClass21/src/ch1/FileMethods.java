package ch1;

import java.io.*;

public class FileMethods {
	public static void main(String[] args) {
		File obj=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass21/src/test.txt");
		if(obj.exists()) {
			System.out.println("File name: "+obj.getName());
			System.out.println("Absolute path: "+obj.getAbsolutePath());
			System.out.println("Writeable: "+obj.canWrite());
			System.out.println("Readable: "+obj.canRead());
			System.out.println("File size in bytes "+obj.length());
		}
		else {
			System.out.println("The file does not exist");
		}
	}
}
