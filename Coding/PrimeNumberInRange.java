
public class PrimeNumberInRange {
    public static void main(String[] args) {
      
      int arr[]=new int[101];
      
      for(int i=2;i<101;i++)
      {
        if(arr[i]==0)
        {
          System.out.print(i+" ");
          for(int j=1;i*j<101;j++)
          {
            arr[i*j]++;
          }
        }
      }
      
  }
}