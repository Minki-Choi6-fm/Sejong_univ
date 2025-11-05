package ch1;
class Test{
    void output(){
        System.out.println("Nothing");
    }
    void output(int a){
        System.out.println(a);
    }
    void output(int a, float b){
        System.out.println(a);
        System.out.println(b);
    }
    void output(char a,char b){
        System.out.println(b);
        System.out.println(a);
    }
}
public class Method_Overloading {
    public static void main(String[] args) {
        Test t = new Test();
        t.output();
        t.output(10);
        t.output('a');
        t.output('b',200.0f);
        t.output('c','d');
    }
}
