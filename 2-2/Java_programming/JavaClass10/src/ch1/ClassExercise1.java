package ch1;
import java.util.*;

class Count{
    int[] upperCount = new int[26];
    int[] lowerCount = new int[26];
    int other=0;

    void count(String s){
        char[] ch=s.toCharArray();
        for(char c:ch){
            if('A'<=c&&c<='Z'){
                upperCount[c-'A']++;
            }
            else if('a'<=c&&c<='z'){
                lowerCount[c-'a']++;
            }
            else{
                other++;
            }
        }
        for(int i=0;i<26;i++){
            char A=(char)('A'+i);
            char a=(char)('a'+i);

            System.out.println(A+": "+upperCount[i]+"            "+a+": "+lowerCount[i]);
        }
        System.out.println("Non-alphabetic characters: "+other);
    }
}

public class ClassExercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Count c = new Count();

        System.out.println("Enter a sentence: ");
        String s = sc.nextLine();

        c.count(s);
    }
}
