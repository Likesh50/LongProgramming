package movieBooking;

public class User {
    int id;
    String name;
    int phone;
    String Address;
    String username;
    String password;
    
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPhone() {
        return phone;
    }
    public String getAddress() {
        return Address;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public User(int id, String name, int phone, String address, String username, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        Address = address;
        this.username = username;
        this.password = password;
    }

    
}
