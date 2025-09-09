class Student{
    String name;
    int id;
    Student(){
        name="Clinton";
        id=2015;
    }
}
public class SampleMessage {
    public static void main(String[] args) {
        Student obj= new Student();
        System.out.println(obj.name);
        System.out.println(obj.id);
    }
}

