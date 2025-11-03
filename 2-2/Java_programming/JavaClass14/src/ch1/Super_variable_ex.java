package ch1;
class A {
    int a=10;
}
class B extends A {
    int a=100;
    void display() {
        System.out.println(a);
        System.out.println(super.a);
    }
}
public class Super_variable_ex {
    public static void main(String[] args) {
        B b = new B();
        b.display();
    }
}
