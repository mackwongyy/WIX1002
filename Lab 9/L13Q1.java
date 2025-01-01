//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

class Shape {
    protected String name;
    protected double perimeter, area;

    public Shape(String name, double perimeter, double area) {
        this.name = name;
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void shapeDisplay() {
        System.out.println("Shape: " + name);
        System.out.printf("Perimeter: %.2f\n", perimeter);
        System.out.printf("Area: %.2f\n", area);
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(String name) {
        super(name, 0, 0);
    }

    public void inputDimensions() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of the rectangle: ");
        do {
            length = input.nextDouble();
        } while(length < 0);
        System.out.print("Enter the width of the rectangle: ");
        do {
            width = input.nextDouble();
        } while(width < 0);
    }

    public void calculatePerimeterArea() {
        setPerimeter(2 * (length + width));
        setArea(length * width);
    }
}

class Square extends Shape {
    private double length;

    public Square(String name) {
        super(name, 0, 0);
    }

    public void inputDimensions() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of the square: ");
        do {
            length = input.nextDouble();
        } while(length < 0);
    }

    public void calculatePerimeterArea() {
        setPerimeter(4 * length);
        setArea(Math.pow(length, 2));
    }
}

class Circle extends Shape {
    private double diameter;

    public Circle(String name) {
        super(name, 0, 0);
    }

    public void inputDimensions() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the diameter of the circle: ");
        do {
            diameter = input.nextDouble();
        } while(diameter < 0);

        input.close();
    }

    public void calculatePerimeterArea() {
        double radius = diameter / 2;
        setPerimeter(2 * Math.PI * radius);
        setArea(Math.PI * radius * radius);
    }
}

public class L13Q1 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("Rectangle");
        rectangle.inputDimensions();
        rectangle.calculatePerimeterArea();
        rectangle.shapeDisplay();
        System.out.println();

        Square square = new Square("Square");
        square.inputDimensions();
        square.calculatePerimeterArea();
        square.shapeDisplay();
        System.out.println();

        Circle circle = new Circle("Circle");
        circle.inputDimensions();
        circle.calculatePerimeterArea();
        circle.shapeDisplay();
        System.out.println();
    }
}
