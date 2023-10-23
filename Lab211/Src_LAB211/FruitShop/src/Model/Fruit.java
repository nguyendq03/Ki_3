package Model;
 
public class Fruit {
    // These are private instance variables of the Fruit class
    private String fruitId; // A unique identifier for the fruit
    private String fruitName; // The name of the fruit
    private double price; // The price of the fruit
    private int quantity; // The quantity of the fruit
    private String origin; // The country of origin of the fruit
     // This is a default constructor for the Fruit class
    public Fruit() {
    }
     // This is a parameterized constructor for the Fruit class
    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId; // Assigning the parameter fruitId to the instance variable fruitId
        this.fruitName = fruitName; // Assigning the parameter fruitName to the instance variable fruitName
        this.price = price; // Assigning the parameter price to the instance variable price
        this.quantity = quantity; // Assigning the parameter quantity to the instance variable quantity
        this.origin = origin; // Assigning the parameter origin to the instance variable origin
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
     // This is a getter method for the price instance variable
    public double getPrice() {
        return this.price;
    }
     // This is a setter method for the price instance variable
    public void setPrice(double price) {
        this.price = price;
    }
     // This is a getter method for the quantity instance variable
    public int getQuantity() {
        return this.quantity;
    }
     // This is a setter method for the quantity instance variable
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     // This is a getter method for the origin instance variable
    public String getOrigin() {
        return this.origin;
    }
     // This is a setter method for the origin instance variable
    public void setOrigin(String origin) {
        this.origin = origin;
    }
}