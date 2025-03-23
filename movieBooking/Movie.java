package movieBooking;

public class Movie {
    int id;
    String name;
    String hero;
    String director;
    String joner;
    Screen screen;
    public void setId(int id) {
        this.id = id;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }
    public Movie(int id, String name, String hero, String director, String joner, Screen screen) {
        this.id = id;
        this.name = name;
        this.hero = hero;
        this.director = director;
        this.joner = joner;
        this.screen = screen;
    }
    public Screen getScreen() {
        return screen;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHero(String hero) {
        this.hero = hero;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setJoner(String joner) {
        this.joner = joner;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getHero() {
        return hero;
    }
    public String getDirector() {
        return director;
    }
    public String getJoner() {
        return joner;
    }

    public void availableSeats()
    {
        Screen sc=getScreen();

        boolean[] seats=sc.getAvailable();

        for(int i=1;i<=seats.length;i++)
        {
            if(!seats[i-1])
                System.out.print("1"+" ");

            else
                System.out.print("0"+" ");
            if(i%10==0)
                System.out.println();
        }
    }

    public int seatAvailablity(int id)
    {
        Screen sc=getScreen();

        boolean[] seats=sc.getAvailable();

        if(!seats[id])
            return 1;

        return -1;
    }

    public void bookTicket(int seat)
    {
        getScreen().bookSeat(seat);
        System.out.println("The seat booked successfully");
    }

    public void cancelTicket(int seat)
    {
        getScreen().cancelSeat(seat);
        System.out.println("The seat cancelled successfully");
    }

    public int getAmount()
    {
        Screen sc=getScreen();

        return sc.getPrice();
    }
    
    @Override
    public String toString()
    {
        return "Movie ID: "+getId()+"\nMovie Name: "+getName()+"\nMovie Hero: "+getHero()+"\nMovie Director: "+getDirector()+"\nMovie Joner: "+getJoner();
    }

}
