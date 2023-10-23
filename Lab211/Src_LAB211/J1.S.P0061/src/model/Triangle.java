
package model;

/**
 * A triangle and provides methods to calculate its area and perimeter, as well as print its details.
 *
 */
public class Triangle extends Shape {
    private double sideA, sideB, sideC;
    public Triangle() {
    }
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    public double getSideA() {
        return sideA;
    }
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    public double getSideB() {
        return sideB;
    }
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    public double getSideC() {
        return sideC;
    }
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
    @Override
    public double getArea() {
        double PI = Math.PI;

        return Math.sqrt(this.getPerimeter() / 2 * (this.getPerimeter() / 2 - this.sideA)
                * (this.getPerimeter() / 2 - this.sideB) * (this.getPerimeter() / 2 - this.sideC)
        );

    }

    @Override
    public double getPerimeter() {

        return this.sideA + this.sideB + this.sideC;

    }

    @Override
    public void prinResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + this.getSideA());
        System.out.println("Side B: " + this.getSideB());
        System.out.println("Side C: " + this.getSideC());
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter " + getPerimeter());

    }
}
