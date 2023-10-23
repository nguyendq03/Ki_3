
package view;

import model.Circle;
import model.Rectangle;
import model.Triangle;
import control.CheckInput;
import java.util.Scanner;

/**
 *  the program allows the user to calculate and display the area and perimeter of different shapes based on their input.
 *
 */
public class Main {
     public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CheckInput checkInput = new CheckInput();
        //Step 1: Display user's input
        System.out.println("=====Calculator Shape Program=====");
        //System.out.print("Please input side width of Rectangle: " );
        //Prompt user of input width 
        double width = checkInput.checkInputDouble("Please input side width of Rectangle:", 1, Double.MAX_VALUE);
        //Prompt user of length values
        double length = checkInput.checkInputDouble("Please input length of Rectangle:", 1, Double.MAX_VALUE);
        //Prompt user of radius values
        double radius = checkInput.checkInputDouble("Please input radius of Circle:", 1, Double.MAX_VALUE);
        //Prompt user of sideA
        double sideA = checkInput.checkInputDouble("Please input side A of Triangle:", 1, Double.MAX_VALUE);
        //Prompt user of sideB
        double sideB = checkInput.checkInputDouble("Please input side B of Triangle:", 1, Double.MAX_VALUE);
        //Prompt user of sideC
        double sideC = checkInput.checkInputDouble("Please input side C of Triangle:", 1, Double.MAX_VALUE);
        Rectangle rectangle = new Rectangle(width, length);
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        Circle circle = new Circle(radius);
        //Step 2: Display Rectangle 
        rectangle.prinResult();
        //Step 3: Display Circle
        circle.prinResult();
        //Step 4: Display Triangle
        triangle.prinResult();
    }
}
