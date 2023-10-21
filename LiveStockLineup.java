import java.io.*;
import java.util.*;

public class LiveStockLineup {

    public static ArrayList<Integer>[] children;
    public static ArrayList<ArrayList<Integer>> groups;
    public static boolean[] available;

    public static void main(String[] args) throws IOException {
      
       Scanner in = new Scanner(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter("lineup.out");

        String[] c = new String[] {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
        available = new boolean[8];
        for(int i = 0; i < 8; i++)
        {
            available[i] = true;
        }

        int n = in.nextInt();

        children = new ArrayList[8];

        for(int i = 0; i < 8; i++) 
        {
            children[i] = new ArrayList<>();
        }

       
        for(int i = 0; i < n; i++) 
        {
            String s = in.nextLine();
            int a = 0;
            int b = 0;

            
            for(int j = 0; j < 8; j++) 
            {
                int index = s.indexOf(c[j]);
                if(index == -1) 
                {
                    continue;
                }
                if(index == 0)
                {
                    a = j;
                } 
                else 
                {
                    b = j;
                }
            }

            children[a].add(b);
            children[b].add(a);
        }

        
        for(ArrayList<Integer> i : children) 
        {
            Collections.sort(i);
        }

       
        groups = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < 8; i++) 
        {
            groups.add(new ArrayList<Integer>());

            if(available[i] && children[i].size() < 2) 
            {
                dfs(i, -1, groups.get(i));
            }
        }

        
        for(ArrayList<Integer> b : groups) 
        {
            for(Integer a : b) 
            {
                pw.println(c[a]);
            }
        }

        in.close();
        pw.close();
    }

     public static void dfs(int a, int b, ArrayList<Integer> arr) {
        available[a] = false;
        for(Integer ch : children[a]) {
            if(ch != b) {
                dfs(ch, a, arr);
            }
        }
        arr.add(0, a);
    }
}