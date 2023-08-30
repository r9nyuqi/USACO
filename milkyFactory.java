import java.util.*;
import java.io.*;

public class milkyFactory {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] count;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("factory.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        count = new int[n];

        adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < n-1; i++)
        {
            int a = in.nextInt() -1;
            int b = in.nextInt() -1;
            adj[a].add(b);
        }
        boolean printed = false;
        PrintWriter pw = new PrintWriter(new File("factory.out"));
        for(int i = 0; i < n; i ++)
        {
            visited = new boolean[n];
            dfs(i);
            
            for(int k = 0; k < n; k ++)
            {
                if(visited[k])
                {
                    count[k] ++;
                }
            }

            
            for(int l = 0; l < n; l ++)
            {
                if(count[l] == n)
                {
                    pw.println(l+1);
                    //System.out.println(l+1);
                    printed = true;
                    break;
                }
            }

            
        }
        if(!printed)
        {
            pw.println(-1);
        }
       
        
        pw.close();
       
    }

    public static void dfs(int i)
    {
        visited[i] = true;
        for(int j : adj[i])
        {
            if(!visited[j])
            {
                dfs(j);
            }
        }

    }
}
