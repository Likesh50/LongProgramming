package trainBooking;

import java.util.ArrayList;

public class Ticket {
    int pnr;
    char source;
    char destination;
    int count;
    ArrayList<Integer> confirmed;
    ArrayList<Integer> waiting;
    public int getPnr() {
        return pnr;
    }
    public char getSource() {
        return source;
    }
    public char getDestination() {
        return destination;
    }
    public int getCount() {
        return count;
    }
    public ArrayList<Integer> getConfirmed() {
        return confirmed;
    }
    public ArrayList<Integer> getWaiting() {
        return waiting;
    }
    public void setPnr(int pnr) {
        this.pnr = pnr;
    }
    public void setSource(char source) {
        this.source = source;
    }
    public void setDestination(char destination) {
        this.destination = destination;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setConfirmed(ArrayList<Integer> confirmed) {
        this.confirmed = confirmed;
    }
    public void setWaiting(ArrayList<Integer> waiting) {
        this.waiting = waiting;
    }
    public Ticket(int pnr, char source, char destination, int count, ArrayList<Integer> confirmed,
            ArrayList<Integer> waiting) {
        this.pnr = pnr;
        this.source = source;
        this.destination = destination;
        this.count = count;
        this.confirmed = confirmed;
        this.waiting = waiting;
    }

    
}
