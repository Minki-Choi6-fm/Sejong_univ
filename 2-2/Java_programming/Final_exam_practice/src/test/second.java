package test;

import java.util.*;

public class second {
    void setTemperature(int temp)throws Exception{
        if(temp<10)throw new Exception("Too Cold: System Locked");
        if(temp>35)throw new Exception("Too Hot: System Overheat");
    }
    public static void main(String[] args) {
        second s = new second();
        Scanner sc = new Scanner(System.in);
        int input=sc.nextInt();
        try{
            s.setTemperature(input);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Temperature Check Complete");
        }
    }
}
