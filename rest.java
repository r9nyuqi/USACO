import java.io.*;

public class rest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));

		String[] line = br.readLine().split(" ");
		int trailLen = Integer.parseInt(line[0]);  
		int stopNum = Integer.parseInt(line[1]);
		int fRate = Integer.parseInt(line[2]);
		int bRate = Integer.parseInt(line[3]);

		int[] x = new int[stopNum];  
		int[] c = new int[stopNum];  

		for (int i = 0; i < stopNum; i++) {
			line = br.readLine().split(" ");
			x[i] = Integer.parseInt(line[0]);
			c[i] = Integer.parseInt(line[1]);
		}
		br.close();

		
		boolean[] good = new boolean[stopNum];
		int maxTastiness = 0;
		for (int i = stopNum - 1; i >= 0; i--) {
			if (c[i] > maxTastiness) {
				
				good[i] = true;
				maxTastiness = c[i];
			}
		}

		
		int prevStopPos = 0;
		long ans = 0;
		for (int i = 0; i < stopNum; i++) {
			if (good[i]) {
				long travelDist = x[i] - prevStopPos;
				long fTime = travelDist * fRate;
				long bTime = travelDist * bRate;
				long restTime = fTime - bTime;
				ans += restTime * c[i];
				prevStopPos = x[i];
			}
		}

		PrintWriter pw = new PrintWriter("reststops.out");
		pw.println(ans);
		pw.close();
	}
}