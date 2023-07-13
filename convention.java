import java.util.*;
import java.io.*;

public class convention {

    static int n;
    static int m;
    static int c;
    static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("convention.in"));
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
           
            for(int i = 0; i < n; i += c)
            {
                
            }

        }

    }
    public static int trucksUsed(int[] arr, int wait, int c)
    {
        int t = 0;
        for(int i = 0; i < arr.length; i += 0)
        {
            if(arr[i+c] - arr[i] <= wait)
            {   
                t++;
                i = c;

            }
            
        }
    }
}
