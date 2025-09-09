package ch1;

public class Q3_print {
    public void display(){
        int totalWidth=9;
        for (int i = totalWidth; i >= 1; i -= 2) {
            for (int j = 0; j < (totalWidth - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("#");
            }
            System.out.println();
        }

        // 아래쪽 부분
        for (int i = 3; i <= totalWidth; i += 2) {
            for (int j = 0; j < (totalWidth - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
