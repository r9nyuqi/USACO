import java.io.*;
import java.util.*;

class Race {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("race.in"));
		int k = sc.nextInt();
		int n = sc.nextInt();

		PrintWriter pw = new PrintWriter(new File("race.out"));
		for (int q = 0; q < n; q++) {
			int maxSpeed = sc.nextInt();
			pw.println(fastestTime(k, maxSpeed));
		}
		pw.close();
	}

	static int fastestTime(int dist, int maxSpeed) {
		int sUp = 0; 
		int sDown = 0;  
		int time = 0;

	
		for (int currS = 1;; currS++) {
			sUp += currS;
			time++;
			if (sUp + sDown >= dist) 
            { 
                return time; 
            }

			if (currS >= maxSpeed) {
				sDown += currS;
				time++;
				
				if (sUp + sDown >= dist) { return time; }
			}
		}
	}
}