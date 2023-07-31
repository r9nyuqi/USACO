import java.util.*;
import java.io.*;

public class Diamonds {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("diamond.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int k = in.nextInt();

        PriorityQueue pq = new PriorityQueue();

        for(int i = 0; i < n; i ++)
        {
            pq.add(in.nextInt());
        }
        int count = 0;

        while(pq.size() > 0)
        {
            int a = (int) pq.peek();
            pq.poll();
            if(pq.peek() != null)
            {
                if((int) pq.peek() -a <= k)
                {
                    count += 2;
                    pq.poll();
                }
                while((int)pq.peek() - a <= k)
                {
                    pq.poll();
                    count ++;
                }
            }
            
           
        }

        PrintWriter pw = new PrintWriter(new File("diamond.out"));
        pw.println(count);
        pw.close();
        System.out.println(count);
        
    }
}
