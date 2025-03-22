package dineinRestaurant;

public class User {
    int id;
    String name;
    int number;
    String address;
    String username;
    int password;
    int loyality;

    public void setId(int id)
    {
        this.id=id;   
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setNumber(int number)
    {
        this.number=number;
    }

    public int getNumber()
    {
        return number;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address=address;
    }

    public void setUserName(String username)
    {
        this.username=username;
    }

    public String getUserName()
    {
        return username;
    }

    public int getPassword()
    {
        return password;
    }

    public void setPassword(int password)
    {
        this.password=password;
    }

    public User(int id, String name, int number, String address, String username, int password, int loyality) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.address = address;
        this.username = username;
        this.password = password;
        this.loyality = loyality;
    }

    public void setLoyality(int loyality)
    {
        this.loyality=loyality;
    }

    public int getLoyality()
    {
        return loyality;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
}
