import java.util.*;
import java.io.*;

public class convention {

    static int n;
    static int m;
    static int c;
    static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("convention.in"));
        Scanner in = new Scanner(System.in);
		n = in.nextInt();
        m = in.nextInt();
        c = in.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i ++)
        {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        
        int min = 0;
        int max = arr[arr.length-1];
        while(min < max)
        {
            int trucks = 0;
            int mid = (min + max)/2;
            for(int i = 0; i < n; i+=0)
            {
                 
                int initial = arr[i];
                int count = 1;
                
                while(i < n && arr[i]-initial <= mid && count <= c)
                {
                    i++;
                    count ++;
                }
                trucks ++;
            }

            if(trucks > m)
            {
                min = mid +1;
            }
            else
            {
                max = mid;
            }

    
        }
        System.out.print(min);
        PrintWriter pw = new PrintWriter(new File("convention.out"));
		pw.print(min);
		pw.close();

    }
   
}
