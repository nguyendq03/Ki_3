/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
@SuppressWarnings("ALL")
public class GetData {

    Scanner sc = new Scanner(System.in);
/**
 * getInt function will check until the correct input
 * @param message returns massage value
 * @param minValue return minimum Value
 * @param maxValue returns maxValue
 * @return correct input
 */
    @SuppressWarnings("UnusedAssignment")
    public int getInt(String message, int minValue, int maxValue) {
        String input;
        double number = 0;
        boolean check;
        // loop until true input
        do {
            System.out.print(message);
            check = true;
            input = sc.nextLine();
            // check if input is empty
            if (input.trim().isEmpty()) {
                System.out.println("Input can not be empty, please input positive integer number!");
                check = false;
            } else {
                try {
                    number = Double.parseDouble(input);
                    // check if input is real number
                    if (number != (int) number) {
                        System.out.println("Input can not be double number, please input positive integer number!");
                        check = false;
                    } else {
                        // check if input is out of range min-max
                        if (number < minValue || number > maxValue) {
                            System.out.println("Input can not out of range " + minValue + " to " + maxValue);
                            check = false;
                        } else {
                            return (int) number;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input can not be string, please input positive integer number!");
                    check = false;
                }
            }
        } while (check == false);
        return (int)number;
    }
    
  /**
   * checkInputDouble function return correct double input
   * @param message returns message
   * @param minValue returns min Value
   * @param maxValue returns max Value
   * @return correct input
   */
    @SuppressWarnings("UseSpecificCatch")
    public double checkInputDouble(String message, double minValue, double maxValue) {
        //loop until user input correct

        @SuppressWarnings("LocalVariableHidesMemberVariable")
        Scanner scanner = new Scanner(System.in);
        double number = 0;
        boolean check;

        do {

            System.out.print(message);
            check = true;
            String input = scanner.nextLine().trim();
            //Check input is empty
            if (input.isEmpty()) {
                System.out.println("The choice could not be empty. Please input choice from 1 to 5");
                check = false;
            } else {
                try {
                    number = Double.parseDouble(input);
                   
                   
                        //Check input is out of range min to max
                        if (number < minValue || number > maxValue) {
                            System.out.println("The choice could not be out of range 1 to 5. Please input choice from 1 to 5!");
                            check = false;
                        }
                    

                } catch (Exception e) {
                    System.out.println("The choice could not be a string. Please input choice from 1 to 5!");
                    check = false;
                }
            }

        } while (!check);

        return number;

    }

    /**
     *getMatrix function will get the matrix
     * @param message return alerts
     * @return output value
     */
    public double getMatrix(String message) {

        String input;
        double output;
        do {
            System.out.print(message);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input couldn't be empty!");
                   continue;
            } else {

                try {
                    output = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Value of matrix is digit");
                }
            }
            //Loop until true input
        } while (true);

        return output;
    }
}
