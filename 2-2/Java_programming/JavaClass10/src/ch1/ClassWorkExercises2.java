package ch1;
import java.util.*;

class Arraycontrol{
    double[] arr;
    Arraycontrol(int size){
        this.arr = new double[size];
    }
    void inputArray(Scanner sc){
        for(int i = 0; i < this.arr.length; i++){
            System.out.print("Enter number "+(i+1)+": ");
            arr[i] = sc.nextDouble();
        }
    }
    void reverseArray(){
        System.out.println("The numbers in reverse order: ");
        for(int i = this.arr.length-1; i >=0; i--){
            System.out.print(this.arr[i]+" ");
        }
    }
}

public class ClassWorkExercises2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size:");
        int size = sc.nextInt();
        Arraycontrol array = new Arraycontrol(size);
        System.out.println("The size of the array: "+size);

        array.inputArray(sc);
        array.reverseArray();
    }
}
