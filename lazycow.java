
import java.util.*;
import java.io.*;

public class lazycow {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("lazy.in"));
		
		PrintWriter pw = new PrintWriter(new File("lazy.out"));
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int [][] field = new int[n][n];
		for (int i = 0; i < n; i++) 
        {
			for (int j = 0; j < n; j++)  
                field[i][j] = in.nextInt(); 
		}
		
		int[][] rotated = new int[2*n][2*n];
		for(int i = 0; i < n; i++) 
        {
			for(int j = 0; j < n; j++) 
                rotated[i + j][n - i + j - 1] = field[i][j];
		}
		
		
		int[][] prefix = new int[2*n + 1][2*n + 1];
		for(int i = 0; i < 2*n; i++) 
        {
			for(int j = 0; j < 2*n; j++) 
            {
				prefix[i + 1][j + 1] = rotated[i][j] + prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j];

			}

		}
		
		int ans = 0;
		for(int i = k; i < 2*n - k; i++) 
        {
			for(int j = k; j < 2*n - k; j++) 
            {
				int sum = prefix[i + k + 1][j + k + 1] - prefix[i + k + 1][j - k] -
			            prefix[i - k][j + k + 1] + prefix[i - k][j - k];
				ans = Math.max(sum, ans);
			}
		}
		
		if(k >= n) 
            ans = prefix[2*n][2*n];
		
		pw.println(ans);
		pw.close();
		in.close();
	}

}