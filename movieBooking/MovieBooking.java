package movieBooking;

import java.util.ArrayList;

public class MovieBooking {
    ArrayList<Movie> movies=new ArrayList<>();


    public void addMovie(Movie m)
    {
        movies.add(m);
    }

    public void displayMovie()
    {
        System.out.println("Available Movies are");
        for(int i=0;i<movies.size();i++)
        {
            Movie m=movies.get(i);
            System.out.println(m.toString());
            System.out.println("------------------------");
        }
    }

    public void displaySeats(int id)
    {
        for(int i=0;i<movies.size();i++)
        {
            if(movies.get(i).getId()==id)
            {
                movies.get(i).availableSeats();
                return;
            }
        }
    }

    public int isAvailable(int mid,int id)
    {
        Movie m=movies.get(mid);

        if(m.seatAvailablity(id)==1)
        {
            return 1;
        }
        
        return -1;
    }

    public int getSeatAmount(int mid)
    {
        Movie m=movies.get(mid);

        return m.getAmount();
    }
}
