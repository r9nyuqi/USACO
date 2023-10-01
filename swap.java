import java.util.*;
import java.io.*;

public class swap {
	public static void main(String[] args) throws FileNotFoundException{
	
		Scanner in = new Scanner(new File("swap.in"));
	
		
		int n = in.nextInt(); 
        int k = in.nextInt();
		int a = in.nextInt() - 1; 
        int b = in.nextInt() - 1;
		int c = in.nextInt() - 1; 
        int d = in.nextInt() - 1;
		
		
		int size = 0;
	    int[] order = new int[n];
	    for(int i = 0; i < n; i++) 
        {
            order[i] = i + 1;
        }
	    boolean sorted = true;
	   	PrintWriter pw = new PrintWriter("swap.out");
	    
        do 
        {
	      size++;
	      reverseList(order, a, b);
	      reverseList(order, c, d);
	      sorted = true;
	      for(int i = 0; sorted && i < n; i++) sorted = order[i] == i + 1;
	    }

	    while(sorted != true);
	    {
            k %= size;
        }

	    for(int i = 0; i < n; i++) 
        {
            order[i] = i + 1;
        }
        
	    for(int i = 0; i < k; i++) 
        {
	      reverseList(order, a, b);
	      reverseList(order, c, d);      
	    }
	    for(int i = 0; i < n; i++) 
        {
            pw.println(order[i]);
        }
	    pw.close();
	    
	}
	
	private static void reverseList(int[] order, int a, int b) {
	    
        while(a < b) 
        {
	      int x = order[a];
	      order[a] = order[b];
	      order[b] = x;
	      a++;
	      b--;
	    }
	}
}
