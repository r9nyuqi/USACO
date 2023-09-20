import java.util.*;
import java.io.*;

public class CowCrossRoad {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("cowqueue.in"));
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arrive = new int[n];
		int[] duration = new int[n];
		int previous = Integer.MAX_VALUE;
		int next = 0;
		int end = 0;
		for(int i = 0; i < n; i++)
		{
			arrive[i] = in.nextInt();
			duration[i] = in.nextInt();
			previous = Math.min(previous,arrive[i]);
			next = previous;
		}

		for(int i = 0; i < n; i++)
		{
			if(arrive[i] == next)
			{
				end = arrive[i] + duration[i];
				previous = arrive[i];
			}
		}
		
		int nextIndex = 0;
		for(int i = 1; i < n; i++)
		{
			next = Integer.MAX_VALUE;
			for(int j = 0; j < n; j ++)
			{
				if(arrive[j] > previous)
				{
					int temp = next;
					next = Math.min(arrive[j],next);
					if(next != temp)
					{
						nextIndex = j;
					}
				}
			}
			if(arrive[nextIndex] < end)
			{
				end += duration[nextIndex];
			}
			else
			{
				end = arrive[nextIndex] + duration[nextIndex];
			}

			previous = next;
		}

		PrintWriter pw = new PrintWriter(new File("cowqueue.out"));
		pw.println(end);
		pw.close();
		System.out.println(end);
	}
}
