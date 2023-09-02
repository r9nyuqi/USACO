import java.util.*;
import java.io.*;

public class DistinctNum {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int a = 1000000000;
        boolean[] arr = new boolean[a];
        int count =0;
        for(int i = 0; i < n; i++)
        {
            int b = in.nextInt();
            if(!arr[b])
            {
                count ++;
                arr[b] = true;
            }
        }
        System.out.println(count);
        
    }
}