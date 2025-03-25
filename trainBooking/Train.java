package trainBooking;

import java.util.ArrayList;

public class Train {
    int id;
    boolean seats[][];
    boolean waiting[][];
    int vacant[];
    public int getId() {
        return id;
    }
    public boolean[][] getSeats() {
        return seats;
    }
    public boolean[][] getWaiting() {
        return waiting;
    }
    public int[] getVacant() {
        return vacant;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setSeats(boolean[][] seats) {
        this.seats = seats;
    }
    public void setWaiting(boolean[][] waiting) {
        this.waiting = waiting;
    }
    public void setVacant(int[] vacant) {
        this.vacant = vacant;
    }
    public Train(int id, boolean[][] seats, boolean[][] waiting, int[] vacant) {
        this.id = id;
        this.seats = seats;
        this.waiting = waiting;
        this.vacant = vacant;
    }

    public void printSeats()
    {
        System.out.println("Confirmed List Display");
        System.out.println();
        System.out.println("A B C D E");
        for(int i=0;i<seats.length;i++)
        {
            for(int j=0;j<seats[0].length;j++)
            {
                if(!seats[i][j])
                {
                    System.out.print("-");
                }
                else
                {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public void printWaiting()
    {
        System.out.println("Waiting List Display");
        System.out.println();

        System.out.println("A B C D E");

        for(int i=0;i<2;i++)
        {

            for(int j=0;j<5;j++)
            {
                if(waiting[i][j])
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString()
    {
        System.out.println("Train id: "+getId());
        printSeats();
        printWaiting();
        return "";
    }

    public ArrayList<ArrayList<Integer>> bookTicket(char s,char d,int count)
    {
        
        ArrayList<Integer> conformedSeats=new ArrayList<>();
        ArrayList<Integer> waitingSeats=new ArrayList<>();
        if(vacant[s-'A']>=count && vacant[d-'A']>=count)
        {
            
            int cnt=0;
            for(int i=0;i<5;i++)
            {
                
                boolean available=true;
                for(int j=s-'A';j<=d-'A';j++)
                {
                    System.out.println("I am in");
                    if(!seats[i][j])
                    {
                        available=false;
                        break;
                    }
                }
                if(available)
                {
                    for(int j=s-'A';j<=d-'A';j++)
                    {
                        seats[i][j]=true;
                    }
                    conformedSeats.add(i);
                    cnt++;
                    if(cnt==count-1)
                    {
                        break;
                    }
                }
            }

            if(cnt<count-1)
            {
                for(int i=0;i<2;i++)
                {
                    boolean available=true;
                    for(int j=s-'A';j<=d-'A';j++)
                    {
                        if(!waiting[i][j])
                        {
                            available=false;
                        }
                    }
                    if(available)
                    {
                        cnt++;
                        waitingSeats.add(11+i);
                        if(cnt==count-1)
                        {
                            break;
                        }
                    }
                }
            }

            vacant[s-'A']-=count;
            vacant[d-'A']-=count;
        }
        else
        {
            System.out.println("There is no sufficient tickets to book the ticket from "+s+" to "+d);
            ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>());
            ans.add(new ArrayList<>());
            return ans;
        }

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans.add(conformedSeats);
        ans.add(waitingSeats);

        System.out.println("I execute");
        return ans;

    }

    

}
