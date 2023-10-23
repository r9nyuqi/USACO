
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class sleepcowherd {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("herding.in"));
		PrintWriter out = new PrintWriter((new FileWriter("herding.out")));
		
		int n = in.nextInt();
		int[] cows = new int[n];
		
		for (int i = 0; i < n; i++) 
        {
			cows[i] = in.nextInt();
		}
		Arrays.sort(cows);
		
		int max = 0;
		for (int i = 0; i < n; i++) 
        {
			int count = 0;
			for (int j = i; j < n; j++) 
            {
				if (cows[j] >= cows[i] + n) 
                {
					break;
				}
				count++;
			}
			max = Math.max(max, count);
		}
		if (cows[n-2] - cows[0] == n-2 && cows[n-1]-cows[n-2] > 2) 
            max = n - 2;
		if (cows[n-1] - cows[1] == n-2 && cows[1]-cows[0] > 2) 
            max = n - 2;
		
		out.println(n - max);
		out.println(Math.max(cows[n-1] - cows[1], cows[n-2] - cows[0]) - (n-2));
		
		in.close();
		out.close();
	}

}
