package View;

import Model.Fruit;
import Utils.Validation;
import java.util.ArrayList;

public class Menu {

    /**
     * This function displays the menu and gets by user choice.
     *
     * @return An integer representing the user's choice.
     */
    public static int menu() {
        // Loop until the user wants to stop
        System.out.println("1. Create Fruit");
        System.out.println("2. Shopping (for buyer)");
        System.out.println("3. View orders");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        return Validation.checkInputIntLimit(1, 4);
    }

    /**
     * This function allows the user to input information for a fruit and add it
     * to a list.
     *
     * @param listFruit The list of fruits to add to.
     */
    public static void createFruit(ArrayList<Fruit> listFruit) {
        // Loop until the user doesn't want to create a fruit
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();

            // Check if the fruit id already exists or not
            if (!Validation.checkIdExist(listFruit, fruitId)) {
                System.out.println("This type of fruit already exists in your shop!");
                System.out.println("Do you want to add more quantity for this fruit?");
                boolean addMore = Validation.checkInputYN();
                // If you want to add more quantity
                if (addMore) {
                    System.out.print("Enter added quantity: ");
                    int addedQuantity = Validation.checkInputInt();
                    for (Fruit fruit : listFruit) {
                        if (fruit.getFruitId().equals(fruitId)) {
                            fruit.setQuantity(addedQuantity + fruit.getQuantity());
                            System.out.println("Updated quantity successfully!\n" + "New quantity for this fruit is: " + fruit.getQuantity());
                            return;
                        }
                    }
                    // If user not choice add more quantity, then return main menu
                } else {
                    System.out.println("No addition! Back to menu.");
                    return;
                }
            }

            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            listFruit.add(new Fruit(fruitId, fruitName, price, quantity, origin));

            // Check if the user wants to continue or not
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }
}
