package trainBooking;

import java.util.ArrayList;
import java.util.HashMap;

public class Train {
    int id;
    boolean seats[][];
    boolean waiting[][];
    int vacant[];
    ArrayList<int []> waitingList=new ArrayList<>();

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

    public ArrayList<ArrayList<Integer>> bookTicket(char s,char d,int count,int pnr,boolean upward)
    {
        
        ArrayList<Integer> conformedSeats=new ArrayList<>();
        ArrayList<Integer> waitingSeats=new ArrayList<>();
        if(vacant[s-'A']>=count && vacant[d-'A']>=count)
        {
            
            int cnt=0;
            for(int i=0;i<8;i++)
            {
                
                boolean available=true;
                for(int j=s-'A';j<=d-'A';j++)
                {
                    
                    if(seats[i][j])
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
                    if(cnt==count)
                    {
                        break;
                    }
                }
            }

            if(cnt<count && !upward)
            {
                for(int i=0;i<2;i++)
                {
                    boolean available=true;
                    for(int j=s-'A';j<=d-'A';j++)
                    {
                        if(waiting[i][j])
                        {
                            available=false;
                        }
                    }
                    if(available)
                    {
                        for(int j=s-'A';j<=d-'A';j++)
                        {
                            waiting[i][j]=true;
                        }
                        waitingList.add(new int[]{i,s-'A',d-'A',id});
                        cnt++;
                        waitingSeats.add(i);
                        if(cnt==count)
                        {
                            break;
                        }
                    }
                }
            }

            for(int i=s-'A';i<=d-'A';i++)
            {
                vacant[i]-=count;
            }

            
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
        
        return ans;

    }

    public HashMap<Integer,ArrayList<Integer>> cancelTicket(char s,char d,int count,ArrayList<Integer> confirmed,ArrayList<Integer> waiting)
    {
        int cnt=0;
        HashMap<Integer,ArrayList<Integer>> ret=new HashMap<>();


            for(int con=0;con<confirmed.size();con++)
            {
                
                for(int idx=s-'A';idx<=d-'A';idx++)
                {
                    
                    this.seats[confirmed.get(con)][idx]=false;
                }
                cnt++;
                confirmed.remove(con);
                con--;
                if(cnt==count)
                {
                    break;
                }
            }

            if(cnt<count)
            {
                for(int wai=0;wai<waiting.size();wai++)
                {
                    for(int idx=s-'A';idx<=d-'A';idx++)
                    {
                        this.waiting[waiting.get(wai)][idx]=false;
                    }
                    cnt++;
                    waiting.remove(wai);
                    wai--;
                    if(cnt==count)
                    {
                        break;
                    }
                }
            }
            
            for(int i=s-'A';i<=d-'A';i++)
            {
                vacant[i]+=count;
            }

            

            for(int i=0;i<waitingList.size();i++)
            {
                ArrayList<ArrayList<Integer>> ans=bookTicket((char)(65+waitingList.get(i)[1]),(char)(65+waitingList.get(i)[2]), 1, waitingList.get(i)[3], true);

                ArrayList<Integer> confirm=ans.get(0);

                if(confirm.size()>0)
                {
                    if(ret.containsKey(waitingList.get(i)[3]))
                    {
                        ret.get(waitingList.get(i)[3]).add(confirm.get(0));
                    }
                    else
                    {
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(confirm.get(0));
                        ret.put(waitingList.get(i)[3],temp);
                    }

                    for(int idx=waitingList.get(i)[1];idx<=waitingList.get(i)[2];idx++)
                    {
                        this.waiting[waitingList.get(i)[0]][idx]=false;
                    }
                    waitingList.remove(i);
                    i--;
                }
                else
                {
                    continue;
                }
            }


        return ret;
    }

    

}
