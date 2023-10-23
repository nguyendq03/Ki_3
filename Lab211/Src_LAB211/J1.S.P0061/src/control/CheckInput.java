
package control;
import java.util.*;
/**
 * This class for check input takes user
 *
 */
public class CheckInput {
     Scanner sc = new Scanner(System.in);

    /**
     * checkInputDouble function will check input of integer must be double
     * values
     *
     * @param message returns message
     * @param minValue returns minValue
     * @param maxValue returns maxValue
     * @return the correct input
     */
    public double checkInputDouble(String message, double minValue, double maxValue) {
        double number = 0;
        boolean check;
        String input;
        //Loop while wrong input
        do {
            System.out.print(message);
            input = sc.nextLine();
            check = true;
            if (input.trim().isEmpty()) {
                System.out.println("The input could not be empty. Please enter a again.");
                check = false;
            } else {
                try {
                    //Convert input of String to double value
                    number = Double.parseDouble(input);
                    //Check if input is between min, max
                    if (number < minValue || number > maxValue) {
                        System.out.println("The input could not be out of range: " + minValue + " to " + maxValue);
                        check = false;
                    } else {
                        return number;
                    }
                    //If the input is string
                } catch (Exception e) {
                    System.out.println("The input could not be a string. Please enter again!");
                    check = false;
                }
            }
        } while (check == false);
        return number;
    }
}
