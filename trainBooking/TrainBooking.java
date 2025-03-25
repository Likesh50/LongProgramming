package trainBooking;

import java.util.ArrayList;

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

    public ArrayList<ArrayList<Integer>> bookTicket(char s,char d,int count)
    {
        return train.bookTicket(s, d, count);
    }
   
    public String printBooking()
    {
        return train.toString();
    }
    
}
