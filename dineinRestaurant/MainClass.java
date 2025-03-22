package dineinRestaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MainClass {
    
    

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        int uid=1;
        int resid=1;

        int user_id=-1;

        ArrayList<User> userList=new ArrayList<>();
        ArrayList<Restaurant> restaurantList=new ArrayList<>();

        ArrayList<Table> tables=new ArrayList<>();
        tables.add(new Table(1, 5  , true));
        tables.add(new Table(2, 15  , true));
        tables.add(new Table(3, 10  , true));

        ArrayList<String> reviews=new ArrayList<>();
        reviews.add("Good food");
        reviews.add("Good place");
        reviews.add("Good location");
        reviews.add("Bad service");

        ArrayList<OrderItem> menu=new ArrayList<>();
        menu.add(new OrderItem(1,"Biriyani",250,1,"Popular dish"));
        menu.add(new OrderItem(2,"Nan",200,1,"Bread"));
        menu.add(new OrderItem(3,"Chicken gravy",250,1,"famous curry"));

        restaurantList.add(new Restaurant(resid++,"SS Biriyani","Chennai",12349,tables,reviews,menu));
        restaurantList.add(new Restaurant(resid++,"Buhari","Tambaram",9876,tables,reviews,menu));
        restaurantList.add(new Restaurant(resid++,"ITC","Chennai",129,tables,reviews,menu));
        
        while(loop)
        {
            System.out.println("Welcome to Restaurant booking application");
            System.out.println("Enter 1 - To signup");
            System.out.println("Enter 2 - To login");
            System.out.println("Enter 3 - To look at the available restaurants");
            System.out.println("Enter 4 - To book table in a restaurant");
            System.out.println("Enter 5 - To exit the Restaurant booking application");
            int n=sc.nextInt();

            switch (n) {
                case 1:
                {
                    int id=uid++;
                    System.out.println("Enter your name");
                    String name=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter you phone number");
                    int num=sc.nextInt();
                    System.out.println("Enter your address");
                    sc.nextLine();
                    String address=sc.nextLine();
                    System.out.println("Enter Username name");
                    String username=sc.nextLine();
                    System.out.println("Enter your password");
                    int password=sc.nextInt();
                    System.out.println("User registration succressful");
                    userList.add(new User(id,name,num,address,username,password,0));
                    break;
                }

                case 2:
                {
                    if(user_id!=-1)
                    {
                        System.out.println("User already logged in");
                        break;
                    }
                    System.out.println("Welcome to login page");
                    sc.nextLine();
                    System.out.println("Enter Username");
                    String username=sc.nextLine();
                    System.out.println("Enter the password");
                    int password=sc.nextInt();

                    if(searchUser(userList,username,password)!=-1)
                    {
                        user_id=searchUser(userList,username,password);
                        System.out.println("User logged in");
                    }
                    else
                    {
                        for(int i=0;i<userList.size();i++)
                        {
                            System.out.println(userList.get(i).getId()+" Hello");
                        }
                        System.out.println("The user credentials does not exists");
                    }
                    break;
                }
                
                case 3:
                {
                    System.out.println("The Restaurants available are: ");

                    listRestaurant(restaurantList);
                    break;
                }

                case 4:
                {
                    System.out.println("Welcome to Restaurant booking");

                    System.out.println("Enter the restaurant id");
                    
                    int restaurant_id=sc.nextInt();

                    System.out.println("Available Tables: ");

                    Restaurant r=getRes(restaurant_id,restaurantList);
                    
                    User u=getUser(user_id, userList);


                    r.printTable();

                    System.out.println("Enter the number of table to book");

                    int tablecount=sc.nextInt();

                    System.out.println("Enter the table is: ");

                    for(int i=0;i<tablecount;i++)
                    {
                        int tableid=sc.nextInt();
                        r.bookTable(tableid);
                        System.out.println("Table "+tableid+" Booked");
                    }


                    System.out.println("Enter the number of items to pre order");

                    int count=sc.nextInt();

                    System.out.println("Enter the item id and quantity one by one");

                    HashMap<OrderItem,Integer> order=new HashMap<>();

                    
                    for(int i=0;i<count;i++)
                    {
                        int itemid=sc.nextInt();
                        int quantity=sc.nextInt();
                        order.put(r.getItem(itemid),quantity);
                    }

                    int total=calculateTotal(order);

                    System.out.println("Total bill amount: "+total);

                    System.out.println("Enter the payment method");
                    System.out.println("Enter 1 - Cash \nEnter 2 - Card");
                    int mode=sc.nextInt();

                    if(mode==1)
                    {
                        System.out.println("Enter the payment amount");
                        int money=sc.nextInt();
                        if(money==total)
                        {
                            System.out.println("Amount paid successfully");
                        }
                        else if(money<total)
                        {
                            System.out.println("Amount is less. Payment is cancelled and order is revoked");
                            continue;
                        }
                        else
                        {
                            System.out.println("Balance amount : "+(money - total));
                        }
                    }
                    else
                    {
                        System.out.println("Enter the card pin");
                        int pin=sc.nextInt();
                        System.out.println("Payment is successfull"+pin);
                    }

                    System.out.println("Your reward point of "+ (total/10)+" is added to your loyality points");
                    u.setLoyality(u.getLoyality()+(total/10));

                    System.out.println("Your loyality points is updated to: "+u.getLoyality());

                    System.out.println("Thank you for choosing our Restaurant. The order will be ready soon");
                    System.out.println();
                    System.out.println();
                }

                case 5:
                {
                    loop=false;
                    System.out.println("Thank you for using Restaurant booking application");
                    break;
                }
            
                default:
                    break;
            }

            
        }


        sc.close();
    }
    public static int searchUser(ArrayList<User> userList,String username,int password)
    {
                for(int i=0;i<userList.size();i++)
                {
                    if(userList.get(i).getUserName().equals(username) && userList.get(i).getPassword()==password)
                    {
                        return userList.get(i).getId();
                    }
                }
                return -1;
    }

    public static void listRestaurant(ArrayList<Restaurant> res)
    {
        for(int i=0;i<res.size();i++)
        {
            System.out.println("Hotel id: "+res.get(i).getId()+"Hotel Name: "+res.get(i).getName()+"\nLocation: "+res.get(i).getLocation()+"\nContact: "+res.get(i).getContact()+"\nTables: ");
            res.get(i).printMenu();
            res.get(i).printTable();
            res.get(i).printReview();
        }
    }

    public static int calculateTotal(HashMap<OrderItem,Integer> order)
    {
        int total=0;
        for(Map.Entry<OrderItem, Integer> e:order.entrySet())
        {
            total+=e.getKey().getPrice()*e.getValue();
        }

        return total;
    }

    public static Restaurant getRes(int id, ArrayList<Restaurant> list)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getId()==id)
            {
                return list.get(i);
            }

        }
        return list.get(0);
    }

    public static User getUser(int id,ArrayList<User> users)
    {
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getId()==id)
            {
                return users.get(i);
            }
        }
        return users.get(0);
    }
    

}
