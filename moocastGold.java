import java.util.*;
import java.io.*;

public class moocastGold {
    static int[] x;
    static int[] y; 
    static boolean[] visited;
    static int mid;
    public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("moocast.in"));
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        x = new int[n];
        y = new int[n]; 
        visited = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        int min = 0; 
        int max = 100000;
        while(min < max)
        {
            visited = new boolean[n];
            mid = (min + max)/2;
            dfs(0);
            boolean work = true;
            for(int i = 0; i < visited.length; i++)
            {
                if(visited[i] == false)
                {
                    work = false;
                }
            }
            if(work)
            {
                max = mid;
            }
            else
            {
                min = mid + 1;
            }
        }
        System.out.println(min);
        PrintWriter pw = new PrintWriter(new File("moocast.out"));
		pw.print(min);
		pw.close();
        
        
    }
    public static void dfs(int i)
    {
        visited[i] = true;
        for(int y = 0; y < x.length; y++)
        {
            if(visited[y] == false && isAdj(i,y))
            {
                dfs(y);
            }

        }


    }

     public static boolean isAdj(int a, int b)
    {
        return (((x[a] - x[b]) * (x[a] - x[b]) + (y[a] - y[b]) * (y[a] - y[b])) <= mid);
    }
}