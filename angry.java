import java.util.*;
import java.io.*;
public class angry  {
    public static void main (String [] args) throws IOException {
        Scanner in = new Scanner(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("angry.out"));
        
        int n = in.nextInt(); 
        int[] num = new int[n];
        for(int i = 0; i < n; i ++)
        {
            num[i] = in.nextInt();
        }
        int ret = 1;
        Arrays.sort(num);
        for(int i = 0; i < n; i ++)
        {
            int h = i+1;
            int l = i-1;
            int t = 1;
            int curr = 1;
            boolean left = true;
            boolean right = true;

            while(left || right)
            {
                int count = 0;
                while(right && h < n && num[h] - num[h-1-count] <= t)
                {
                    h++; curr++; count ++;
                }
                if(count == 0){right = false;}
                count = 0;
                while(left && l >= 0 && num[l+1+count] - num[l] <= t)
                {
                    l--; curr++; count ++;
                }
                if(count == 0){left = false;}
                t ++;
            }

            ret = Math.max(curr, ret);
           
        }
    
        pw.println(ret);
        pw.close();
    }
}
