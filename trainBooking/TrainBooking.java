package trainBooking;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainBooking {
    
    Train train;
    
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TrainBooking(Train train) {
        this.train = train;
    }

    public ArrayList<ArrayList<Integer>> bookTicket(char s,char d,int count,int pnr,boolean upward)
    {
        return train.bookTicket(s, d, count,pnr,upward);
    }

    public HashMap<Integer,ArrayList<Integer>> cancelTicket(char s,char d,int count,ArrayList<Integer> confirm,ArrayList<Integer> waiting)
    {
        return train.cancelTicket(s, d, count, confirm, waiting);
    }
   
    public String printBooking()
    {
        return train.toString();
    }
    
}
