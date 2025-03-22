package dineinRestaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class RestaurantBooking {
    
    ArrayList<Restaurant> hotelList;
    HashMap<OrderItem,Integer> orders;
    int total_amount;
    int res_id;
    int table_id;
    int cus_id;

    public RestaurantBooking()
    {
        hotelList=new ArrayList<>();
        orders=new HashMap<>();
        total_amount=0;
    }

    public void addRestaurant(Restaurant r)
    {
        hotelList.add(r);
        res_id=r.id;
    }

    public void reserveTable(int res_id,int cus_id,int table_id,int no_of_guest)
    {
        Restaurant r=new Restaurant();
        this.cus_id=cus_id;
        for(int i=0;i<hotelList.size();i++)
        {
            if(hotelList.get(i).id==res_id)
            {
                r=hotelList.get(i);
                res_id=r.id;
            }
        }

        ArrayList<Table> tables=r.getTable();
        Table t=null;
        for(int i=0;i<tables.size();i++)
        {
            if(tables.get(i).getId()==table_id)
            {
                if(tables.get(i).isAvailable())
                {
                    t=tables.get(i);
                    table_id=t.id;
                }
                else
                {
                    System.out.println("Table is not available");
                }
            }
            else
            {
                System.out.println("Table does not exits");
            }
        }
    }

    public void orderFood(HashMap<OrderItem,Integer> orders)
    {
        this.orders=orders;
    }

    public int calculateAmount()
    {
        int total=0;

        for(Entry<OrderItem, Integer> e:orders.entrySet())
        {
            total+=e.getKey().getPrice()*e.getValue();
        }

        return total;
    }




    // {
    //     ArrayList<OrderItem> oi=new ArrayList<>();
    //     oi.add(new OrderItem(1,"Biriyani","Food"));
    //     oi.add(new OrderItem(2,"Fried Rice","Food"));
    //     oi.add(new OrderItem(3,"Curry","Food"));
    // }
    
   
}
