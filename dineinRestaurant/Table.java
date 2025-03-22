package dineinRestaurant;

public class Table {
    int id;
    int no_of_seat;
    boolean available;
    public int getId() {
        return id;
    }
    public int getNo_of_seat() {
        return no_of_seat;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNo_of_seat(int no_of_seat) {
        this.no_of_seat = no_of_seat;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Table(int id, int no_of_seat, boolean available) {
        this.id = id;
        this.no_of_seat = no_of_seat;
        this.available = available;
    }
    
}
