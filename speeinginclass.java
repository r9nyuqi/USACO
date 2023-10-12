import java.util.*;
import java.io.*;
import java.lang.*;

public class speeinginclass {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0 ; i < t ; i ++)
        {
            int n = in.nextInt();
            int sum = 0;
            int [] arr = new int [n];
            
            for(int j = 0 ; j < n ; j ++)
            {
                arr[j] = in.nextInt();
                sum += arr[j];
            }

            
            if(sum == 0)
            {
                System.out.println(0);
                continue;
            }
            ArrayList <Integer> factors = new ArrayList <>();
            
            for(int j = 1 ; j <= Math.sqrt(sum) ; j ++)
            {
                if(sum % j == 0){
                    factors.add(j);
                    factors.add(sum / j);
                }
            }
            
            Collections.sort(factors);
            
            for(int j : factors)
            {
                int cur = 0;
                boolean satisfy = true;
                for(int x : arr)
                {
                    if(cur > j)
                    {
                        satisfy = false;
                        break;
                    
                    }else if(cur == j)
                    {
                        cur = x;
                   
                    }else
                    {
                        cur += x;
                    }
                }

                if(satisfy && cur == j)
                {
                    int total = sum / j;
                    System.out.println(n - total);
                    break;
                }
            }
        }
    }
    
}
