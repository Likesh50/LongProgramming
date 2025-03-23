package movieBooking;

public class Booking {
    int id;
    int userid;
    int movieid;
    int seatid;
    public void setId(int id) {
        this.id = id;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }
    public void setSeatid(int seatid) {
        this.seatid = seatid;
    }
    public int getId() {
        return id;
    }
    public int getUserid() {
        return userid;
    }
    public int getMovieid() {
        return movieid;
    }
    public int getSeatid() {
        return seatid;
    }
    public Booking(int id, int userid, int movieid, int seatid) {
        this.id = id;
        this.userid = userid;
        this.movieid = movieid;
        this.seatid = seatid;
    }

    @Override
    public String toString()
    {
        return "Booking ID: "+getId()+"\nUser ID: "+getUserid()+"\nMovie ID: "+getMovieid()+"\nSeat ID: "+getSeatid();
    }
}
