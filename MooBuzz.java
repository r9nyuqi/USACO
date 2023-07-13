import java.util.*;
import java.io.*;

public class MooBuzz {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("moobuzz.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int count = 1;
        int r = 1;
        while(count <= n)
        {
            count ++;
            if(count % 3 == 0 || count % 5 == 0)
            {
               n++;
            
            }
            
            
          
        }
        //System.out.println(n);

        PrintWriter pw = new PrintWriter(new File("moobuzz.out"));
		pw.print(n);
		pw.close();
    }
}