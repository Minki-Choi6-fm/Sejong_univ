package ch1;

import java.util.Scanner;

class Alphabet{
    String str;

    void count(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        str = sc.nextLine();
        int[] uppercase=new int[26];
        int[] lowercase=new int[26];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                lowercase[str.charAt(i)-'a']++;
            }
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                uppercase[str.charAt(i)-'A']++;
            }
        }
        for(int i=0;i<26;i++){
            char A=(char)('A'+i);
            char a=(char)('a'+i);
            System.out.print(A+": "+uppercase[i]+"                "+a+": "+lowercase[i]+"\n");
        }
    }
}

public class P4 {
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        alphabet.count();
    }
}
