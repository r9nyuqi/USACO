import java.io.*;
import java.util.*;

public class realVisits {
	static int[] adj;
	static int[] cows;
	static int[] ids;
	static long ans;
	
	static void dfs1 (int n, int d) {
		if (ids[n] == d) 
            dfs2(adj[n], n, cows[n]);
		if (ids[n] > 0) 
            return;
		ids[n] = d;
		dfs1(adj[n], d);
	} 

	static void dfs2 (int n, int orig, int minMoos) 
    {
		if (n == orig) 
        {
            ans -= minMoos; 
            return;
        }
		dfs2(adj[n], orig, Math.min(cows[n], minMoos));
	}

	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner((System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int N = in.nextInt();
		adj = new int[N];
		cows = new int[N];
		for (int n = 0; n < N; n++) 
        {
			adj[n] = in.nextInt() - 1;
			cows[n] = in.nextInt(); 
			ans += cows[n];
		} 
		
		ids = new int[N];
		int id = 1;
		for (int n = 0; n < N; n++) 
        {
			if (ids[n] == 0) 
                dfs1(n, id++);
		}
		pw.println(ans);
		pw.close();
	}
}