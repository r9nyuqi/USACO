import java.io.*;
import java.util.*;

public class visits {
	
	static int N, M;
	static int[] hlabels = new int[100000];
	static int[] glabels = new int[100000];
	static char[] cows;
	
	static ArrayList<Integer>[] adj_list = new ArrayList[100000];

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("milkvisits.in"));
		PrintWriter pw= new PrintWriter(new File("milkvisits.out"));
		
		
		
		N = in.nextInt();
		M = in.nextInt();
		
		cows = in.next().toCharArray();
		
		for (int i = 0; i < N; i++) adj_list[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < N - 1; i++) {
			
			int a = in.nextInt();
            int b = in.nextInt();
			a--; b--;
			adj_list[a].add(b);
			adj_list[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			if (hlabels[i] > 0) continue;
			dfs(i, hlabels, 'H', i + 1);
			if (glabels[i] > 0) continue;
			dfs(i, glabels, 'G', i + 1);
		}
		
		for (int i = 0; i < M; i++) {
			
			int a = in.nextInt();
            int b = in.nextInt();
			a--;
            b--;
			char c = in.next().charAt(0);
			if (((cows[a] == 'H' || cows[b] == 'H') && c == 'H') || (glabels[a] != glabels[b] && c == 'H')) {
				pw.print("1");
			} else if (((cows[a] == 'G' || cows[b] == 'G') && c == 'G') || (hlabels[a] != hlabels[b] && c == 'G')) {
				pw.print("1");
			} else {
				pw.print("0");
			}
		}
		pw.print("\n");
		pw.close();
	}
	
	public static void dfs(int i, int[] label_arr, char type, int label) {
		if (cows[i] != type || label_arr[i] > 0) return;
		label_arr[i] = label;
		for (int x : adj_list[i]) {
			dfs(x, label_arr, type, label);
		}
	}

}