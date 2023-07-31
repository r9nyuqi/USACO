import java.util.*;
import java.io.*;

public class hungry {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int d = in.nextInt();
        int count = 0;
        for(int i = 0; i < n; i ++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            if(count < d)
            {
                
                if(b >= d-a)
                {
                    if(count + d-a <= d)
                    count += d-a;
                    else
                    count = d;
                }
                else
                {
                    if(count + b <= d)
                    count += b;
                    else
                    count = d;
                    
                }

                if(a == d)
                {
                    count ++; 
                }
            }
        }
        
        System.out.println(count);
    }
}
