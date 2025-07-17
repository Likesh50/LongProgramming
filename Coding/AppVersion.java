

public class AppVersion
{
	public static void main(String[] args) {
        
        String v1="9.01.15";
        String v2="9.1.15";
        
        String s1[]=v1.split("\\.");
        String s2[]=v2.split("\\.");

        if(s1.length<s2.length)
        {
            System.out.println("Upgrade");
            return;
        }
        else if(s1.length>s2.length)
        {
            System.out.println("Downgrade");
            return;
        }
        else
        {
            for(int i=0;i<s1.length;i++)
            {
                int num1=Integer.parseInt(s1[i]);
                int num2=Integer.parseInt(s2[i]);
                if(num1<num2)
                {
                    System.out.println("Upgrade");
                    return;
                }
                else if(num1>num2)
                {
                    System.out.println("Downgrade");
                    return;
                }
            }
        }
        
        System.out.println("Equal");
	}
	
	
}