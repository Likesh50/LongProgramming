package Restaurant;
import java.util.*;

// Customer Entity
class Customer {
    int customerId;
    String name;
    String contactNumber;

    public Customer(int customerId, String name, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
    }
}

// Menu Item Entity
class MenuItem {
    int menuItemId;
    String name;
    String category;
    double price;

    public MenuItem(int menuItemId, String name, String category, double price) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

// Order Item (Associative Entity)
class OrderItem {
    MenuItem menuItem;
    int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }
}

// Order Entity
class Order {
    int orderId;
    Customer customer;
    List<OrderItem> items;
    double totalAmount;
    String status;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.status = "Placed";
    }


    public void addItem(MenuItem item, int quantity) {
        items.add(new OrderItem(item, quantity));
        totalAmount += item.price * quantity;
    }
}

// Kitchen Management
class Kitchen {
    Map<Integer, String> orderStatus = new HashMap<>();

    public void updateOrderStatus(int orderId, String status) {
        orderStatus.put(orderId, status);
        System.out.println("Order " + orderId + " is now " + status);
    }
}

// Payment Processing
class Payment {
    int paymentId;
    int orderId;
    double amount;
    String method;

    public Payment(int paymentId, int orderId, double amount, String method) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
    }
}

// Inventory Management
class Inventory {
    Map<String, Integer> stock = new HashMap<>();

    public void addStock(String ingredient, int quantity) {
        stock.put(ingredient, stock.getOrDefault(ingredient, 0) + quantity);
    }

    public boolean useStock(String ingredient, int quantity) {
        if (stock.getOrDefault(ingredient, 0) >= quantity) {
            stock.put(ingredient, stock.get(ingredient) - quantity);
            return true;
        }
        return false;
    }
}

// Supplier Management
class Supplier {
    int supplierId;
    String name;
    String contactInfo;

    public Supplier(int supplierId, String name, String contactInfo) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactInfo = contactInfo;
    }
}

// Main System
public class RestaurantOrderManagement {
    public static void main(String[] args) {
        // Create Customers
        Customer customer1 = new Customer(1, "John Doe", "123-456-7890");

        // Create Menu Items
        MenuItem burger = new MenuItem(1, "Burger", "Food", 5.99);
        MenuItem fries = new MenuItem(2, "Fries", "Food", 2.99);

        // Create an Order
        Order order1 = new Order(1, customer1);
        order1.addItem(burger, 2);
        order1.addItem(fries, 1);
        System.out.println("Order Total: $" + order1.totalAmount);

        // Process Order in Kitchen
        Kitchen kitchen = new Kitchen();
        kitchen.updateOrderStatus(order1.orderId, "Preparing");
        kitchen.updateOrderStatus(order1.orderId, "Ready");

        // Process Payment
        Payment payment1 = new Payment(1, order1.orderId, order1.totalAmount, "Credit Card");
        System.out.println("Payment of $" + payment1.amount + " received via " + payment1.method);

        // Manage Inventory
        Inventory inventory = new Inventory();
        inventory.addStock("Burger Bun", 50);
        inventory.addStock("Potatoes", 30);
        System.out.println("Stock updated!");

        // Supplier Management
        Supplier supplier1 = new Supplier(1, "ABC Foods", "abc@suppliers.com");
        System.out.println("Supplier: " + supplier1.name + " added!");
    }
}
