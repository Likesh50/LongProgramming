package taxiBooking;

import java.util.ArrayList;

public class TaxiBooking {
    private static ArrayList<Taxi> taxis=new ArrayList<>();
    private static int idgenerator=1;
    private static int taxiCount=4;
    private static ArrayList<Taxi> history=new ArrayList<>();
    
    public static String booking(char pickup,char drop,int pickup_time) throws CloneNotSupportedException
    {
        if(taxis.size()<taxiCount)
        {
            taxis.add(new Taxi());
        }

        int min=Integer.MAX_VALUE;
        Taxi booking=null;
        for(Taxi t:taxis)
        {
            if(t.getDropTime()<pickup_time && Math.abs(pickup-t.getCurrentLocation())<=min)
            {
                if(Math.abs(t.getDrop()-t.getCurrentLocation())==min)
                {
                    if(booking!=null && booking.getEarning()<t.getEarning())
                    {
                        booking=t;
                    }
                }
                else
                {
                    booking=t;
                    min=Math.abs(pickup-t.getCurrentLocation());
                }
            }
        }

        if(booking!=null)
        {
            booking.setCustomer(idgenerator++);
            booking.setPickup(pickup);
            booking.setDrop(drop);
            booking.setPickupTime(pickup_time);
            booking.setDropTime(Math.abs(pickup-drop)+pickup_time);
            booking.setCurrentLocation(drop);
            booking.setId(taxis.indexOf(booking)+1);
            booking.setEarnings(booking.getEarning()+100+((Math.abs(pickup-drop)*15)-5)*10);

            history.add((Taxi)booking.clone());
        }      

        return booking!=null? "Taxi"+booking.getId()+" is successfully booked":"No Taxi available";
    }

    public static void display()
    {
        System.out.print("------------------------");

        for(Taxi t:history)
        {
            System.out.println(t.toString());
            System.out.println("-----------------------");
        }

    }
}
