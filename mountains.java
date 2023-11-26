import java.io.*;
import java.util.*;

public class mountains {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("mountains.in"));
        PrintWriter pw = new PrintWriter(new File("mountais.out"));
        
        int n = in.nextInt();
        
        int[][] mountains = new int[n][2];
        
        for(int i = 0; i < n; i++) 
        {
        	
        	mountains[i][0] = in.nextInt();
        	mountains[i][1] = in.nextInt();
        }
        
        Arrays.sort(mountains,Comparator.comparingInt(a -> a[0]));
        
        for(int[] e: mountains) {
        	System.out.println(Arrays.toString(e));
        }
                
        int solution = 0;
        
        for(int i = 0; i < n; i++) 
        {
        	int iLeft = i - 1;
        	int iRight = i + 1;
        	boolean works = true;
        	
    		while(iLeft >= 0 && works) 
            {
    			if (mountains[iLeft][1] >= mountains[i][1]) 
                {
    				int a = mountains[i][0] - mountains[iLeft][0];
    				int b = mountains[iLeft][1] - mountains[i][1];
    				if (b >= a) {
    					works = false;
    				}
    			}
    			iLeft--;
    		} 
        	
    		while(iRight < n && works) 
            {
	    		if (mountains[iRight][1] >= mountains[i][1]) {	
    				int a = mountains[iRight][0] - mountains[i][0];
	    			int b = mountains[iRight][1] - mountains[i][1];
	    			if (b >= a) {
	    				works = false;
	    			}
	    		}
    			iRight++;
        	}
    		
    		if (works) solution++;
        }
        
        //System.out.println(solution);
        pw.println(solution);
        pw.close();
	}

}
