import java.io.*;
import java.util.*;
public class seven {
	static long[]prefix;
	static int[]mod;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("div7.in"));
		PrintWriter pw = new PrintWriter (new FileWriter("div7.out"));
		int n = in.nextInt();
		prefix = new long[n+1]; 
        mod = new int[n+1];
		for(int i=1; i<=n; i++) 
        {
			long sum = prefix[i-1]+(long) in.nextInt();
			prefix[i] = sum; mod[i] = (int)(sum%7);
		}

		int ans = 0; 
		for(int i=0; i<7; i++)
        {
			int start=0; int end=0; boolean first = true;
			for(int j=1; j<=n; j++) 
            {
				if(mod[j] == i && first) 
                {
					start = j;
					first= false;
				}else if(mod[j] == i)
                {
					end = j;
				}
			}
			if(end == 0) 
            {
				end = start+1;
			}
			ans = Math.max(ans, end-start);
		}
		pw.println(ans);
		pw.close();
		
	}
}
