package ch1;

import java.util.*;

class GradeBook{
    int[] arr;
    int[] counter;
    GradeBook(int num){
        this.arr=new int[num];
        this.counter=new int[11];
    }
    void readGrade(){
        Scanner sc=new Scanner(System.in);
        System.out.println("The grades are:");
        System.out.println("");
        for(int i=0;i<10;i++){
            System.out.print("Student " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("");
    }
    void calculate_print(){
        float avg=0;
        int min=101;
        int max=0;
        for(int i=0;i<arr.length;i++){
            avg=avg+arr[i];
            if(min>arr[i]){
                min=arr[i];
            }
            if(max<arr[i]){
                max=arr[i];
            }

            int temp=arr[i]/10;
            counter[temp]++;
        }
        avg=avg/arr.length;
        System.out.println("Class average is "+avg);
        System.out.println("Lowest grade is "+min);
        System.out.println("Highest grade is "+max);
        System.out.println("");
    }
    void distribution(){
        System.out.println("Grade distribution:");
        for(int i=0;i<11;i++){
            if(i<10){
                System.out.print(i+"0-"+i+"9:");
            }
            else{
                System.out.print("  100:");
            }
            for(int j=0;j<counter[i];j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}

public class ClassAssignment3 {
    public static void main(String[] args) {
        GradeBook gb=new GradeBook(10);
        gb.readGrade();
        gb.calculate_print();
        gb.distribution();
    }
}
