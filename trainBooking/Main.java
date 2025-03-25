package trainBooking;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        int id=1;

        boolean seats[][]=new boolean[8][5];
        boolean waiting[][]=new boolean[2][5];
        int available[]=new int[5];
        Arrays.fill(available,10);

        Train t=new Train(1, seats, waiting, available);

        TrainBooking tb=new TrainBooking(t);

        ArrayList<Ticket> tickets=new ArrayList<>();

        System.out.println("Welcom to Train Booking Application");

        while(loop)
        {
            System.out.println("For Train Ticket Booking, Type - 1");
            System.out.println("For printing the status, Type  - 2");
            int n=sc.nextInt();
            switch (n) {
                case 1:
                {
                    sc.nextLine();
                    System.out.println("Enter the Source point");
                    char s=sc.next().charAt(0);
                    System.out.println("Enter the Destination point");
                    char d=sc.next().charAt(0);
                    
                    System.out.println("Enter the Count point");
                    int count=sc.nextInt();

                    ArrayList<ArrayList<Integer>> result=tb.bookTicket(s, d, count);

                    ArrayList<Integer> confirmed=result.get(0);
                    ArrayList<Integer> waitingSeat=result.get(1);

                    if(confirmed.size()==0 && waitingSeat.size()==0)
                    {
                        System.out.println("Not booked");
                        break;
                    }

                    tickets.add(new Ticket(id++, s, d, count, confirmed, waitingSeat));

                    System.out.println("The ticktes booked successfuly");
                    break;
                }

                case 2:
                {
                    tb.printBooking();
                    break;
                }

                default:
                    break;
            }
        }

        sc.close();
    }
}
