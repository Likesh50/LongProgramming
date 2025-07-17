/*
    Z   Z   Z 
      O O O   
    Z O * H O 
      H H H   
    O   O   O 
 */
public class PatternPrinting
{
	public static void main(String[] args) {

		String s="ZOHO";
		int n=s.length();
		
		if(n%2==0)
		{
		    s=s.substring(0,n/2)+"*"+s.substring(n/2,n);
		}
		n=n+1;

		for(int i=0;i<n;i++)
		{
		    if(i==n/2)
		    {
		        for(int j=0;j<n;j++)
		        {
		           
		            System.out.print(s.charAt(j)+" ");
		        }
		        System.out.println();
		        continue;
		    }
		    for(int j=0;j<n;j++)
		    {

		        if(j==i || j==n-1-i || j==n/2)
		        {
		            System.out.print(s.charAt(i)+" ");
		        }
		        else
		        {
		            System.out.print("  ");
		        }
		    }
		    
		    System.out.println();
		}
	}
	
	public static boolean isEven(int i)
	{
	    if(i%2==0)
	        return true;
	       
	    return false;
	}
}