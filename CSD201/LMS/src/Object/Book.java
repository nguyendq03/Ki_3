
package Object;

public class Book {
    private String bcode;
    private String title;
    private int quantity;
    private int lended;
    private double price;

    public Book() {
    }

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public double getPrice() {
        return price;
    }
    
    public double getValue() {
        return Double.parseDouble(String.format("%.1f", price*quantity));
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return bcode+ "\t|\t" + title + "\t|\t" + quantity + "\t|\t" + lended + 
                "\t|\t" + price + "\t|\t" + getValue();
    }
    
}
