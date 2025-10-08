package ch1;

interface Student {
    void getInfo(int id, double weight);
    void display();
}
class Computer implements Student {
    int id;
    double weight;
    public void getInfo(int id, double weight) {
        this.id = id;
        this.weight = weight;
    }
    public void display() {
        System.out.println(id + " " + weight + " ");
    }
}
public class P7 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.getInfo(2024, 72.5);
        computer.display();
    }
}
