package changebase;

import java.util.Scanner;

/**
 *
 * @author Admin
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

    // Check user input binary number with a fractional part
    public static String checkInputBinary(Scanner in) {
        System.out.print("Enter a binary number: ");
        String result;
        // Loop until user inputs correctly
        while (true) {
            // Read the user input as a string
            result = in.nextLine().trim();
            // Check if the input matches the pattern for a valid binary number with optional fractional part
            if (result.matches("[-+]?[01]+(\\.[01]+)?")) {
                // If the input is valid, return the input string
                return result;
            }
            // If the input is invalid, display an error message
            System.err.println("Please enter a valid binary number (0 or 1 only)");
            System.out.print("Enter again: ");
        }
    }

    // Check user input decimal number with a fractional part
    public static String checkInputDecimal(Scanner in) {
        System.out.print("Enter a decimal number: ");
        String result;
        // Loop until user inputs correctly
        while (true) {
            // Read the user input as a string
            result = in.nextLine().trim();
            // Check if the input matches the pattern for a valid decimal number with optional fractional part
            if (result.matches("[-+]?\\d+(\\.\\d+)?")) {
                // If the input is valid, return the input string
                return result;
            }
            // If the input is invalid, display an error message
            System.err.println("Please enter a valid decimal number");
            System.out.print("Enter again: ");
        }
    }

    // Check user input hexadecimal number with a fractional part
    public static String checkInputHexaDecimal(Scanner in) {
        System.out.print("Enter a hexadecimal number: ");
        String result;
        // Loop until user inputs correctly
        while (true) {
            // Read the user input as a string and convert it to uppercase
            result = in.nextLine().trim().toUpperCase();
            // Check if the input matches the pattern for a valid hexadecimal number with optional fractional part
            if (result.matches("[-+]?[0-9A-F]+(\\.[0-9A-F]*)?")) {
                // If the input is valid, return the input string
                return result;
            }
            // If the input is invalid, display an error message
            System.err.println("Please enter a valid hexadecimal number (0-9, A-F)");
            System.out.print("Enter again: ");
        }
    }
}
