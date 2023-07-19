import java.io.*;
import java.util.*;

public class MilkVisits {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader("milkvisits.in"));

		StringTokenizer initial = new StringTokenizer(read.readLine());
		int farmNum = Integer.parseInt(initial.nextToken());
		int queryNum = Integer.parseInt(initial.nextToken());

		String farms = read.readLine();

		List<Integer>[] neighbors = new ArrayList[farmNum];
		for (int f = 0; f < farmNum; f++) { neighbors[f] = new ArrayList<>(); }
		for (int f = 0; f < farmNum - 1; f++) {
			StringTokenizer road = new StringTokenizer(read.readLine());
			int f1 = Integer.parseInt(road.nextToken()) - 1;
			int f2 = Integer.parseInt(road.nextToken()) - 1;
			neighbors[f1].add(f2);
			neighbors[f2].add(f1);
		}

		
		int componentNum = 0;
		int[] component = new int[farmNum];
		Arrays.fill(component, -1);
		for (int f = 0; f < farmNum; f++) {
			
			if (component[f] != -1) { continue; }
			ArrayDeque<Integer> frontier = new ArrayDeque<>();
			frontier.add(f);
			char type = farms.charAt(f);
			while (!frontier.isEmpty()) {
				int curr = frontier.poll();
				
				component[curr] = componentNum;
				for (int n : neighbors[curr]) {
					
					if (farms.charAt(n) == type && component[n] == -1) {
						frontier.add(n);
					}
				}
			}
			componentNum++;
		}

		PrintWriter pw = new PrintWriter("milkvisits.out");
		for (int q = 0; q < queryNum; q++) {
			StringTokenizer query = new StringTokenizer(read.readLine());
			int a = Integer.parseInt(query.nextToken()) - 1;
			int b = Integer.parseInt(query.nextToken()) - 1;
			char milk = query.nextToken().charAt(0);

			if (component[a] == component[b]) {
				pw.print(farms.charAt(a) == milk ? 1 : 0);
			} else {
			
				pw.print(1);
			}
		}
		pw.close();
	}
}