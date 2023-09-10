import java.util.*;
import java.io.*;

public class cowSignal {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("cowsignal.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        String[] str = new String[n];
        String[] ans = new String[n];
        for(int i = 0; i < n; i ++)
        {
            ans[i] = "";
        }
        for(int i = 0; i < n; i ++)
        {
            str[i] = in.next();
        }


        for(int i = 0; i < n; i ++)
        {
            for(int j = 1; j <= m; j++)
            {
                for(int l = 0; l < k; l++)
                {
                    ans[i] += str[i].substring(j-1,j);
                }
            }
        }
        PrintWriter pw = new PrintWriter(new File("cowsignal.out"));
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < k; j++)
            {
                pw.println(ans[i]);
                System.out.println(ans[i]);
            }
            
            
        }

        pw.close();
        
    }
}
