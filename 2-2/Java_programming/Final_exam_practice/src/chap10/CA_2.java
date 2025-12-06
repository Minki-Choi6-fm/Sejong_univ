package chap10;

//Chapter 10,p.35

interface Shape{
    abstract void getShape();
}
interface TwoDimensionalShape extends Shape {
     abstract double Area();
}
class Circle implements TwoDimensionalShape{
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double Area() {
        return Math.PI * radius * radius;
    }
    public void getShape() {
        System.out.println("Circle");
        System.out.println("Area = " + Area());
    }
}
class Square implements TwoDimensionalShape{
    private double length;
    public Square(double length) {
        this.length = length;
    }
    public double Area() {
        return length * length;
    }
    public void getShape() {
        System.out.println("Square");
        System.out.println("Area = " + Area());
    }
}
interface ThreeDimensionalShape extends Shape {
     abstract double Area();
     abstract double Volume();
}
class Sphere implements ThreeDimensionalShape{
    private double radius;
    public Sphere(double radius) {
        this.radius = radius;
    }
    public double Area() {
        return 4.0*Math.PI * radius * radius;
    }
    public double Volume() {
        return Math.PI * radius * radius*radius*4.0/3.0;
    }
    public void getShape() {
        System.out.println("Sphere");
        System.out.println("Area = " + Area());
        System.out.println("Volume = " + Volume());
    }
}
class Cube implements ThreeDimensionalShape{
    private double length;
    public Cube(double length) {
        this.length = length;
    }
    public double Area() {
        return 6.0*length * length;
    }
    public double Volume() {
        return length * length * length;
    }
    public void getShape() {
        System.out.println("Cube");
        System.out.println("Area = " + Area());
        System.out.println("Volume = " + Volume());
    }
}

public class CA_2 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(10);
        shapes[2] = new Sphere(20);
        shapes[3] = new Cube(30);

        for (Shape s : shapes) {
            s.getShape();
        }
    }
}
