import java.util.*;
import java.io.*;



public class milkVisits {
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("milkvisits.in"));
		int n = in.nextInt();
        int m = in.nextInt();

        String cows = in.next();
        adj = new ArrayList[n];
        
        for(int i = 0; i < n; i ++)
        {
            adj[i] = new ArrayList();
        }

        for(int i = 0; i < n; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 0; i < m; i ++)
        {
            
        }
    }
}
