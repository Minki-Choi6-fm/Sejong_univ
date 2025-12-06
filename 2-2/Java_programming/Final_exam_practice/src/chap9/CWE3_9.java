package chap9;

//Chapter 9, p.30

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Vehicle {
    String manufacturerName;
    int cylinders;
    Person owner;

    public Vehicle(String manufacturerName, int cylinders, Person owner) {
        this.manufacturerName = manufacturerName;
        this.cylinders = cylinders;
        this.owner = owner;
    }
    public void printInfo() {
        System.out.println("Manufacturer: " + manufacturerName);
        System.out.println("Cylinders: " + cylinders);
        System.out.println("Owner: " + owner);
    }
}

class Truck extends Vehicle {
    double loadCapacity;
    int towCapacity;

    public Truck(String manufacturerName, int cylinders, Person owner, double loadCapacity, int towCapacity) {
        super(manufacturerName, cylinders, owner);
        this.loadCapacity = loadCapacity;
        this.towCapacity = towCapacity;
    }
    public void printInfo() {
        super.printInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("Tow Capacity: " + towCapacity + " pounds");
    }
}

public class CWE3_9 {
    public static void main(String[] args) {
        Person p1 = new Person("Kim");
        Person p2 = new Person("Lee");

        Vehicle car = new Vehicle("Hyundai", 4, p1);
        car.printInfo();
        System.out.println();
        Truck truck = new Truck("Volvo", 8, p2, 12.5, 20000);
        truck.printInfo();
    }
}