package j1.s.p0050;

import java.util.Scanner;

/**
 *
 * @author Khánh Trang
 */
public class Validate {
    // Check user input number limit.

    public static int checkInputIntLimit(int min, int max, Scanner in) {
        // Loop until user inputs correctly
        while (true) {
            try {
                // Parse the user input as an integer
                int result = Integer.parseInt(in.nextLine().trim());
                // Check if the parsed integer is within the specified range
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                // If the input is valid, return the parsed integer
                return result;
            } catch (NumberFormatException e) {
                // If an exception occurs (e.g., invalid input), display an error message
                System.err.println("Please input a number in the range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * The function use to check input is numerical values or not
     *
     * @param floatString is a string value we want to check
     * @return value or null
     */

    public static Float checkin(String floatString) {
        try {
            Float value = Float.parseFloat(floatString);
            return value;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * The function use to check number is odd number or not.
     *
     * @param number is the number we want to check.
     * @return true if it true, false if it false.
     */
    static boolean isOdd(float number) {
        return number % 2 != 0;
    }

    /**
     * The function use to check number is perfect square or not.
     *
     * @param number is the number we want to check
     * @return true if it's true, and false if it's false.
     */
    public static boolean isPerfectSquare(float number) {
        if (number < 0) {
            return false;
        }

        double sqrt = (int) Math.sqrt(number);
        return (sqrt * sqrt == number);
    }
}
