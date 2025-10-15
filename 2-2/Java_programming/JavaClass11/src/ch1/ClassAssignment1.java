package ch1;

import java.util.*;

public class ClassAssignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr=new ArrayList<>(5);
        for(int i=0;i<5;i++){
            System.out.print("Enter number: ");
            int a = sc.nextInt();
            if(a%8==0){
                arr.add(a);
            }
            for(int j=0;j<arr.size();j++){
                System.out.print(arr.get(j)+" ");
            }
            System.out.println();
        }
    }
}
