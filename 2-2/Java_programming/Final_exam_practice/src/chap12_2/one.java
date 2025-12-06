package chap12_2;

import java.io.*;

public class one {
    public static void main(String[] args) {
        try{
            File f=new File("/Users/allonso77/Desktop/Sejong/2-2/Java_programming/Final_exam_practice/src/chap12_2/fileInfo.txt");
            if(f.exists()){
                System.out.println("파일이 존재합니다.");
                System.out.println("파일 크기: " + f.length() + " bytes");
                System.out.println("절대 경로: " + f.getAbsolutePath());
            }
            else{
                System.out.println("파일이 없습니다. 새로 생성합니다.");
                f.createNewFile();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
