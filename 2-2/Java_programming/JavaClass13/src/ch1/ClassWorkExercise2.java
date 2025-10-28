package ch1;

class Quadrilateral {
    private int[] p1, p2, p3, p4;

    public Quadrilateral() {
    }

    public void setCoords(int[] p1, int[] p2, int[] p3, int[] p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

}

class Parallelogram extends Quadrilateral {
    protected double base;
    protected double height;

    public Parallelogram() {
    }

    public void setDimensions(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return base * height;
    }
}

class Rectangle extends Parallelogram {
    public Rectangle() {
    }
}

class Square extends Rectangle {
    public Square() {
    }

    public void setDimensions(double side) {
        this.base = side;
        this.height = side;
    }

    public double getArea() {
        return base * base;
    }
}

public class ClassWorkExercise2 {
    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 0};
        int[] p3 = {0, 1};
        int[] p4 = {1, 1};

        Parallelogram p = new Parallelogram();
        p.setCoords(p1, p2, p3, p4);
        p.setDimensions(10, 5);
        System.out.println("Parallelogram Area: " + p.getArea());

        Rectangle r = new Rectangle();
        r.setCoords(p1, p2, p3, p4);
        r.setDimensions(8, 4);
        System.out.println("Rectangle Area: " + r.getArea());

        Square s = new Square();
        s.setCoords(p1, p2, p3, p4);
        s.setDimensions(6);
        System.out.println("Square Area: " + s.getArea());
    }
}