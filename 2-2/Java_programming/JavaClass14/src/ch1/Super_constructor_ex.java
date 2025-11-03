package ch1;

class Person {
    Person() {
        System.out.println("Person class constructor");
    }
}
class Officer extends Person {
    Officer() {
        super();
        System.out.println("Officer class constructor");
    }
}
public class Super_constructor_ex {
    public static void main(String[] args) {
        Officer officer = new Officer();
    }
}
