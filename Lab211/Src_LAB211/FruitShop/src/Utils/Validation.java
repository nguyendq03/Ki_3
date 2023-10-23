package Utils;

import Model.*;
import java.util.*;

public class Validation {

    public static final Scanner in = new Scanner(System.in);

    /**
     * Check user input number limit
     * @param min is values min in range
     * @param max is value max in range
     * @return
     */
    public static int checkInputIntLimit(int min, int max) {
        //Loop until user input correct
        while (true) {
            try {
                //Convert string to integer value
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {


                }
                return result;
                //When it can't convert a string to a number
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Check user input string
     * @return string have checked
     */
    public static String checkInputString() {
        //Loop until user input correct
        while (true) {
            // Read input string for remove any whitespace
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Check user input int
     * @return is integer have checked
     */
    public static int checkInputInt() {
        //Loop until user input correct
        while (true) {
            try {
                //Convert string to integer value
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
                //When it can't convert a string to a number
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Check user input double
     * @return is double have checked
     */
    public static double checkInputDouble() {
        //Loop until user input correct
        while (true) {
            try {
                //Convert string to double value
                double result = Double.parseDouble(in.nextLine());
                return result;
                //When it can't convert a string to a number
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    /**
     * Check user input yes or no
     * @return is true if enter "Y", false if enter "N"
     */
    public static boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    /**
     * This function checks if the ID of fruit exists
     *
     * @param fruitList The list of fruits
     * @param fruitId The fruit ID
     * @return true/ false if fruit exits or not
     */
    public static boolean checkIdExist(ArrayList<Fruit> fruitList, String fruitId) {
        for (Fruit fruit : fruitList) {
            //Check if the passed fruitId is the same as fruitId of fruit
            if (fruitId.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }

    /**
     * This function check if an item has been ordered in the order list.
     *
     * @param orderList The list of orders
     * @param fruitId The ordered fruit ID
     * @return true/ false if fruit exits or not
     */
    public static boolean checkItemExist(ArrayList<OrderedFruit> orderList, String fruitId) {
        for (OrderedFruit order : orderList) {
            if (order.getFruitId().equalsIgnoreCase(fruitId)) {
                return false;
            }
        }
        return true;
    }
}
