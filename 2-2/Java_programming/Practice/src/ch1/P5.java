package ch1;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array->");
        int size=sc.nextInt();
        System.out.println("Array length->"+size);
        System.out.println("Enter "+size+" Elements");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("****Output*****");
        int sum = 0;
        for (int i:arr){
            System.out.print(i+" ");
            sum+=i;
        }
        System.out.println();
        System.out.println("Total->"+sum);
    }
}
