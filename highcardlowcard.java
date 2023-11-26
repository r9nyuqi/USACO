import java.util.*;
import java.io.*;
public class highcardlowcard {
	public static void main(String args[]) throws IOException{
		
		Scanner in = new Scanner(new File("cardgame.in"));
		PrintWriter pw = new PrintWriter(new File("cardgame.out"));

		int n = in.nextInt();
		Set<Integer> e = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		int[] elsieGreater = new int[n/2];
		int[] elsieLess = new int[n/2];
		int num;
		
		for(int x = 0; x < n; x++) 
        {
			num = in.nextInt();
			if(x < n/2) 
            {
				elsieGreater[x] = num;
			}
			else 
            {
				System.out.println(x);
				elsieLess[n/2-(n-x)] = num;
			}
			e.add(num);
		}
		
		for(int x = 1; x <= 2*n; x++) 
        {
			b.add(x);
		}
		
	
		Arrays.sort(elsieGreater);
		Arrays.sort(elsieLess);

		
		
		b.removeAll(e);

		int[] bessie = new int[n];
		int index = 0;

		for(int x : b) 
        {
			bessie[index] = x;
			index ++;
		}

		
		
		int ans = 0;
		int elsieCard;
		int bessieCard;
		index = n-1;
		for(int x = n/2-1; x >= 0; x--) 
        {
			elsieCard = elsieGreater[x];
			bessieCard = bessie[index];
			if(bessieCard < elsieCard) 
            {
				continue;
			}
			else 
            {
				index --;
				ans ++;
			}
		}
		
		
		index = 0;
		for(int x = 0; x <= n/2 -1; x++) 
        {
			elsieCard = elsieLess[x];
			bessieCard = bessie[index];
			if(bessieCard > elsieCard) 
            {
				continue;
			}
			else 
            {
				index ++;
				ans ++;
			}
		}
		pw.print(ans);
		pw.close();
	}
}
