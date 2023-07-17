import java.util.*;
import java.io.*;

public class GrassPlanting {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("planting.in"));
       //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] adj = new int[n];
        for(int i = 0; i < n-1; i ++)
        {
            int a = in.nextInt() -1;
            int b = in.nextInt() -1; 
            adj[a] ++;
            adj[b] ++;
        }
        int max = 0;
        for(int i = 0; i < n; i ++)
        {
            max = Math.max(max,adj[i]);
        }
        PrintWriter pw = new PrintWriter(new File("planting.out"));
        //System.out.println(max+1);
        pw.print((max+1));
        pw.close();

    }
}
