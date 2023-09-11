import java.util.*;
import java.io.*;

public class drive {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("speeding.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int m = in.nextInt();
        int[] limitDist = new int[n];
        int[] limitSpeed = new int[n];
        int[] bessieTravel = new int[m];
        int[] bessieSpeed = new int[m];
        for(int i = 0; i < n; i++)
        {
            limitDist[i] = in.nextInt();
            limitSpeed[i] = in.nextInt();
        }
        for(int i = 0; i < m; i++)
        {
            bessieTravel[i] = in.nextInt();
            bessieSpeed[i] = in.nextInt();
        }

        int[] bessie = new int[100];
        int[] limit = new int[100];

        for(int i = 0; i < limitDist[0]; i++)
        {
            limit[i] = limitSpeed[0];
        }
        int total = 0;
        for(int i = 1; i < n; i++)
        {
            total += limitDist[i-1];
            for(int j = total; j < total +limitDist[i]; j++)
            {
                limit[j] = limitSpeed[i];
            }
        }

        total = 0;
        for(int i = 0; i < bessieTravel[0]; i++)
        {
            bessie[i] = bessieSpeed[0];
        }
        for(int i = 1; i < m; i++)
        {
            total += bessieTravel[i-1];
            for(int j = total; j < total + bessieTravel[i]; j++)
            {
                bessie[j] = bessieSpeed[i];
            }
        }
        
        
        
        int max = 0;
        for(int i = 0; i < 100; i++)
        {
            max = Math.max(max,bessie[i]-limit[i]);
        }


        PrintWriter pw = new PrintWriter(new File("speeding.out"));
        pw.println(max);
        pw.close();
        System.out.println(max);
    }
}
