import java.util.*;
import java.io.*;

public class lostCow {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("lostcow.in"));
        //Scanner in = new Scanner(System.in);
		int a = in.nextInt();
        int b = in.nextInt();
        int x = (Math.min(a,b));
        int y = (Math.max(a,b));
        int cur = x;
        int count = 1;
        int dist = 1;
        int total = 0;
        while (cur < y)
        {
            int pre = cur;
            if(count % 2 == 0)
            {
                cur = x- dist ;
            }
            else
            {
                cur = x+  dist;
            }

            total += Math.abs(cur-pre);
            dist *= 2;
            count ++;
        }
        if(cur > y)
        {
            total -= Math.abs(cur-y);
        }

        PrintWriter pw = new PrintWriter(new File("lostcow.out"));
        pw.println(total);
        pw.close();
        System.out.println(total);
    }
}
