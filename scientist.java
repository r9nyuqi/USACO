import java.util.*;
import java.io.*;

public class scientist {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("breedflip.in"));
        //Scanner in = new Scanner(System.in);
        int n =  in.nextInt();
        String s1 = in.next();
        String s2 = in.next();
        int count = 0;
        int start = 0;
        int end = 1;
        while(!s2.equals(s1))
        {
            count ++;

            while(s2.substring(start,end).equals(s1.substring(start,end)))
            {
                start++;
                end ++;
            }
            
            while(!s2.substring(start,end).equals(s1.substring(start,end)))
            {
                s2 = s1.substring(0,end) + s2.substring(end);
                start++;
                end++;
               
            }
            
        }
        //System.out.println(count);
        PrintWriter pw = new PrintWriter(new File("breedflip.out"));
		pw.print(count);
		pw.close();
	}
}
		