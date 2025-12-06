package chap9_2;

//Chapter 9_2,p.34-36

interface GeometricObject {
    abstract double getPerimeter();
    abstract double getArea();
}
interface Resizable{
    abstract void resize(int percentage);
}
class Circle implements GeometricObject {
    protected double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return Math.PI * radius * 2;
    }
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public void TestCircle() {
        System.out.println("--- Circle 정보 확인 ---");
        System.out.println("반지름: " + radius);
        System.out.println("둘레: " + getPerimeter());
        System.out.println("넓이: " + getArea());
    }
}
class ResizableCircle extends Circle implements Resizable {
    ResizableCircle(double radius) {
        super(radius);
    }
    public void resize(int percentage) {
        radius *= percentage;
        radius /= 100;
    }
}

public class CWA_1 {
    public static void main(String[] args) {
        ResizableCircle circle = new ResizableCircle(10);
        circle.TestCircle();
        circle.resize(70);
        circle.TestCircle();
    }
}
