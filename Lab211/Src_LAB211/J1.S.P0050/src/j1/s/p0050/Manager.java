/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0050;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author izayo
 */
public class Manager {

    public static int menu(Scanner in) {
        // Display the menu options
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        // Get user input for the menu choice using the Validate.checkInputIntLimit method
        int choice = Validate.checkInputIntLimit(1, 3, in);
        return choice;
    }
    
        /**
         * The function use to calculate equation, form is y= ax+b 
         * @param a is coefficient of x
         * @param b is freedom coefficient
         * @return solution is the result of equation
         */
        public static List<Float> calculateEquation(float a, float b) {
        List<Float> solution = new ArrayList<>();

        if (a == 0) {
            if (b == 0) {
                // Infinite solutions
                return solution;
            } else {
                // No solution
                return null;
            }
        } else {
            float x = -b / a;
            solution.add(x);
            return solution;
        }
    }
     /**
      * The function use to calculate Quadratic Equation, form is y = ax^2+bx+c
      * @param a is the quadratic coefficient of x
      * @param b is the coefficient of x
      * @param c is freedom coefficient
      * @return solution is the result of Quadratic Equation
      */
    public static List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> solution = new ArrayList<>();

        float delta = b * b - 4 * a * c;
        
        if (a == 0) {
            return handleAEqual0(solution, a, b, c);
        }
        
         if (delta < 0) {
                // No real solutions
                return null;
            } else if (delta == 0) {
                float x1 = -b / (2 * a);
                float x2 = -b/ (2*a);
                solution.add(x1);
                solution.add(x2);
                return solution;
            } else {
                float x1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
                float x2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
                solution.add(x1);
                solution.add(x2);
                return solution;
            }
    }
    
   private static List<Float> handleAEqual0(List<Float> solution, float a, float b, float c) {
    if (b != 0 && c != 0) {
        solution.add((-c) / b);
    }
    if (b != 0 && c == 0) { 
        solution.add(c);
    }
    if (b == 0 && c != 0) {
        System.out.println("Infinite solution");
        return solution;
    }
    if (b == 0 && c == 0) {
        System.out.println("Infinite solution");
        return solution;
    }

    return solution;
}
}


  
