package dineinRestaurant;

import java.util.ArrayList;

public class Order {
    int id;
    int res_id;
    int cus_id;
    String date;
    ArrayList<OrderItem> orderList;
    int total_amount;
    public void setId(int id) {
        this.id = id;
    }
    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }
    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setOrderList(ArrayList<OrderItem> orderList) {
        this.orderList = orderList;
    }
    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }
    public int getId() {
        return id;
    }
    public int getRes_id() {
        return res_id;
    }
    public int getCus_id() {
        return cus_id;
    }
    public String getDate() {
        return date;
    }
    public ArrayList<OrderItem> getOrderList() {
        return orderList;
    }
    public int getTotal_amount() {
        return total_amount;
    }
    public Order(int id, int res_id, int cus_id, String date, ArrayList<OrderItem> orderList, int total_amount) {
        this.id = id;
        this.res_id = res_id;
        this.cus_id = cus_id;
        this.date = date;
        this.orderList = orderList;
        this.total_amount = total_amount;
    }

    
}
