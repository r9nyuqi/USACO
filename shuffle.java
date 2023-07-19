import java.util.*;
import java.io.*;

public class shuffle {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("shuffle.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int[] order = new int[n];
        int[] id = new int[n];
        for(int i = 0; i < n; i++)
        {
            order[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++)
        {
            id[i] = in.nextInt();
        }
        
        PrintWriter pw = new PrintWriter(new File("shuffle.out"));
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(order[j]-1 == i)
                {
                    pw.println(id[j]);
                    //System.out.println(id[j]);

                }

            }
           
        }
        pw.close();
    }
}