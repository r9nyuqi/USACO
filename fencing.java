import java.util.*;
import java.io.*;

public class fencing {
    static int[] x;
    static int[] y;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static int minX = Integer.MAX_VALUE;;
    static int minY = Integer.MAX_VALUE;
    static int maxX = 0;
    static int maxY = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("fenceplan.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int m = in.nextInt();
        x = new int[n];
        y = new int[n];
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        for(int i = 0; i < n; i ++)
        {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i ++)
        {
            int a = in.nextInt() -1;
            int b = in.nextInt() -1; 
            adj[a].add(b);
            adj[b].add(a);
        }
        visited = new boolean[n];

        int minP = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++)
        {
            minX = Integer.MAX_VALUE;;
            minY = Integer.MAX_VALUE;
            maxX = 0;
            maxY = 0;
           
            if(visited[i] == false)
            {
                minP = Math.min(minP, dfs(i));

            }
        }
        //System.out.println(minP);
        PrintWriter pw = new PrintWriter(new File("fenceplan.out"));
		pw.print(minP);
		pw.close();



    }

    public static int dfs(int i)
    {
        int p = 0;
        visited[i] = true;
       
        minX = Math.min(minX,x[i]);
        maxX = Math.max(maxX,x[i]);
        minY = Math.min(minY,y[i]);
        maxY = Math.max(maxY,y[i]);
        for(int c : adj[i])
        {
            if(visited[c] == false)
            {
                dfs(c);
               
            }
        }
      

        p = (maxX-minX)*2 + (maxY-minY) *2;
        return p;



    }
}
