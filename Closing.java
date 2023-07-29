import java.util.*;
import java.io.*;

public class Closing {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static int[] removed;
    static boolean[] closed;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("closing.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int m = in.nextInt();
        adj = new ArrayList[n];
        visited = new boolean[n];
        removed = new int[n];
        closed = new boolean[n];
        
        for(int i = 0; i < n; i++)
        {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++)
        {
            int a = in.nextInt() -1;
            int b = in.nextInt() -1; 
            adj[a].add(b);
            adj[b].add(a);
        }
        for(int i = 0; i < n; i++)
        {
            removed[i] = in.nextInt()-1;
        }
        PrintWriter pw = new PrintWriter(new File("closing.out"));
        for(int i = 0; i < n; i ++)
        {
            visited = new boolean[n];
            boolean p = true;
            for(int j = 0; j < n; j++)
            {
                if(!closed[j])
                {
                    dfs(j);
                    break;
                }
                
            }
            for(int j = 0; j < n; j ++)
            {
                if(!visited[j] && !closed[j])
                {
                    p = false;
                }
            }
            if(p)
            {
                //System.out.println("YES");
                pw.println("YES");
            }
            else
            {
                //System.out.println("NO");
                pw.println("NO");
            }

            closed[removed[i]] = true;
            
        }
        pw.close();

    }


    public static void dfs(int f)
    {
        visited[f] = true;
        for(int i : adj[f])
        {
            if(!visited[i] && !closed[i])
            {
                dfs(i);
            }
        }
    }
}