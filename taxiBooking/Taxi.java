package taxiBooking;

public class Taxi implements Cloneable {
    private int taxi_id;
    private int cus_id;
    private char currentLocation='A';
    private char pickup;
    private char drop;
    private int pickup_time;
    private int drop_time;
    private int earnings;

    @Override
    protected Object clone() throws CloneNotSupportedException {
    return super.clone();
    }

    public int getId()
    {
        return taxi_id;
    }

    public void setId(int id)
    {
        this.taxi_id=id;
    }

    public int getCustomer()
    {
        return cus_id;
    }

    public void setCustomer(int id)
    {
        this.cus_id=id;
    }

    public char getPickup()
    {
        return pickup;
    }

    public void setPickup(char pickup)
    {
        this.pickup=pickup;
    }

    public char getDrop()
    {
        return drop;
    }

    public void setDrop(char drop)
    {
        this.drop=drop;
    }

    public int getPickuptime()
    {
        return pickup_time;
    }

    public void setPickupTime(int pickup_time)
    {
        this.pickup_time=pickup_time;
    }

    public int getDropTime()
    {
        return drop_time;
    }

    public void setDropTime(int droptime)
    {
        this.drop_time=droptime;
    }

    public int getEarning()
    {
        return earnings;
    }

    public void setEarnings(int earning)
    {
        this.earnings=earning;
    }

    public char getCurrentLocation()
    {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation)
    {
        this.currentLocation=currentLocation;
    }

    @Override
    public String toString()
    {
        return "Taxi: "+getId()+"\nCurrent Location: "+currentLocation+"\nCustomer: "+getCustomer()+"\nPickup: "+getPickup()+"\nDrop: "+getDrop()+"\nPickup Time: "+getPickuptime()+"\nDrop Time: "+getDropTime()+"\nEarnings: "+getEarning();
    }
    


}
