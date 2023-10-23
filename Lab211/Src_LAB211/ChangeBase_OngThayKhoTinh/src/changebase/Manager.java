package changebase;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Manager {
    // Display menu

    public static int menu(Scanner in) {
        // Display the menu options
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexadecimal.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        // Get user input for the menu choice using the Validate.checkInputIntLimit method
        int choice = Validate.checkInputIntLimit(1, 4, in);
        return choice;
    }

    // Display choose conversion
    public static int displayConvert(String from, String toCase1, String toCase2, Scanner in) {
        // Display the conversion options based on the "from" parameter
        System.out.println("1. Convert from " + from + " to " + toCase1);
        System.out.println("2. Convert from " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        // Get user input for the conversion choice using the Validate.checkInputIntLimit method
        int result = Validate.checkInputIntLimit(1, 2, in);
        return result;
    }

    // Allow user to convert from decimal
    public static void convertFromDecimal(String decimal) {
        // Get the conversion choice from the user using displayConvert method
        int choice = displayConvert("decimal", "binary", "hexadecimal", new Scanner(System.in));
        switch (choice) {
            case 1:
                // Convert decimal to binary and display the result
                System.out.println("Binary: " + convertDecimalToBinary(decimal));
                break;
            case 2:
                // Convert decimal to hexadecimal and display the result
                System.out.println("Hexadecimal: " + convertDecimalToHexadecimal(decimal));
                break;
        }
    }

    // Allow user to convert from binary
    public static void convertFromBinary(String binary) {
        // Get the conversion choice from the user using displayConvert method
        int choice = displayConvert("binary", "decimal", "hexadecimal", new Scanner(System.in));
        switch (choice) {
            case 1:
                // Convert binary to decimal and display the result
                System.out.println("Decimal: " + convertBinaryToDecimal(binary));
                break;
            case 2:
                // Convert binary to hexadecimal and display the result
                System.out.println("Hexadecimal: " + convertBinaryToHexadecimal(binary));
                break;
        }
    }

    // Allow user to convert from hexadecimal
    public static void convertFromHexadecimal(String hexadecimal) {
        // Get the conversion choice from the user using displayConvert method
        int choice = displayConvert("hexadecimal", "binary", "decimal", new Scanner(System.in));
        switch (choice) {
            case 1:// Convert hexadecimal to binary and display the result
                System.out.println("Binary: " + convertHexadecimalToBinary(hexadecimal));
                break;
            case 2:
                // Convert hexadecimal to decimal and display the result
                System.out.println("Decimal: " + convertHexadecimalToDecimal(hexadecimal));
                break;
        }
    }

    // Convert decimal to binary
    /**
     * The function use to convert Decimal form to Binary form. The function
     * will admit a decimal form ( included integer part and fractional part )
     * The function will check it's negative or not, and save it to " isNegative
     * " to convert it at the end. ( if have ). The function call
     * convertIntegerToBinary and convertFractionalToBinary to convert decimal
     * string form.
     *
     * @param decimal is a string which represents decimal string form to
     * convert.
     * @return binary form of decimal form
     */
    public static String convertDecimalToBinary(String decimal) {
        double doubleDecimal = Double.parseDouble(decimal);
        boolean isNegative = doubleDecimal < 0;
        doubleDecimal = Math.abs(doubleDecimal);
        int intPart = (int) doubleDecimal;
        double fractionalPart = doubleDecimal - intPart;
        String binary = convertIntegerToBinary(intPart) + "." + convertFractionalToBinary(fractionalPart);
        if (isNegative) {
            binary = "-" + binary;
        }
        return binary;
    }

    // Convert decimal to hexadecimal
    /**
     *
     * The function use to convert Decimal form to Hexadecimal form. The
     * function will admit a decimal form ( included integer part and fractional
     * part ) The function will check it's negative or not, and save it to "
     * isNegative " to convert it at the end. ( if have ). The function call
     * convertIntegerToHexadecimal and convertFractionalToHexadecimal to convert
     * decimal string form.
     *
     * @param decimal is the string represents string decimal form to convert.
     * @return hexadecimal form
     */
    public static String convertDecimalToHexadecimal(String decimal) {
        double doubleDecimal = Double.parseDouble(decimal);
        boolean isNegative = doubleDecimal < 0;
        doubleDecimal = Math.abs(doubleDecimal);
        int intPart = (int) doubleDecimal;
        double fractionalPart = doubleDecimal - intPart;
        String hexadecimal = convertIntegerToHexadecimal(intPart) + "." + convertFractionalToHexadecimal(fractionalPart);
        if (isNegative) {
            hexadecimal = "-" + hexadecimal;
        }
        return hexadecimal;
    }

    /**
     * The function use to convert Binary form to decimal form. The function
     * will check it's start with negative form or not, and replace it with a
     * space.( if have ) and save it to isNegative. The function will check it's
     * have fractional form or not. If have, it'll split to 2 parts ( fractional
     * part and integer part )
     *
     * @param binary is the binary string we want to convert it.
     * @return Decimal string form.
     */
    public static String convertBinaryToDecimal(String binary) {
        boolean isNegative = binary.startsWith("-");
        binary = binary.replace("-", "");
        int intPart;
        double fractionalPart = 0;
        // Divide into 2 parts int and frac (if any).
        if (binary.contains(".")) {
            String[] parts = binary.split("\\.");
            intPart = convertBinaryToInteger(parts[0]);
            fractionalPart = convertBinaryToFractional(parts[1]);
            // If not.
        } else {
            intPart = convertBinaryToInteger(binary);
        }
        double decimal = intPart + fractionalPart;
        if (isNegative) {
            decimal = -decimal;
        }
        return String.valueOf(decimal);
    }

    /**
     * This function use to convert Binary to Hexadecimal form. This function
     * will convert from base 2 to 10 , and from base 10 to 16. This function
     * call method to convert.
     *
     * @param binary is the string binary form.
     * @return hexadecimal form.
     */
    public static String convertBinaryToHexadecimal(String binary) {
        String decimal = convertBinaryToDecimal(binary);
        String hexadecimal = convertDecimalToHexadecimal(decimal);
        return hexadecimal;
    }

    /**
     * This function use to convert Hexadecimal to Decimal form. This function
     * will check it start with negative form or not. and replace it if have,
     * save result to isNegative boolean. And split to 2 parts if have
     * fractional form. Call method convertHexadecimalToInteger and
     * convertHexadecimalToFractional.
     *
     * @param hexadecimal is hexadecimal form of string.
     * @return decimal form
     */
    public static String convertHexadecimalToDecimal(String hexadecimal) {
        boolean isNegative = hexadecimal.startsWith("-");
        hexadecimal = hexadecimal.replace("-", "");
        int intPart;
        double fractionalPart = 0;
        if (hexadecimal.contains(".")) {
            String[] parts = hexadecimal.split("\\.");
            intPart = convertHexadecimalToInteger(parts[0]);
            fractionalPart = convertHexadecimalToFractional(parts[1]);
        } else {
            intPart = convertHexadecimalToInteger(hexadecimal);
        }
        double decimal = intPart + fractionalPart;
        if (isNegative) {
            decimal = -decimal;
        }
        return String.valueOf(decimal);
    }

    // Convert hexadecimal to binary
    /**
     * The function use to convert Hexadecimal to Binary by 2 steps: Convert 16
     * to 10 and 10 to 2. Call method to do that.
     *
     * @param hexadecimal is hexadecimal string form.
     * @return binary form of hexadecimal form we insert to.
     */
    public static String convertHexadecimalToBinary(String hexadecimal) {
        String decimal = convertHexadecimalToDecimal(hexadecimal);
        String binary = convertDecimalToBinary(decimal);
        return binary;
    }

    /**
     * The function use to convert Integer form of binary form we insert to
     * decimal integer form.
     *
     * The function declare a decimal = 0 to count all integer decimal form when
     * convert, and power represent power of 2.Then, the method uses a for loop
     * to iterate through each character in the "binary" string from right to
     * left. This is done by setting the initial value of the loop counter "i"
     * to the length of the "binary" string minus 1, and the stopping condition
     * is i >= 0.
     *
     * In each iteration, the method retrieves the integer value corresponding
     * to the current binary digit by subtracting the character '0' (the
     * character zero) from the current character. The result is an integer 0 or
     * 1.
     *
     * Then, the method calculates the integer value of that digit by
     * multiplying the integer value by 2^power, where power is the power of 2
     * corresponding to the position of the digit in the "binary" string. This
     * integer value is added to the "decimal" variable.
     *
     * @param binary is the String we want to convert
     * @return decimal integer form
     */
    private static int convertBinaryToInteger(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int digit = binary.charAt(i) - '0';
            decimal += digit * Math.pow(2, power);
            power++;
        }
        return decimal;
    }

    /**
     * The function use to convert fractional form of binary form we insert to
     * decimal fractional form.
     *
     * The function declare a decimal = 0 to count all fractional decimal form
     * when convert, and power represent power of 2. After this, the function
     * using for loop to scan each digits. In each loop, the function call the
     * integer form of fractional form by -'0' or -'1'. The result will be '0'
     * or '1'.
     *
     * After this, the function calculate the decimal fractional form of the
     * digit by multiply it with (1/2^power) with power is the location of
     * digits and add it to decimal.
     *
     * @param binary is the binary string
     * @return decimal fractional value
     */
    private static double convertBinaryToFractional(String binary) {
        double decimal = 0;
        double power = 1;
        for (int i = 0; i < binary.length(); i++) {
            int digit = binary.charAt(i) - '0';
            decimal += digit * (1 / Math.pow(2, power));
            power++;
        }
        return decimal;
    }

    /**
     * The function use to change a string which represent Hexadecimal form and
     * return the decimal integer form.
     *
     * The function declare a decimal to count all the fractional form of
     * hexadecimal form. And the function declare a power = 1 to represent power
     * of 16.
     *
     * After this, the function use a for loop to check from right side to left
     * side of hexadecimal string by using hexadecimal.length()-1. In each loop
     * wave, using get HexadecimalValue to get decimal form of each digits.
     *
     * After this, the function calculate the integer of this digit by multiply
     * decimal value of the digit with 16^power, and power is the power of 16
     * with the location of digit in string and add it to decimal.
     *
     * @param hexadecimal is the String we want to change to integer decimal
     * form
     * @return decimal form of Hexadecimal form we insert.
     */
    private static int convertHexadecimalToInteger(String hexadecimal) {
        int decimal = 0;
        int power = 0;
        for (int i = hexadecimal.length() - 1; i >= 0; i--) {
            int digit = getHexadecimalValue(hexadecimal.charAt(i));
            decimal += digit * Math.pow(16, power);
            power++;
        }
        return decimal;
    }

    /**
     * The function use to change a string which represent Hexadecimal form and
     * return the fractional decimal form.
     *
     * The function declare a decimal to count all the fractional form of
     * hexadecimal form. And the function declare a power = 1 to represent power
     * of 16.
     *
     * After this, the function is for loop to check all of digits inside
     * hexadecimal string and call function getHexadecimalValue to get decimal
     * form of them. After this, the function will calculate the fractional of
     * this digits by multiply the decimal form of them with (1/16^power), power
     * is the power with 16 with the location of digits.
     *
     * @param hexadecimal is the hexadecimal form.
     * @return decimal form
     */
    private static double convertHexadecimalToFractional(String hexadecimal) {
        double decimal = 0;
        double power = 1;
        for (int i = 0; i < hexadecimal.length(); i++) {
            int digit = getHexadecimalValue(hexadecimal.charAt(i));
            decimal += digit * (1 / Math.pow(16, power));
            power++;
        }
        return decimal;
    }

    /**
     * The function use to change a random integer we import to binary form. The
     * function use an if condition to check if integer == 0 , then the function
     * will return 0 to represent "0" from integer form.
     *
     * If the integer != 0 , the function use a while loop to convert an integer
     * form to binary form. The function will take a remainder when divided it
     * to 2 to take next binary form. And this bit is insert to binary string by
     * using insert. And continue it until remainder == 0.
     *
     *
     * @param integer is an integer we want to change it to Binary form
     * @return binary string form.
     */
    private static String convertIntegerToBinary(int integer) {
        if (integer == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (integer > 0) {
            int digit = integer % 2;
            binary.insert(0, digit);
            integer /= 2;
        }
        return binary.toString();
    }

    /**
     * The function use to change fractional part to binary form. This function
     * accept a double form to change.
     *
     * This function use a while loop to exchange fractional part from decimal
     * form to binary form. This function always multiply to 2 to move to binary
     * form. If (bit==1) -> integer form of fractional is 1, the function add
     * string '1' to binary and -'1' to get the decimal form. If (bit==0), mean
     * the integer form of fractional is 0, the function add string '0' to
     * binary form and continue.
     *
     *
     * @param fractional is the fractional part of decimal form we want to
     * change.
     * @return the binary form of fractional part.
     */
    private static String convertFractionalToBinary(double fractional) {
        StringBuilder binary = new StringBuilder();
        while (fractional > 0) {
            fractional *= 2;

            int bit = (int) fractional;
            if (bit == 1) {
                binary.append("1");
                fractional -= 1;
            } else {
                binary.append("0");
            }
        }
        return binary.toString();
    }

    /**
     * The function use to change the integer part of number we want to convert
     * to Hexadecimal form. This function accept an integer form and and the
     * loop will divide it with 16 and change it to hexadecimal form and
     * continue;
     *
     * @param integer is the integer part of the number we need to change.
     * @return the hexadecimal form of integer part of the number we need to
     * change.
     */
    private static String convertIntegerToHexadecimal(int integer) {
        if (integer == 0) {
            return "0";
        }
        StringBuilder hexadecimal = new StringBuilder();
        while (integer > 0) {
            int digit = integer % 16;
            hexadecimal.insert(0, getHexadecimalDigit(digit));
            integer /= 16;
        }
        return hexadecimal.toString();
    }

    /**
     * The function use to change fractional part of number we want to convert
     * to Hexadecimal form. This function accept a double fractional form and
     * the loop will multiple it with 16 and change it to hexadecimal form and
     * continue.
     *
     * @param fractional is the fractional part of the number we need to change.
     * @return the hexadecimal form of fractional part of the number we need to
     * change.
     */
    private static String convertFractionalToHexadecimal(double fractional) {
        StringBuilder hexadecimal = new StringBuilder();
        while (fractional > 0) {
            fractional *= 16;
            int digit = (int) fractional;
            hexadecimal.append(getHexadecimalDigit(digit));
            fractional -= digit;
        }
        return hexadecimal.toString();
    }

    /**
     * The function use to change an integer value to Hexadecimal form. If value
     * == 0 or value == 9, so the function return it with '0' + value Else if
     * value >10, this function will return A to Z ( from 10 to 15 ) by choosing
     * A and add " value " and -10 because it represent hexadecimal form from A
     * to Z, -0 because it present from 0 to 9.
     *
     * @param value is the value we want to change to Hexadecimal form
     * @return the Hexadecimal form of the value we choose to convert.
     */
    private static char getHexadecimalDigit(int value) {
        if (value >= 0 && value <= 9) {
            return (char) ('0' + value);
        } else {
            return (char) ('A' + (value - 10));
        }
    }

    /**
     * The function use to change a char value to Hexadecimal number form. If
     * digit between 0 and 9, mean decimal form, so the function will return the
     * result of the digit and - '0'. If digit aren't between 0 and 9, that mean
     * a hexadecimal form from 'A' to 'F' and the function will return the
     * result of the digit. We add it 10 because it represent the letter 'A'
     *
     * @param digit
     * @return the digit we want to exchange in Hexadecimal value
     */
    private static int getHexadecimalValue(char digit) {
        if (digit >= '0' && digit <= '9') {
            return digit - '0';
        } else {
            return digit - 'A' + 10;
        }
    }
}
