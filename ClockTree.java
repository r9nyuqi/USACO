import java.util.*;
import java.io.*;

public class ClockTree {
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static int[] values1;
    static int[] values;
    static int count = 0;
    static int[] parent;
    static ArrayList<Integer>[] child;
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("clocktree.in"));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        values1 = new int[n];
        values = new int[n];
        visited = new boolean[n];
        adj = new ArrayList[n];
        child = new ArrayList[n];
        parent = new int[n];
        for(int i = 0; i < n; i++)
        {
            values1[i] = in.nextInt();
            visited[i] = false;
            adj[i] = new ArrayList();
            child[i] = new ArrayList();
        }
        for(int i = 0; i < n-1; i ++)
        {
            int a = in.nextInt() -1;
            int b = in.nextInt() -1;
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 0; i < n; i++)
        {
            boolean bool = true;
           for(int j = 0; j < n; j ++)
           {
                values[j] = values1[j];
           }
           buildTree(i);
           dfs(i);
           for(int j = 0; j < n; j ++)
           {
                if(values[j] != 12)
                {
                    if(!(values[i] == 12 || values[i] == 1))
                    {
                        bool = false;
                    }
                }
           }
           if(bool)
           {
            count ++;
           }
        

        }
        System.out.println(count);




    }
    public static void buildTree(int n)
    {
        visited[n] = true;
        for(int i : adj[n])
        {
            if(visited[i])
            {
                parent[n] = i;
            }
            else
            {
                child[n].add(i);
                buildTree(i);
            }
        }

    }
    
    public static void dfs(int n)
    {
        for(int i : child[n])
        {
            dfs(i);
        }
        values[parent[n]] += (12-values[n]);



    }

    
}
