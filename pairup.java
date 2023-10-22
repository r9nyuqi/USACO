import java.io.*;
import java.util.*;

public class pairup{
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new FileReader("pairup.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("pairup.out"));
		
		int n = in.nextInt();
		int[][] cows = new int[n][2];
		
		for(int i = 0; i < n; i ++){
			
			cows[i][0] = in.nextInt();
			cows[i][1] = in.nextInt();
		}
		Arrays.sort(cows, (a, b) -> a[1] - b[1]); 
	
		long max = 0;
		for(int i = 0, j = n - 1; i <= Math.floor((n + 1) / 2);)
		{ 
			max = Math.max(max, cows[i][1] + cows[j][1]);
			if(cows[i][0] == cows[j][0])
			{ 
				i++;
				j--;
			}
			else if(cows[i][0] < cows[j][0])
			{
				cows[j][0] -= cows[i][0];
				i ++;
			}
			else
			{
				cows[i][0] -= cows[j][0];
				j --;
			}
		}
		pw.println(max);
		pw.close();
	}
}