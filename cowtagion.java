
import java.io.IOException;

import java.util.Scanner;
public class cowtagion {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] neighbors = new int[n];
        for (int i= 0 ;i < n-1;i++)
        {
            
            int a  = in.nextInt();
            int b = in.nextInt();
            neighbors[a-1] += 1;
            neighbors[b-1] += 1;
        }
        int ans = 0;
        for (int i= 0; i < n;i++)
        {
            int temp = 0;
            if (i != 0) temp = neighbors[i] - 1;
            else temp = neighbors[i];
            int days = 0;
            int val = 1;
            while (val <= temp)
            {
                days += 1;
                val *= 2;
            }
            ans += days;
            ans += temp;
        }
        System.out.println(ans);
    }
}