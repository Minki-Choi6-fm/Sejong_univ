package ch1;

class Person {
    private String name;

    public Person() {
        this.name = "Unknown";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Vehicle {
    private String manufacturerName;
    private int cylinders;
    private Person owner;

    public Vehicle() {
        this.manufacturerName = "Unknown";
        this.cylinders = 0;
        this.owner = new Person("Unknown");
    }

    public Vehicle(String manufacturerName, int cylinders, Person owner) {
        this.manufacturerName = manufacturerName;
        this.cylinders = cylinders;
        this.owner = owner;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public int getCylinders() {
        return cylinders;
    }

    public Person getOwner() {
        return owner;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String toString() {
        return "Manufacturer: " + manufacturerName + "\n" +
                "Cylinders: " + cylinders + "\n" +
                "Owner: " + owner;
    }
}

class Truck extends Vehicle {
    private double loadCapacityTons;
    private int towingCapacityPounds;

    public Truck() {
        super();
        this.loadCapacityTons = 0;
        this.towingCapacityPounds = 0;
    }

    public Truck(String manufacturerName, int cylinders, Person owner,
                 double loadCapacityTons, int towingCapacityPounds) {

        super(manufacturerName, cylinders, owner);

        this.loadCapacityTons = loadCapacityTons;
        this.towingCapacityPounds = towingCapacityPounds;
    }

    public double getLoadCapacityTons() {
        return loadCapacityTons;
    }

    public int getTowingCapacityPounds() {
        return towingCapacityPounds;
    }

    public void setLoadCapacityTons(double loadCapacityTons) {
        this.loadCapacityTons = loadCapacityTons;
    }

    public void setTowingCapacityPounds(int towingCapacityPounds) {
        this.towingCapacityPounds = towingCapacityPounds;
    }

    public String toString() {
        return super.toString() + "\n" +
                "Load Capacity: " + loadCapacityTons + " tons\n" +
                "Towing Capacity: " + towingCapacityPounds + " lbs";
    }
}

public class ClassWorkExercise3 {
    public static void main(String[] args) {

        Person owner1 = new Person("Jane Doe");

        System.out.println("--- 1. Creating new truck ---");
        Truck myTruck = new Truck("Ford", 8, owner1, 2.5, 10000);

        System.out.println(myTruck);
        System.out.println("------------------------------");

        System.out.println("\n--- 2. Updating truck information ---");

        Person owner2 = new Person("John Smith");

        myTruck.setOwner(owner2);
        myTruck.setManufacturerName("Hyundai");
        myTruck.setLoadCapacityTons(3.0);

        System.out.println("New Owner: " + myTruck.getOwner().getName());
        System.out.println("New Manufacturer: " + myTruck.getManufacturerName());
        System.out.println("New Load Capacity: " + myTruck.getLoadCapacityTons() + " tons");
        System.out.println("-------------------------------------");

        System.out.println("\n--- 3. Final truck details ---");
        System.out.println(myTruck);
        System.out.println("----------------------------");
    }
}