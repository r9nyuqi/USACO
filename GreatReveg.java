import java.util.*;
import java.io.*;

public class GreatReveg {

    static ArrayList<Integer>[] adj;
    static int value[];
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("revegetate.in"));
        //Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        adj = new ArrayList[n];
        value = new int[n];
        for(int i = 0; i < n; i++)
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

        int r = 0;
        
        PrintWriter pw = new PrintWriter(new File("revegetate.out"));
        for(int i = 0; i < n; i ++)
        {
            pw.print(grass(i));

        }
        pw.close();
    }

    public static int grass(int c)
    {
        boolean available[] = new boolean[5];
        Arrays.fill(available, true);
        Iterator<Integer> it = adj[c].iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (value[i] != 0) {
                available[value[i]] = false;
            }
        }

        int cr;
        for (cr = 1; cr <= 4; cr++) {
            if (available[cr])
                break;
        }
        value[c] = cr;
        return cr;
    }
}