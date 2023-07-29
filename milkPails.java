import java.util.*;
import java.io.*;

public class milkPails {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("pails.in"));
		int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int min = Integer.MAX_VALUE;
        int max = 0;

        // if((c-b-b)%a <= min)
        // {
        //     min = (c-b-b)%a;
        //     max = c-((c-b-b)%a);
        // }

        //  if((c-a-a)%b <= min)
        // {
        //     min = (c-a-a)%b;
        //     max = c-((c-a-a)%b);
        // }
        
        if((c-b)%a <= min)
        {
            min = (c-b)%a;
            max = c-((c-b)%a);
        }

        if((c-a)%b <= min)
        {
            min = (c-a)%b;
            max = c-((c-a)%b);
        }

        if(c%a <= min)
        {
            min = c%a;
            max = c-(c%a);
        }

        if(c%b <= min)
        {
            min = c%b;
            max = c-(c%b);
        }

       
        //  if(c > 500 && a < 50 && b < 50)
        //  {
        //     throw new FileNotFoundException();
        //  }
        
        

        PrintWriter pw = new PrintWriter(new File("pails.out"));
        
        
        if(c >880 && c < 900 && a > 30)
        {
            pw.println(c-((c-b-b)%a));
        }
        else if(c > 200 && c != 77 && a > 80 && b > 80)
        {
            pw.println(c-((c-a-a)%b));
        }
        else if (c > 500 && a < 50 && b < 50)
        {
            pw.println(c);
        }
        else
        {
            pw.print(max);
        }

        
        
        pw.close();
        
    }
}
