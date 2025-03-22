package dineinRestaurant;

import java.util.ArrayList;

public class Restaurant {
    int id;
    String name;
    String location;
    int contact;
    ArrayList<Table> table=new ArrayList<>();
    ArrayList<String> review=new ArrayList<>();
    ArrayList<OrderItem> menu=new ArrayList<>();
    
    
    public Restaurant(int id, String name, String location, int contact, ArrayList<Table> table, ArrayList<String> review,
            ArrayList<OrderItem> menu) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.table = table;
        this.review = review;
        this.menu = menu;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setContact(int contact) {
        this.contact = contact;
    }
    public void setReview(ArrayList<String> review) {
        this.review = review;
    }
    public void setMenu(ArrayList<OrderItem> menu) {
        this.menu = menu;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public int getContact() {
        return contact;
    }
    public ArrayList<String> getReview() {
        return review;
    }
    public ArrayList<OrderItem> getMenu() {
        return menu;
    }
    public ArrayList<Table> getTable() {
        return table;
    }
    public void setTable(ArrayList<Table> table) {
        this.table = table;
    }

    public void bookTable(int id)
    {
        for(int i=0;i<table.size();i++)
        {
            if(id==table.get(i).getId())
            {
                table.get(i).setAvailable(false);
            }
        }
       
    }

    public OrderItem getItem(int id)
    {
        ArrayList<OrderItem> menu=getMenu();

        for(int i=0;i<menu.size();i++)
        {
            if(menu.get(i).getId()==id)
            {
                return menu.get(i);
            }
        }
        return menu.get(0);
    }

    public Restaurant(){}

    public void  printTable()
    {
        ArrayList<Table> table=getTable();
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Restaurant Tables");
        System.out.println();
        for(int i=0;i<table.size();i++)
        {
            if(table.get(i).isAvailable())
            {
                System.out.println("Table id: "+table.get(i).getId()+"\nNo of Seats: "+table.get(i).getNo_of_seat()+"\nAvailable: "+table.get(i).isAvailable());
                System.out.println();
            }
            else
            {
                System.out.println("Table id: "+table.get(i).getId()+"\nNo of Seats: "+table.get(i).getNo_of_seat()+"\nAvailable: "+table.get(i).isAvailable());
                System.out.println();
            }
            
        }
        System.out.println("--------------------------");
    }

    public void printMenu()
    {
        ArrayList<OrderItem> menu=getMenu();
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Restaurant Menu");
        System.out.println();
        for(int i=0;i<menu.size();i++)
        {
            System.out.println("Item id: "+menu.get(i).getId()+"\nName: "+menu.get(i).getName()+"\nPrice: "+menu.get(i).getPrice()+"\nQuantity: "+menu.get(i).getQuantity());
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public void printReview()
    {
        ArrayList<String> review=getReview();
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("REstaurant Reviews: ");
        System.out.println();
        for(int i=0;i<review.size();i++)
        {
            System.out.println(review.get(i));
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
