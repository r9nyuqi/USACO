import java.util.*;
import java.io.*;

public class Mooloo {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int k = in.nextInt();
        int money = 0;
        int[] days = new int[n];
        for(int i = 0; i < n; i ++)
        {
            days[i] = in.nextInt();
        }
        Arrays.sort(days);
        for(int i = 1; i < n; i++)
        {
            money += k;
            if(i<n);
            {
                while(days[i] - days[i-1] <= (k+1)*2)
                {
                    if(i<n-1)
                    {
                        money ++;
                        i++;
                    }
                    
                }
                if(days[i] - days[i-1] > (k+1)*2)
                {
                    money ++;
                    money += k+1;
                }

            }
            
        }
        System.out.println(money);


    }
}
