package ch1;
import java.util.Scanner;

class Array{
    int[] arr;
    Array(int num){
        this.arr = new int[num];
    }
    void inputArray(Scanner sc){
        System.out.println("Enter "+this.arr.length+" Elements");
        for(int i=0;i<this.arr.length;i++){
            this.arr[i]=sc.nextInt();
        }
    }
    void printArray(){
        int j=0;
        for(int i:this.arr){
            System.out.print(i+" ");
            j=j+i;
        }
        System.out.println();
        System.out.println("Total->"+j);
    }
}

public class ClassWorkExercises1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array->");
        int size = sc.nextInt();
        Array a = new Array(size);
        System.out.println("Array length->"+size);

        a.inputArray(sc);
        a.printArray();
        sc.close();
    }
}
