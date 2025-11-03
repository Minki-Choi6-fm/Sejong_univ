package ch1;
class Upper{
    void message(){
        System.out.println("Upper message");
    }
}
class Lower extends Upper{
    void message(){
        System.out.println("Lower message");
    }
    void display(){
        super.message();
        message();
    }
}
public class Super_method_ex {
    public static void main(String[] args) {
        Lower l = new Lower();
        l.display();
    }
}
