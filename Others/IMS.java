package Others;
import java.util.*;



// Entity Classes
class Product {
    int productId;
    String name;
    String variant;
    String category;

    public Product(int productId, String name, String variant, String category) {
        this.productId = productId;
        this.name = name;
        this.variant = variant;
        this.category = category;
    }
}

class Inventory {
    int inventoryId;
    List<Product> products;
    int quantity;
    String location;
    Date lastUpdated;

    public Inventory(int inventoryId, List<Product> products, int quantity, String location) {
        this.inventoryId = inventoryId;
        this.products = products;
        this.quantity = quantity;
        this.location = location;
        this.lastUpdated = new Date();
    }
}

class Supplier {
    int supplierId;
    String name;
    String contactInfo;
    String billingDetails;

    public Supplier(int supplierId, String name, String contactInfo, String billingDetails) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.billingDetails = billingDetails;
    }
}

class Order {
    int orderId;
    Supplier supplier;
    Date orderDate;
    double totalAmount;

    public Order(int orderId, Supplier supplier, double totalAmount) {
        this.orderId = orderId;
        this.supplier = supplier;
        this.orderDate = new Date();
        this.totalAmount = totalAmount;
    }
}

class Forecast {
    int forecastId;
    Inventory inventory;
    int predictedDemand;
    double accuracy;

    public Forecast(int forecastId, Inventory inventory, int predictedDemand, double accuracy) {
        this.forecastId = forecastId;
        this.inventory = inventory;
        this.predictedDemand = predictedDemand;
        this.accuracy = accuracy;
    }
}

class Report {
    int reportId;
    Date reportDate;
    String content;

    public Report(int reportId, String content) {
        this.reportId = reportId;
        this.reportDate = new Date();
        this.content = content;
    }
}

// Inventory Management System
class InventoryManagementSystem {
    List<Product> products = new ArrayList<>();
    List<Inventory> inventories = new ArrayList<>();
    List<Supplier> suppliers = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    List<Forecast> forecasts = new ArrayList<>();
    List<Report> reports = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addInventory(int inventoryId, List<Product> productList, int quantity, String location) {
        Inventory inventory = new Inventory(inventoryId, productList, quantity, location);
        inventories.add(inventory);
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void generateForecast(Inventory inventory, int predictedDemand, double accuracy) {
        forecasts.add(new Forecast(forecasts.size() + 1, inventory, predictedDemand, accuracy));
    }

    public void generateReport(String content) {
        reports.add(new Report(reports.size() + 1, content));
    }

    public void displayInventory() {
        for (Inventory inv : inventories) {
            System.out.print("Products: ");
            for (Product product : inv.products) {
                System.out.print(product.name + "(" + product.variant + ") ");
            }
            System.out.println("| Quantity: " + inv.quantity + " | Location: " + inv.location);
        }
    }
}

public class IMS {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product product1 = new Product(1, "Burger", "Large", "Food");
        Product product2 = new Product(2, "Fries", "Medium", "Food");
        ims.addProduct(product1);
        ims.addProduct(product2);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        ims.addInventory(1, productList, 100, "Warehouse A");

        Supplier supplier1 = new Supplier(1, "ABC Supplies", "abc@example.com", "123 Main St");
        ims.addSupplier(supplier1);

        Order order1 = new Order(1, supplier1, 500.0);
        ims.addOrder(order1);

        ims.generateForecast(ims.inventories.get(0), 120, 95.5);
        ims.generateReport("Inventory Report: Stock levels for burgers and fries are healthy.");

        ims.displayInventory();
    }
}
