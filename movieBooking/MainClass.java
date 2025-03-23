package movieBooking;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass { 


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        ArrayList<User> userList=new ArrayList();
        ArrayList<Booking> bookings=new ArrayList();
        boolean isAdmin=false;
        int user=-1;
        int booking=1;



        boolean loop=true;
        
        int uid=1;
        int mid=1;

        

        String adminUsername="admin";
        String adminPassword="pass123";

        

        MovieBooking mb=new MovieBooking();

        System.out.println("---------------------------------");
        System.out.println("Welcome to Movie Booking Application");

        while(loop)
        {
            
            System.out.println("For USER Registration, type - 1");
            System.out.println("For user login, type        - 2");
            System.out.println("For Admin login, type       - 3");
            System.out.println("For adding Movie, type      - 4");
            System.out.println("For movie booking, type     - 5");
            System.out.println("For displaying of ticket, type    - 6");
            System.out.println("For cancelling the ticket, type   - 7");

            int operation=sc.nextInt();

            switch (operation) {
                case 1:
                {
                    sc.nextLine();
                    System.out.println("Enter name");
                    String name=sc.nextLine();

                    System.out.println("Enter Phone number");
                    int phone=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Address");
                    String address=sc.nextLine();

                    System.out.println("Enter Username");
                    String username=sc.nextLine();

                    System.out.println("Enter Password");
                    String password=sc.nextLine();

                    userList.add(new User(uid++,name,phone,address,username,password));

                    System.out.println("User Registration Successfull");
                    break;
                }

                case 2:
                {
                    sc.nextLine();
                    System.out.println("Enter Username");
                    String username=sc.nextLine();

                    System.out.println("Enter Password");
                    String password=sc.nextLine();

                    int userId=userlogin(username, password, userList);

                    if(userId==-1)
                    {
                        System.out.println("User Credentials wrong");
                    }
                    else
                    {
                        System.out.println("User Login Successfull");
                    }
                    user=userId;
                    break;
                }

                case 3:
                {
                    sc.nextLine();
                    System.out.println("Enter Admin Username");
                    String username=sc.nextLine();

                    System.out.println("Enter Admin Password");
                    String password=sc.nextLine();

                    if(username.equals(adminUsername) && password.equals(adminPassword))
                    {
                        System.out.println("Admin login Successful");
                        isAdmin=true;
                    }
                    else
                    {
                        System.out.println("Admin credential is entered wrongly");
                    }
                    break;
                }

                case 4:
                {
                    sc.nextLine();
                    System.out.println("Enter Movie name");
                    String name=sc.nextLine();

                    System.out.println("Enter Hero name");
                    String hero=sc.nextLine();

                    System.out.println("Enter Director name");
                    String director=sc.nextLine();

                    System.out.println("Enter Joner name");
                    String joner=sc.nextLine();

                    System.out.println("Enter Screen name");
                    String screenName=sc.nextLine();

                    System.out.println("Enter Capacity name");
                    int capacity=sc.nextInt();

                    sc.nextLine();
                    System.out.println("Enter Time");
                    String time=sc.nextLine();

                    System.out.println("Enter Price of seat");
                    int price=sc.nextInt();

                    mb.addMovie(new Movie(mid, name, hero, director, joner, new Screen(mid, screenName, capacity, time, price)));

                    System.out.println("Movie has been successfully added");
                    break;
                }

                case 5:
                {
                    mb.displayMovie();

                    System.out.println("Enter the movie id for which you need to book the ticket");
                    int movieId=sc.nextInt();

                    mb.displaySeats(movieId);

                    int cnt=-1;
                    int seatid=0;

                    while(cnt!=1)
                    {
                        System.out.println("Enter seat number to book");

                        int seat=sc.nextInt();

                        if(mb.isAvailable(movieId,seat)==1)
                        {
                            System.out.println("Seat Available");
                            cnt=1;
                            seatid=seat;
                        }
                        else
                        {
                            System.out.println("Seat not Available");
                        }
                    }

    
                    System.out.println("The amount is: "+mb.getSeatAmount(mid));

                    System.out.println("Enter 1 for cash and 2 for card");

                    int n=sc.nextInt();

                    if(n==1)
                    {
                        System.out.println("The amount is paid via cash");
                    }
                    else if(n==2)
                    {
                        System.out.println("The amount is paid via card");
                    }
                    else
                    {
                        System.out.println("The booking is not done. All changes are revoked");
                        break;
                    }

                    mb.bookTicket(seatid, movieId-1);

                    bookings.add(new Booking(booking++, user, movieId-1, seatid));
                    break;
                }

                case 6:
                {
                    if(user==-1)
                    {
                        System.out.println("Please login in to see the tickets booked");
                        break;
                    }

                    int count=0;

                    for(int i=0;i<bookings.size();i++)
                    {
                        if(user==bookings.get(i).getUserid())
                        {
                            System.out.println(bookings.get(i).toString());
                            count++;
                        }
                    }
                    if(count==0)
                    {
                        System.out.println("No tickets booked");
                        break;
                    }
                    break;

                }

                case 7:
                {

                    if(user==-1)
                    {
                        System.out.println("For login to do cancellation of ticket");
                    }

                    System.out.println("The tickets you have booked");

                    int count=0;
                    for(int i=0;i<bookings.size();i++)
                    {
                        if(user==bookings.get(i).getUserid())
                        {
                            System.out.println(bookings.get(i).toString());
                            count++;
                        }
                    }
                    if(count==0)
                    {
                        System.out.println("No tickets booked");
                        break;
                    }
                    
                    System.out.println("Enter the booking id to cancel the ticket");

                    int bid=sc.nextInt();
                    
                    Booking b=null;
                    for(int i=0;i<bookings.size();i++)
                    {
                        if(bookings.get(i).getId()==bid)
                        {
                            b=bookings.get(i);
                        }
                    }
                    

                    mb.cancelTicket(b.getMovieid()-1,b.getSeatid());
                    bookings.remove(b.getId());
                    System.out.println("20% will be deduced as cancellation charge");
                    break;
                }

            
                default:
                    break;
            }
        }


        sc.close();
    }



    public static int userlogin(String username,String password,ArrayList<User> userList)
    {
        for(int i=0;i<userList.size();i++)
        {
            User u=userList.get(i);

            if(u.getUsername().equals(username) && u.getPassword().equals(password))
            {
                return u.getId();
            }
        }

        return -1;
    }
}
