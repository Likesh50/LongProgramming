package taxiBooking;

import java.util.Scanner;
public class MainClass {
    public static void main(String args[]) throws CloneNotSupportedException
    {
        boolean loop=true;

        while(loop)
        {
            System.out.println("1.Book \n2.Display \n3.Cancel");
            
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();

            switch (n) {
                case 1:
                {
                    System.out.println("Enter Booking Details");
                    System.out.println("Enter Pickup Point");
                    char pickup=sc.next().charAt(0);
                    System.out.println("Enter Drop Point");
                    char drop=sc.next().charAt(0);
                    System.out.println("Enter Time");
                    int time=sc.nextInt();

                    System.out.println(TaxiBooking.booking(pickup,drop,time));
                    
                    break;
                }
                case 2:
                {
                    TaxiBooking.display();
                    break;
                }

                case 3:
                {
                    loop = false;
                    System.out.println("\tThank You!!!");
                    sc.close();
                    break;
                }
            
                default:
                    break;
            }

        }
    }
}
