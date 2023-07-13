import java.util.*;
import java.io.*;

public class CowDance {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("cowdance.in"));
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        PriorityQueue pq = new PriorityQueue();
        int[] cows = new int[n];
        for(int i = 0; i < cows.length; i ++)
        {
            cows[i] = in.nextInt();
        }
        int min = 0;
        int max = n;
        while(min < max)
        {
            int time = 0;
            int k = (min + max)/2;
            for(int i = 0; i < k; i ++)
            {
                pq.add(cows[i]);
            }
            for(int i = k; i < cows.length; i ++)
            {
                int smallest = (int) pq.peek();
                pq.poll();
                pq.add((smallest + cows[i]));
                
            }

            while(!pq.isEmpty())
            {
                time = (int) pq.peek();
                pq.poll();
            }
            if(time > t)
            {
                min = (k + 1);
            }
            else{
                max = k;
            }
            

        }

        PrintWriter pw = new PrintWriter(new File("cowdance.out"));
        //System.out.println(min);
		pw.print(min);
		pw.close();



    }
}
