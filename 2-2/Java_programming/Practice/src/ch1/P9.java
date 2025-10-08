package ch1;

class Thing{
    String name;
    static int count;
    Thing(String name){
        this.name = name;
        count++;
    }
    static int getCount(){
        return count;
    }
}

public class P9 {
    public static void main(String[] args) {
        Thing thing1 = new Thing("Bob");
        Thing thing2 = new Thing("Alice");
        Thing thing3 = new Thing("Kevin");
        System.out.println(thing3.getCount());
    }
}
