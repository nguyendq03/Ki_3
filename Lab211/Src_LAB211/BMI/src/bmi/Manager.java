package bmi;

import java.util.Scanner;

/**
 *
 * @author Khánh Trang
 */
public class Manager {

    // Declare a variable with private static final to declare a constant that cannot be changed after assigning its value.
    private static final Scanner in = new Scanner(System.in);

    //Display menu
    public static int menu() {
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = checkInputIntLimit(1, 3);
        return choice;
    }

    //Check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //Loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * The function use to check input is Double form or not.
     *
     * @return true or false
     */
    //Allow user input number double
    public static double checkInputDouble() {
        //Loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * The function use to check input operator is true or false Use
     * equalsIgnoreCase to compare it with operator
     *
     * @return result is the operator we insert to it
     */
    //Allow user input operator
    public static String checkInputOperator() {
        //Loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
            } else if (result.equalsIgnoreCase("+") || result.equalsIgnoreCase("-")
                    || result.equalsIgnoreCase("*") || result.equalsIgnoreCase("/")
                    || result.equalsIgnoreCase("^") || result.equalsIgnoreCase("=")) {
                return result;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
    }

    /**
     * The function allow user to input number;
     *
     * @return number we input
     */
    public static double inputNumber() {
        System.out.print("Enter number: ");
        double number = checkInputDouble();
        return number;
    }

    /**
     * A function to allow user calculator normal at case 1, with operator + , -
     * , * , / , ^ return memory is the result of all calculator
     */
    public static void normalCalculator() {
        double memory;
        System.out.print("Enter number: ");
        memory = checkInputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }

    /**
     * A function use to get BMI status when BMI is calculated and display it to
     * the screen
     *
     * @param bmi is the BMI we calculated
     * @return the status of someone's body depends on BMI
     */
    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

   
    /**
     * A function use to calculate BMI by inserted weight and height and display
     * BMI number and BMI status.
     *
     */
    public static void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = checkInputDouble();
        System.out.print("Enter Height(cm): ");
        double height = checkInputDouble();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
