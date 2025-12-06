package chap12_2;

//Chapter 12_2,p.27
import java.io.*;
import java.util.*;

public class CWE_1 {
    public static void main(String[] args) throws IOException {
        File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/Final_exam_practice/src/chap12_2/info.txt");
        f.createNewFile();
        PrintWriter pw = new PrintWriter(f);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name=sc.nextLine();
        System.out.println("Enter your ID:");
        int ID=sc.nextInt();
        System.out.println("Enter your age:");
        int age=sc.nextInt();
        pw.println("NAME:"+name);
        pw.println("ID:"+ID);
        pw.println("AGE:"+age);
        pw.close();
    }
}
