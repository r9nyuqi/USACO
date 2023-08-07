import java.util.*;
import java.io.*;

public class CowCollege {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        long max = 0;
        int index = 0; 
        
        for(int i = n-1; i >= 0; i--)
        {
            long current = (long) arr[i] * (long)(n-i);
            if(Math.max(current,max) == current)
            {
                max = current;
                index = arr[i];
            }
        }
        System.out.println(max + " " + index);
    }
}
