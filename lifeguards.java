import java.util.*;
import java.io.*;

public class lifeguards {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("lifeguards.in"));
		int n = in.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        int[] covered = new int[1000];
        for(int i = 0; i < n; i++)
        {
            start[i] = in.nextInt();
            end[i] = in.nextInt();
        }
        for(int i = 0; i < n; i ++)
        {
            for(int j = start[i]; j < end[i]; j++)
            {
                covered[j] ++;
            }
        }

        int sum = 0;
        
        for(int i = 0; i < n; i++)
        {
            int current = 0;
            for(int j = start[i]; j < end[i]; j++)
            {
                covered[j] --;
            }
            for(int j : covered)
            {
                if(j > 0)
                {
                    current ++;
                }
            }
            sum = Math.max(sum,current);
            for(int j = start[i]; j < end[i]; j++)
            {
                covered[j] ++;
            }

        }
        


        
        

        PrintWriter pw = new PrintWriter(new File("lifeguards.out"));
        pw.println(sum);
        pw.close();
        
    }
}