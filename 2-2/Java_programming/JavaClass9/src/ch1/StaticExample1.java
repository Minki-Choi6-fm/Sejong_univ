package ch1;

class student {
    int id;
    String name;

    void input(int id,String name) {
        this.id = id;
        this.name = name;
        this.display();
    }
    void display() {
       System.out.println(id);
       System.out.println(name);
    }
}

public class StaticExample1 {
    static int id;
    static String name;
    static void input(){
        id=2025;
        name="Sejong";
    }
    public static void main(String[] args) {
        student s1 = new student();
        input();
        s1.input(id,name);
        s1.display();
    }
}