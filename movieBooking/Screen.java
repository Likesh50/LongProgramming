package movieBooking;

public class Screen {
    int id;
    String name;
    int capacity;
    String time;
    int price;

    boolean available[];

    public int getId() {
        return id;
    }

    public Screen(int id, String name, int capacity, String time, int price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.time = time;
        this.price = price;
        
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getTime() {
        return time;
    }

    public boolean[] getAvailable() {
        return available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAvailable(boolean available[]) {
        this.available = available;
    }



    

}
