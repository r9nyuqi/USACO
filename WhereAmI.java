import java.util.*;
import java.io.*;

public class WhereAmI {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("whereami.in"));
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        String str = in.next();
        int min = 0; 
        int max = 100;
        
        while(min < max)
        {
            int mid = (min+max)/2;
            boolean good = true;
			// try all substring combinations of that length
			    for (int i = 0; i + mid <= n; i++) {
				for (int j = 0; j < i; j++) {
					String substring1 = str.substring(i, i + mid);
					String substring2 = str.substring(j, j + mid);
					if (substring1.equals(substring2)) 
                    { 
                        good = false; 
                    }
        }
        if(good)
        {
            min = mid+1;
        }
        else{
            max = mid;
        }
    }
    }
    PrintWriter pw = new PrintWriter(new File("whereami.out"));
    pw.println(min);
    pw.close();
    System.out.println(min);
}
}