package ch1;

import java.util.Scanner;

class MultiplesFinder {
    MultiplesFinder() {
        int[] multiplesArray = new int[5];
        int foundCount = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number: ");
            int inputNumber = scanner.nextInt();

            if (inputNumber % 8 == 0) {
                multiplesArray[foundCount] = inputNumber;
                foundCount++;
            }

            for (int j = 0; j < foundCount; j++) {
                System.out.print(multiplesArray[j] + " ");
            }
            System.out.println();
        }
    }
}

public class ClassAssignment1 {
    public static void main(String[] args) {
        new MultiplesFinder();
    }
}