import java.util.*;
import java.io.*;

public class clocktree2 {
    static ArrayList<Integer>[] adj;
    static int[] values;
    static ArrayList<Integer> a;
    static ArrayList<Integer> b;
    static boolean[] visited;
    static boolean[] color;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("clocktree.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        values = new int[n];
        a = new ArrayList<>();
        b = new ArrayList<>();
        visited = new boolean[n];
        adj = new ArrayList[n];
        color = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            adj[i] = new ArrayList();
            values[i] = in.nextInt();

        }
        for(int i = 0; i < n-1; i ++)
        {
            int a = in.nextInt() -1;
            int b = in.nextInt() -1;
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(0);

        int aSum = 0;
        int bSum = 0;
        for(int i : a)
        {
            aSum += i;
        }

        for(int i : b)
        {
            bSum += i;
        }

        
        aSum %=12;
        
        bSum %=12;
        if(aSum == 0)
        {
            aSum = 12;
        }
         if(bSum == 0)
        {
            bSum = 12;
        }
        PrintWriter pw = new PrintWriter(new File("clocktree.out"));
        if(aSum - bSum == 1)
        {
            pw.println(a.size());
            //System.out.println(a.size());
        }
        else if (bSum - aSum == 1)
        {
            pw.println(b.size());
            //System.out.println(b.size());
        }
        else if(aSum == bSum)
        {
            pw.println(n);
            //System.out.println(n);
        }
        
        else
        {
            pw.println(0);
            //System.out.println("0");
        }
        pw.close();



    }


    public static void dfs(int i)
    { 
       
        boolean first = true;
        visited[i] = true;
        for(int j : adj[i])
        {
            if(visited[j] == true)
            {
                first = false;
            }

            
        }
        if(first)
        {
            a.add(values[i]);
            color[i] = true;
        }
        else{
            for(int j : adj[i])
            {
                if(visited[j] && color[j])
                {
                    b.add(values[i]);
                    color[i] = false;

                }
                else if(visited[j] && !color[j])
                {
                    a.add(values[i]);
                    color[i] = true;

                }
            }

        }
        for(int j : adj[i])
        {
            if(!visited[j])
            {
                dfs(j);
            }
        }

        
        
        

    }
}