import java.io.*;
import java.util.*;

public class bovine 
{
	static int[] adj;
	static int[] incoming;
	static boolean[] visited;
	static int ans;

	static void dfs (int n) {
		if (!visited[n] && incoming[n] == 0) {
			visited[n] = true;
			incoming[adj[n]]--;
			dfs(adj[n]);
			ans--;
		}
	}

	public static void main(String[] args) throws IOException 
    {
		Scanner in = new Scanner(new FileReader("shuffle.in"));
		PrintWriter out = new PrintWriter("shuffle.out");
		int n = in.nextInt();
		adj = new int[n];
		incoming = new int[n]; 
		
		int child;
		for (int parent = 0; parent < n; parent++) {
			child = in.nextInt()- 1;
			adj[parent] = child;
			incoming[child]++;	
		}

		visited = new boolean[n];
		ans = n;
		for (int i = 0; i < n; i++) {
			dfs(i);
		}
		out.println(ans);
		out.close();
	}
}