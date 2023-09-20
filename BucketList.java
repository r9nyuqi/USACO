import java.util.*;
import java.io.*;

public class BucketList {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("highcard.in"));
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        int[] num = new int[n];

        int max = 0;
        for(int i = 0; i <n; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            start[i] = a;
            end[i] = b;
            max = Math.max(max,b);
            num[i] = in.nextInt();
        }
        int buckets =0;

        for(int i = 0; i < max; i++)
        {
            int temp = 0;
            for(int j = 0; j < n; j++)
            {
                if(i == start[j])
                {
                    temp += num[j];
                }
                if(i == end[j])
                {
                    temp -= num[j];
                }
                
                
            }
            buckets = Math.max(buckets,temp);
        }

        PrintWriter pw = new PrintWriter(new File("blist.out"));
        pw.println(buckets);
        pw.close();
        System.out.println(buckets);
    


    }
}