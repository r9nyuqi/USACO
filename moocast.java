import java.util.*;
import java.io.*;

public class moocast {

    static boolean[] visited;
    static int[] x;
    static int[] y;
    static int[] p;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("moocast.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();

        x = new int[n];
        y = new int[n];
        p = new int[n];
        visited = new boolean[n];
        int max = 0;
       
        for(int i = 0; i < n; i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            p[i] = in.nextInt();

            visited[i] = false; 
        }

        for(int i = 0; i < n; i ++)
        {
            
            visited = new boolean[n];

            max = Math.max(max,dfs(i));
        }
        
        PrintWriter pw = new PrintWriter("moocast.out");
        //System.out.println(max);
		pw.println(max);
		pw.close();


       

        
    }
    public static int dfs(int c)
    {   
        int r = 1; 
        visited[c] = true;
        
        for(int i = 0; i < visited.length; i++)
        {
            if(visited[i] == false && isAdj(c,i))
            {
                visited[i] = true;
                r += dfs(i);
            }
        }
       return r;
        
    }

    public static boolean isAdj(int a, int b)
    {
        return (((x[a] - x[b]) * (x[a] - x[b]) + (y[a] - y[b]) * (y[a] - y[b])) <= p[a] * p[a]);
    }
}