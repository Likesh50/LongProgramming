package dineinRestaurant;

public class OrderItem {
    int id;
    String name;
    int price;
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public OrderItem(int id, String name, int price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
    int quantity;
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    String description;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }  
}
