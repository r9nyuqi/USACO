import java.util.*;
import java.io.*;

public class Mooloo {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
        long k = in.nextLong();
        long money = k+1;
        long[] days = new long[(int) n];
        for(int i = 0; i < n; i ++)
        {
            days[i] = in.nextLong();
        }
        Arrays.sort(days);
        for(int i = 1; i < n; i++)
        {
           money += Math.min(k+1, days[i] - days[i-1]);
        }
        System.out.println(money);


    }
}
