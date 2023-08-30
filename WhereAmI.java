import java.util.*;
import java.io.*;

public class WhereAmI {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("whereami.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        String str = in.next();
        
        PrintWriter pw = new PrintWriter(new File("whereami.out"));
       
		for (int u = 1; u <= n; u++) {
			boolean good = true;
			
			for (int i = 0; i + u <= n; i++) {
				for (int j = 0; j < i; j++) {
					String substring1 = str.substring(i, i + u);
					String substring2 = str.substring(j, j + u);
					if (substring1.equals(substring2))
                    { 
                        good = false; 
                    }
				}
			}
			if(good) 
            {
				pw.println(u);
                //System.out.println(u);
				break;
			}
		}
		pw.close();
    
}
}