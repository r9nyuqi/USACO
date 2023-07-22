import java.util.*;
import java.io.*;

public class clocktree2_z {
    static ArrayList<Integer>[] adj;
    static int[] values;
    static ArrayList<Integer> a;
    static ArrayList<Integer> b;
    static boolean[] visited;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("clocktree.in"));
        // Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        values = new int[n];
        a = new ArrayList<>();
        b = new ArrayList<>();
        visited = new boolean[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
            values[i] = in.nextInt();

        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(0, true, -1);

        int aSum = 0;
        int bSum = 0;
        for (int i : a) {
            aSum += i;
        }

        for (int i : b) {
            bSum += i;
        }

        PrintWriter pw = new PrintWriter(new File("clocktree.out"));
        if ((aSum % 12) - ((bSum + 1) % 12) == 0) {
            pw.println(a.size());
            // System.out.println(a.size());
        } else if ((bSum % 12) - ((aSum + 1) % 12) == 0) {
            pw.println(b.size());
            // System.out.println(b.size());
        } else if (aSum % 12 == bSum % 12) {
            pw.println(n);
            // System.out.println(n);
        } else {
            pw.println(0);
            // System.out.println("0");
        }
        pw.close();

    }

    public static void dfs(int i, boolean color, int prev) {
        if (visited[i] == false) {
            if (color) {
                a.add(values[i]);
            } else {
                b.add(values[i]);
            }
        }
        visited[i] = true;
        for (int j : adj[i]) {
            // For adj: 1 -> 2, 2 -> 1, 3, 4
            // When we visit 2's adj, we don't visit 1. Otherwise it's infinite loop.
            if (j != prev) {
                dfs(j, !color, i);
            }
        }
    }
}