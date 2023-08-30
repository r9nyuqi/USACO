import java.util.*;
import java.io.*;

public class SleepCowSort {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("sleepy.in"));
		int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = in.nextInt();
        }

        int count = 1;
        for(int i = n-1; i > 0; i--)
        {
            if(arr[i-1] > arr[i])
            {
                break;
            }
            count ++;
        }

        PrintWriter pw = new PrintWriter(new File("sleepy.out"));
        pw.println(n-count);
        pw.close();
        System.out.println(n-count);
    }
}
