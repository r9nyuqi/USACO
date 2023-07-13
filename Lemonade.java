
import java.util.*;
import java.io.*;

public class Lemonade {
    public static void main(String[] args) throws FileNotFoundException
    {
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("lemonade.in"));
		int n = in.nextInt();
        int[] cows = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            cows[i] = in.nextInt();
        }
        Arrays.sort(cows);
        for(int i = n-1; i >= 0; i--)
        {
            
            if(cows[i] < count)
            {
                
            }
            else
            {
                count ++;
            
            }
        }
        PrintWriter pw = new PrintWriter(new File("lemonade.out"));
		pw.print(count);
		pw.close();
        
    
    }
    
}
