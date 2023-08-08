import java.io.*;
import java.util.*;

public class SleepyCowSorting {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("sleepy.in"));
		int n = in.nextInt();
		int[] cows = new int[n];
        
		for (int i = 0; i < n; i++) 
        { 
            cows[i] = in.nextInt(); 
        }
		int answer = n - 1;
		for (int i = n - 2; i >= 0; i--) 
        {
			if (cows[i] < cows[i + 1]) 
            {
				answer = i;
			} 
            else 
            {
				break;
			}
		}
        PrintWriter pw = new PrintWriter(new File("sleepy.out"));
		pw.println(answer);
		pw.close();
	}
}
