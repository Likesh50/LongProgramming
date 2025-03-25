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

        System.out.println("Welcome to Train Booking Application");

        while(loop)
        {
            System.out.println("For Train Ticket Booking, Type - 1");
            System.out.println("For printing the status, Type  - 2");
            System.out.println("For Cancelling the status, Type  - 3");
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

                    ArrayList<ArrayList<Integer>> result=tb.bookTicket(s, d, count,id,false);

                    ArrayList<Integer> confirmed=result.get(0);
                    ArrayList<Integer> waitingSeat=result.get(1);

                    if(confirmed.size()==0 && waitingSeat.size()==0)
                    {
                        break;
                    }

                    tickets.add(new Ticket(id++, s, d, count, confirmed, waitingSeat));

                    System.out.println(tickets.get(tickets.size()-1).toString());

                    System.out.println("The tickets booked successfuly");
                    break;
                }

                case 2:
                {
                    tb.printBooking();
                    System.out.print(tickets.get(0).toString());
                    break;
                }

                case 3:
                {
                    System.out.println("Enter the PNR number" );
                    int pnr=sc.nextInt();

                    System.out.println("Enter the number of seats to be cancled");
                    int no=sc.nextInt();

                    Ticket cancel=getTicket(tickets,pnr);

                    System.out.println(cancel.toString());

                    HashMap<Integer,ArrayList<Integer>> res=tb.cancelTicket(cancel.getSource(), cancel.getDestination(), no, cancel.getConfirmed(), cancel.getWaiting());

                    for(Map.Entry<Integer,ArrayList<Integer>> map:res.entrySet())
                    {
                        int PNR=map.getKey();
                        ArrayList<Integer> moving=map.getValue();

                        Ticket temp=getTicket(tickets, PNR);

                        for(int i=0;i<moving.size();i++)
                        {
                            temp.getWaiting().remove(Integer.valueOf(moving.get(i)));
                            temp.getConfirmed().add(moving.get(i));
                            temp.setCount(temp.getCount()-1);
                        }
                        
                    }

                    System.out.println("The cancellation is done");

                }


                default:
                    break;
            }
        }

        sc.close();
    }

    public static Ticket getTicket(ArrayList<Ticket> tickets,int pnr)
    {
        for(int i=0;i<tickets.size();i++)
        {
            if(tickets.get(i).getPnr()==pnr)
            {
                return tickets.get(i);
            }
        }
        return tickets.get(0);
    }
}
