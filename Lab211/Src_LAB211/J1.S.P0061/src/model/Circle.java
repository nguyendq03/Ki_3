package model;

/**
 *  A Circle class that can be used to create circle objects with a given radius and perform calculations related
 *  to the circle's perimeter and area.
 *
 */
public class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        double PI = Math.PI;
        return (float) this.getRadius() * 2 * PI;
    }

    @Override
    public double getArea() {
        double PI = Math.PI;
        return this.getRadius() * this.getRadius() * PI;
    }

    @Override
    public void prinResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + radius);
        System.out.println("Area:" + this.getArea());
        System.out.println("Perimeter:" + this.getPerimeter());
    }
}
