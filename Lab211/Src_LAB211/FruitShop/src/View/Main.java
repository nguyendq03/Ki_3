package View;

import Controller.ManagerFruitShop;
import Model.Fruit;
import Model.OrderedFruit;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        // Create an array list to hold the fruit list
        ArrayList<Fruit> listFruit = new ArrayList<>();

        // Create a hashtable to hold the orders corresponding with the buyer
        Hashtable<String, ArrayList<OrderedFruit>> orderOfBuyer = new Hashtable<>();

        // Loop until the user wants to exit
        while (true) {
            // Get user input choice
            int choice = Menu.menu();

            switch (choice) {
                case 1:
                    Menu.createFruit(listFruit);
                    break;
                case 2:
                    ManagerFruitShop.shopping(listFruit, orderOfBuyer);
                    break;
                case 3:
                    ManagerFruitShop.viewOrderedFruit(orderOfBuyer);
                    break;
                case 4:
                    return;
            }
        }
    }

}
