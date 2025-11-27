package ch1;

import java.io.*;
import java.util.*;

public class FileWriter_Example2 {
	public static void main(String[] args) throws IOException{
		File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/JavaClass22/src/ch1/test.txt");
		try {
			f.createNewFile();
			FileWriter fr=new FileWriter(f);
			String str;
			Scanner sc=new Scanner(System.in);
			str=sc.nextLine();
			fr.write(str);
			fr.close();
		}
		catch(Exception e) {
			System.out.println("Problem with file creation");
		}
	}
}
