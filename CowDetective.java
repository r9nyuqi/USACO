import java.util.*;
import java.io.*;

public class CowDetective {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        String[] direction = new String[n];
        int[] location = new int[n];

        for(int i = 0; i <n; i++)
        {
            direction[i] = in.next();
            location[i] = in.nextInt();

        }
        int count = 0;
        int upper = Integer.MAX_VALUE;
        int lower =0;
        for(int i =0 ; i <n; i++)
        {
            if(direction[i].equals("G"))
            {
                if(location[i] > upper)
                {
                    count ++;
                    break;
                }
                lower = location[i];
            }

            else if(direction[i].equals("L"))
            {
                if(location[i] < lower)
                {
                    count ++;
                    break;
                }
                upper = location[i];
            }
        }
        int min = Integer.MAX_VALUE;
        if(count != 0)
        {
            for(int i =0; i <n; i ++)
            {
                count = 1;
                if(direction[i].equals("G"))
                {
                    upper = location[i] -1;
                }
                else if(direction[i].equals("L"))
                {
                    lower = location[i] +1;
                }
                
                for(int j = 0; j <n; j++)
                {
                    if(location[j] > upper)
                    {
                        count ++;
                    
                    }
                    else{
                         lower = location[i];
                    }

                    if(location[i] < lower)
                    {
                        count ++;
                    
                    }
                    else
                    {
                        upper = location[i];

                    }
                    
               
                   
                }

                min = Math.min(min,count);
            }
        }
        System.out.println(count);
    }

}