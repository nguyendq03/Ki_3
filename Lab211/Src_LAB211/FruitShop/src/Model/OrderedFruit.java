// This is a package named Model
package Model;
 // This is a class named OrderedFruit
public class OrderedFruit {
    // These are private instance variables of the OrderedFruit class
    private String fruitId; // A unique identifier for the fruit
    private String fruitName; // The name of the fruit
    private int quantity; // The quantity of the fruit
    private double price; // The price of the fruit
     // This is a default constructor for the OrderedFruit class
    public OrderedFruit() {
    }
     // This is a parameterized constructor for the OrderedFruit class
    public OrderedFruit(String fruitId, String fruitName, int quantity, double price) {
        this.fruitId = fruitId; // Assigning the parameter fruitId to the instance variable fruitId
        this.fruitName = fruitName; // Assigning the parameter fruitName to the instance variable fruitName
        this.quantity = quantity; // Assigning the parameter quantity to the instance variable quantity
        this.price = price; // Assigning the parameter price to the instance variable price
    }
     // This is a getter method for the fruitId instance variable
    public String getFruitId() {
        return this.fruitId;
    }
     // This is a setter method for the fruitId instance variable
    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }
     // This is a getter method for the fruitName instance variable
    public String getFruitName() {
        return this.fruitName;
    }
     // This is a setter method for the fruitName instance variable
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
     // This is a getter method for the quantity instance variable
    public int getQuantity() {
        return this.quantity;
    }
     // This is a setter method for the quantity instance variable
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     // This is a getter method for the price instance variable
    public double getPrice() {
        return this.price;
    }
     // This is a setter method for the price instance variable
    public void setPrice(double price) {
        this.price = price;
    }
}