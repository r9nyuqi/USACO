import java.util.*;
import java.io.*;

public class AngryCows {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("angry.in"));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        int[] arr = new int[n];
        int min = 0; 
        int max = 0;
        int first = 0;
        int last = 0;
       
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        first = arr[0];
        last = arr[n-1];
        max = arr[arr.length-1];
        
       
        int mid = 0;
        while(min < max)
        { 
           
            int count = 0;
           
            if((max + min) % 2 == 0)
            {
                mid = (max + min)/2;
            }
            else
            {
                mid = (max + min - 1)/2;
            }
             System.out.println(mid);
            System.out.println(min);
             System.out.println(max);
              
            int cow = first + mid;

            while(cow + mid < last)
            {
                System.out.println("cow: " + cow);
                int closest = 0;
                for(int l = arr.length-1; l <= 0; l--)
                {
                    if(arr[l] > cow+mid)
                    {
                        closest = arr[l];
                    }
                }
                cow = closest + mid;
                count ++;
            }
            if (count > k)
            {
                min = mid + 1;

            }
            else
            {
                max = mid;
                System.out.println("true");
               
            }
           
            System.out.println();

           
          
            // System.out.println(mid);
            
            // System.out.println(max);
           
            // System.out.println(min);
            // System.out.println();
        }
       
        
        PrintWriter pw = new PrintWriter(new File("angry.out"));
        System.out.println();
	    pw.print(min);
		pw.close();
        in.close();
        
        
        
    }

}
