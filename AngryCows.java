import java.util.*;
import java.io.*;

public class AngryCows {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("angry.in"));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        int[] arr = new int[n];
       
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int min = 0;
		int max = 500000000;
		while(min != max) {
			int mid = (min+max)/2;
			int used = 0;
			int last = 0;
			while(last < n) {
				used++;
				int curr = last+1;
				while(curr < n && arr[curr] - arr[last] <= 2*mid) 
                {
					curr++;
				}
				last = curr;
			}
			if(used <= k) 
            {
				max = mid;
			}
			else 
            {
				min = mid+1;
			}
		}
	
            PrintWriter pw = new PrintWriter(new File("angry.out"));
            pw.println(min);
            pw.close();
            System.out.println(min);
          

           
          
        }
       
        
       
        
        
    }


