package Utils;

import java.util.Scanner;

/**
 * This class takes data for check input
 *
 * @author Admin
 */
    public class GetData {


    /**
     * This function use requirement user enter a positive number in range.
     * If input invalid, then display error and requirement user re-enter.
     * Returns an integer input from the user within a specified range.
     *
     * @param message the message to prompt the user for input
     * @param minValue the minimum value of the input range (inclusive)
     * @param maxValue the maximum value of the input range (inclusive)
     * @return the integer input from the user
     */
    public int getInt(String message, int minValue, int maxValue) {
        // Uses a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        double number = 0;
        boolean check;
        //do-while loop to repeatedly prompt the user until a valid input is received
        do {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty, please input positive integer number !");
                check = false;
            } else {
                try {
                    //Convert string of input to double
                    number = Double.parseDouble(input);
                    // Check if input is real number
                    if (number != (int) number) {
                        System.out.println("Input can not be double number, please input positive integer number !");
                        check = false;
                      // If it is not, the user is prompted to enter a positive integer
                    } else {
                        // Check if input is out of range number
                        if (number < minValue || number > maxValue) {
                            System.out.println("Input can not out of range, please input in range " + minValue + " - " + maxValue);
                            check = false;
                          // If it is not, the user is prompted to enter a number within the range
                        } else {
                            return (int) number;
                        }
                    }
                    //Check if input is string
                } catch (Exception e) {
                    System.out.println("Input can not be string, please input positive integer number !");
                    check = false;
                }
            }
            //Check if input is false or true
        } while (check == false);
        return (int) number;
    }

    /**
     * getString function to check input must be a string
     *
     * @param message returns message values
     * @return the alert
     */
    public String getString(String message) {
        //Creating a new Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        //Initializes a string variable called "input" and "input" not null
        String input = "";
        //boolean variable called "check
        boolean check;
        //Loop do - while check is check input
        do {
            System.out.println(message);
            //The input is then trimmed to remove any extra whitespace
            input = scanner.nextLine().trim();
            check = true;
            //Check input is empty or not empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty, please input new string");
                check = false;
            }
          //Check if input is false, continue check
        } while (check == false);
        return input;
    }

    /**
     * getFloat function will check the input is floated
     *
     * @param message returns message
     * @param minValue returns minValue
     * @param maxValue returns maxValue
     * @return the valid input as a double
     */
    public double getFloat(String message, float minValue, float maxValue) {
        //Uses a Scanner object to read user input and checks if the input is a valid float within the specified range
        Scanner scanner = new Scanner(System.in);
        double number = 0;
        boolean check;
        //Loop do - while check for check input
        do {
            System.out.println(message);
            //The input is then trimmed to remove any extra whitespace
            String input = scanner.nextLine().trim();
            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty, please input positive integer number !");
                check = false;
              //If not input is empty
            } else {
                try {
                    //Convert string of input to double
                    number = Double.parseDouble(input);
                    // Check if input is real number
                    if (number < minValue || number > maxValue) {
                        System.out.println("Input cannot be out of range, please input in range " + minValue + " - " + maxValue);
                        check = false;
                      //If input valid, return value number
                    } else {
                        return (int) number;
                    }
                    // Check if input is string
                } catch(Exception e) {
                    System.out.println("Input can not be string, please input positive integer number !");
                    check = false;
                }
            }
            //Check if input is false
        } while (check == false);
        return  number;
    }
}

