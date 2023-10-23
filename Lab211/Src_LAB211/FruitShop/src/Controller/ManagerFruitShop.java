package Controller;

import Model.Fruit;
import Model.OrderedFruit;
import Utils.Validation;

import java.util.ArrayList;
import java.util.Hashtable;

public class ManagerFruitShop {

    /**
     * This function allows the user to view the ordered fruits.
     *
     * @param orderOfBuyer The HashTable containing the orders of buyers.
     */
    public static void viewOrderedFruit(Hashtable<String, ArrayList<OrderedFruit>> orderOfBuyer) {
        //Loop through each key in the Hashtable using a for-each loop, 
        //then the variable name will be assigned a value with a key in the set of keys of orderOfBuyer
        for (String name : orderOfBuyer.keySet()) {
            System.out.println("Customer: " + name);
            //Retrieve the ArrayList of ordered fruits for that customer using the get() method on the Hashtable and passing in the "name" variable
            ArrayList<OrderedFruit> listOrderedFruit = orderOfBuyer.get(name);
            displayListOrderedFruit(listOrderedFruit);
        }
    }
    /**
     * This function allows the user to buy items.
     *
     * @param listFruit The list of available fruits.
     * @param orderOfBuyer The HashTable containing the orders of buyers.
     */
    public static void shopping(ArrayList<Fruit> listFruit, Hashtable<String, ArrayList<OrderedFruit>> orderOfBuyer) {
        // Check if the list is empty
        if (listFruit.isEmpty()) {
            System.out.println("No items available.");
            return;
        }
        ArrayList<OrderedFruit> listOrderedFruit = new ArrayList<>();
        // Loop until the user doesn't want to continue buying
        while (true) {
            // If is empty, then this loop will stop
            if (listFruit.isEmpty()) {
                System.out.println("No items available.");
                break;
            }
            displayListFruit(listFruit);
            System.out.print("Enter item: ");
            String fruitId = Validation.checkInputString();
            while (Validation.checkIdExist(listFruit, fruitId)) {
                System.out.println("Item is not in the shopping list!");
                System.out.print("Enter item: ");
                fruitId = Validation.checkInputString();
            }
            int item = 0;
            // Iterate each elements of listFruit
            for (int i = 0; i < listFruit.size(); i++) {
                //Check if the fruitId of the current element in the list is the same as fruitId
                if (listFruit.get(i).getFruitId().equalsIgnoreCase(fruitId)) {
                    //item variable will contain the position of the element with fruitId
                    item = i + 1;
                }
            }
            Fruit fruit = getFruitByItem(listFruit, item);
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());

            fruit.setQuantity(fruit.getQuantity() - quantity);
            if (fruit.getQuantity() == 0) {
                listFruit.remove(item - 1);
            }
            // Check if the item exists in the ordered list
            if (!Validation.checkItemExist(listOrderedFruit, fruit.getFruitId())) {
                updateOrderedFruit(listOrderedFruit, fruit.getFruitId(), quantity);
            } else {
                listOrderedFruit.add(new OrderedFruit(fruit.getFruitId(), fruit.getFruitName(), quantity, fruit.getPrice()));
            }

            // Check if the user wants to continue buying
            if (!Validation.checkInputYN()) {
                break;
            }
        }

        displayListOrderedFruit(listOrderedFruit);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        orderOfBuyer.put(name, listOrderedFruit);
        System.out.println("Add successful.");
    }

    /**
     * This function displays the list of available fruits in the shop.
     *
     * @param listFruit The list of available fruits.
     */
    public static void displayListFruit(ArrayList<Fruit> listFruit) {
        System.out.println("List of fruits:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |++ Quantity ++|");

        for (Fruit fruit : listFruit) {
            // Check if the shop has the item
            if (fruit.getQuantity() != 0) {
                String money = fruit.getPrice() + "$";
                System.out.printf("       %-13s%-18s%-15s%-10s%-15d\n", fruit.getFruitId(), fruit.getFruitName(), fruit.getOrigin(), money, fruit.getQuantity());
            }
        }
    }

    /**
     * This function retrieves the fruit based on the selected item.
     *
     * @param listFruit The list of available fruits.
     * @param item The selected item.
     * @return The Fruit object corresponding to the selected item.
     */
    public static Fruit getFruitByItem(ArrayList<Fruit> listFruit, int item) {
        int countItem = 1;

        for (Fruit fruit : listFruit) {
            // Check if the number of remaining fruits (quantity) is non-zero.
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            // Check if the current position of the fruit is equal to the number of the desired fruit
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        //Can't find fruit by position in the list
        return null;
    }

    /**
     * This function displays the list of ordered fruits.
     *
     * @param listOrderedFruit The list of ordered fruits.
     */
    public static void displayListOrderedFruit(ArrayList<OrderedFruit> listOrderedFruit) {
        double total = 0;
        System.out.println("Product | Quantity | Price | Amount ");
        for (OrderedFruit order : listOrderedFruit) {
            String money = order.getPrice() + "$";
            String amount = order.getQuantity() * order.getPrice() + "$";
            System.out.printf("    %-8s%-10s%-7s%-7s\n", order.getFruitId(), order.getQuantity(), money, amount);
            total += order.getPrice() * order.getQuantity();
        }

        System.out.println("Total: " + total);
        System.out.println("");
    }

    /**
     * This function updates the quantity of an ordered fruit if it already
     * exists in the list.
     *
     * @param listOrderedFruit The list of ordered fruits.
     * @param id The ID of the fruit to update.
     * @param quantity The quantity to add to the existing ordered fruit.
     */
    public static void updateOrderedFruit(ArrayList<OrderedFruit> listOrderedFruit, String id, int quantity) {
        for (OrderedFruit orderedFruit : listOrderedFruit) {
            if (orderedFruit.getFruitId().equalsIgnoreCase(id)) {
                orderedFruit.setQuantity(orderedFruit.getQuantity() + quantity);
                return;
            }
        }
    }
}
