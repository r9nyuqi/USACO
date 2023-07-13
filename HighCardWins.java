import java.util.*;
import java.io.*;

public class HighCardWins {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("highcard.in"));
		int n = in.nextInt();
		List<Integer> elsie = new ArrayList<Integer>();
		List<Integer> bessie = new ArrayList<Integer>();
		boolean[] elsieOwned = new boolean[n * 2 + 1];

		for (int i = 0; i < n; i++) {
			elsieOwned[in.nextInt()] = true;	
		}

		for (int i = 1; i <= n * 2; i++) {
			if (elsieOwned[i] == true) {
				elsie.add(i);
			} else {
				bessie.add(i);
			}
		}
		
		int max = 0;
		
		int bessieIndex = 0;
		int elsieIndex = 0;
		while(bessieIndex < n && elsieIndex < n) {
			if(bessie.get(bessieIndex) > elsie.get(elsieIndex)) {
				max++;
				bessieIndex++;
				elsieIndex++;
			}
			else {
				bessieIndex++;
			}
		}
		PrintWriter pw = new PrintWriter(new File("highcard.out"));
		pw.print(max);
		pw.close();
	}
}
