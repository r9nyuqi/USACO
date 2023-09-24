import java.util.*;
import java.io.*;
public class Taming {
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(new FileReader("taming.in"));
		
		
		int cows = in.nextInt();
		int[] out = new int[cows];
		for(int i = 0; i < cows; i++) 
		{
			out[i] = in.nextInt();
		}
		out[0] = 0;
		int count = 0;
		PrintWriter pw = new PrintWriter((new FileWriter("taming.out")));
		for(int i = 0; i < cows; i ++) 
		{
			if(out[i] > 0) 
			{
				count = 0;
				for(int j = i - out[i]; j < i; j++) 
				{
					if(out[j] != count && out[j] > 0) 
					{
						pw.print(-1);
						pw.close();
					}
					out[j] = count;
					count ++;
				}
			}
		}
		
		int breakout = 0;
		int unknown = 0;

		for(int i : out) {
			if(i == 0) {
				breakout ++;
			}
			
			else if(i == -1) {
				unknown ++;
			}
		}
		pw.print(breakout + " " + (breakout + unknown));
		pw.close();
	}
}