import java.util.*;
import java.io.*;

public class SocialDistance {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("socdist.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] grass = new ArrayList[m];
        for(int i = 0; i < m; i ++)
        {
            grass[i] = new ArrayList<>();
            grass[i].add(in.nextInt());
            grass[i].add(in.nextInt());
        }
        int min = 0; 
        int max = Integer.MAX_VALUE;
        while(min < max)
        {
            int mid = (max - min)/2 + min;
            int count = 0; 
            for(int i = 0; i < m; i ++)
            {
                int num = grass[i].get(0);
                while(num + mid <= grass[i].get(1))
                {
                    num += mid;
                    count ++;
                }
            }

            if(count < n)
            {
                max = mid;
            }
            else
            {
                min = mid +1;
            }
        }
        //System.out.println(min);
        PrintWriter pw = new PrintWriter(new File("socdist.out"));
        pw.println(min);
        pw.close();

    }
}