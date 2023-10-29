import java.io.*;
import java.util.*;

public class pareidola{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int n = t.length();
        int[] bessieCounts = new int[n + 1];
        
        // Precompute the number of "bessies" in all substrings of t
        for (int i = 0; i < n; i++) {
            if (i >= 5) {
                bessieCounts[i + 1] = bessieCounts[i] - (t.substring(i - 5, i).equals("bessie") ? 1 : 0);
            }
            bessieCounts[i + 1] += bessieCounts[i];
            bessieCounts[i + 1] += (t.charAt(i) == 'b' ? 1 : 0);
        }
        
        int u = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append(bessieCounts[n]).append("\n");
        
        for (int i = 0; i < u; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            char c = st.nextToken().charAt(0);
            
            if (t.charAt(p) == 'b' && c != 'b') {
                bessieCounts[n]--;
            } else if (t.charAt(p) != 'b' && c == 'b') {
                bessieCounts[n]++;
            }
            
            t = t.substring(0, p) + c + t.substring(p + 1);
            sb.append(bessieCounts[n]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
