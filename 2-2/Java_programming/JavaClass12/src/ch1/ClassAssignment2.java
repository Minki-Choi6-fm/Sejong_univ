package ch1;

import java.util.*;

public class ClassAssignment2 {
    public static void main(String[] args) {
        ArrayList<Boolean> a = new ArrayList<>(10);
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            a.add(i,false);
        }
        for(int i = 0; i < 10; i++) {
            System.out.print("Enter a class : ");
            int b=sc.nextInt();
            if(b==1){
                if(a.get(4)==true){
                    System.out.println("Is it okay to be placed in Economy class?");
                    String yn = sc.next();
                    if(yn.equalsIgnoreCase("Y")){
                        a.add(5,true);
                    }
                    else if(yn.equalsIgnoreCase("N")){
                        System.out.println("Next flight leaves in 3 hours");
                    }
                }
                else {
                    a.add(0, true);
                }
            }
            else if(b==2){
                if(a.get(9)==true){
                    System.out.println("Is it okay to be placed in First class?");
                    String yn = sc.next();
                    if(yn.equalsIgnoreCase("Y")){
                        a.add(0,true);
                    }
                    else if(yn.equalsIgnoreCase("N")){
                        System.out.println("Next flight leaves in 3 hours");
                    }
                }
                else {
                    a.add(5, true);
                }
            }
        }
    }
}
