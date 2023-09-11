// http://www.usaco.org/index.php?page=viewproblem2&cpid=738
import java.io.*;
import java.util.*;

public class pairedup_z {

    public static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.first, o.first);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));

        int N = Integer.parseInt(br.readLine());
        List<Pair> V = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            V.add(new Pair(y, x));
        }

        Collections.sort(V);

        int M = 0, i = 0, j = N - 1;
        while (i <= j) {
            int x = Math.min(V.get(i).second, V.get(j).second);
            if (i == j) {
                x /= 2;
            }
            M = Math.max(M, V.get(i).first + V.get(j).first);
            V.get(i).second -= x;
            V.get(j).second -= x;
            if (V.get(i).second == 0) {
                i++;
            }
            if (V.get(j).second == 0) {
                j--;
            }
        }

        pw.println(M);
        pw.close();
    }
}