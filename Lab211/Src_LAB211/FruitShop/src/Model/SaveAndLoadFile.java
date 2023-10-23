package Model;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class provides methods to save and load fruit information to/from a
 * file. It includes methods to load fruit information from a file and save
 * fruit information to a file.
 */
public class SaveAndLoadFile {

    /**
     * Loads fruit information from a file and adds it to the provided list.
     *
     * @param listFruit the list to which the fruit information is loaded
     */
    public static void loadFruitFromFile(ArrayList<Fruit> listFruit) {
        listFruit.clear();
        try {
            File file = new File("Fruits.txt");
            // Check if empty or not empty before read data
            if (!file.exists()) {
                return;
            }
            // Read file
            FileReader fileReader = new FileReader(file);
            //Support to read files less memory consuming
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            //Loop if file has data
            while ((line = bufferedReader.readLine()) != null) {
                //The method then uses StringTokenizer to read the data from the file with space as a delimiter
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String fruitId = tokenizer.nextToken().trim();
                String fruitName = tokenizer.nextToken().trim();
                //Convert string to a double, then assign price a double
                double price = Double.parseDouble(tokenizer.nextToken().trim());
                //Convert string to integer, then assign quantity to int
                int quantity = Integer.parseInt(tokenizer.nextToken().trim());
                String origin = tokenizer.nextToken().trim();
                // Creates an object of Fruit class with the data read from the file, then adds it to the ArrayList
                listFruit.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            }
            //Closes the BufferedReader and FileReader
            bufferedReader.close();
            fileReader.close();
            // If an exception occurs, it prints the exception message  
        } catch (Exception e) {
            System.err.println("Error loading fruit data: " + e.getMessage());
        }
    }

    /**
     * Saves fruit information from the provided list to a file.
     *
     * @param listFruit the list from which the fruit information is saved
     */
    public static void saveFruitToFile(ArrayList<Fruit> listFruit) {
        try {
            File file = new File("Fruits.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            //It iterates through the fruit and for each fruit
            for (Fruit fruit : listFruit) {
                //Then writes these values to the file using the printWriter.println() method
                printWriter.println(fruit.getFruitId() + ", " + fruit.getFruitName() + ", " + fruit.getPrice() + ", "
                        + fruit.getQuantity() + ", " + fruit.getOrigin());
            }
            //After writing all the data, it closes the printWriter and fileWriter objects to release system resources.
            printWriter.close();
            fileWriter.close();
            System.out.println("Fruit data saved successfully.");
        } catch (Exception e) {
            System.err.println("Error saving fruit data: " + e.getMessage());
        }
    }
}
