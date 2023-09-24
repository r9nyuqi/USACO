import java.io.*;
import java.util.*;

public class mootube {
	
	static ArrayList<ArrayList<int[]>> pairs = new ArrayList<ArrayList<int[]>>();
		
	static boolean[] used;
		
	static int DFS(int k, int current, int minRelevance) {
		
        used[current] = true;
		int count = 0;
		
		for(int[] i: pairs.get(current)) {

			if (!used[i[0]]) {
				int m = Math.min(minRelevance, i[1]);
				
                if (m >= k) {
					count++;
				}
				count += DFS(k, i[0], m);
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("mootube.in"));
        PrintWriter pw = new PrintWriter(new File("mootube.out"));
        
       
        int N = in.nextInt();
        int Q = in.nextInt();
        
        for(int i = 0; i < N; i++) {
        	pairs.add(new ArrayList<int[]>());
        }
        
        for(int i = 0; i < N - 1; i++) {
        	
        	int a = in.nextInt() - 1;
        	int b = in.nextInt() - 1;
        	int c = in.nextInt();
        	
        	pairs.get(a).add(new int[] {b,c});
        	pairs.get(b).add(new int[] {a,c});
        }
        
        used = new boolean[N];
         
        for(int i = 0; i < Q; i++) {
        	Arrays.fill(used, false);
        	
        	int k = in.nextInt();
        	int v = in.nextInt() - 1;
        	        	
        	
        	int count = DFS(k, v, Integer.MAX_VALUE);
        	
        	System.out.println(count);
        	pw.println(count);
        }
        
        in.close();
        pw.close();
	}

}