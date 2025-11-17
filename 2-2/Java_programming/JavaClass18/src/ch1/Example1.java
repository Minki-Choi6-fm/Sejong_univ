package ch1;

interface Age {
    int x = 21;
    void getAge();
}
class Myclass implements Age {
    public void getAge() {
        System.out.println("Age is "+x);
    }
}
public class Example1 {
    public static void main(String[] args) {
        Myclass myclass = new Myclass();
        myclass.getAge();
    }
}
