import java.util.*;
import java.io.*;

public class CowCross {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("crossroad.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int[] lastLoc = new int[10];
        for(int i = 0; i < 10; i++)
        {
            lastLoc[i] = -1;
        }
        int count = 0;
        for(int i = 0; i < n; i ++)
        {
            int cow = in.nextInt()-1;
            int loc = in.nextInt();
            if(lastLoc[cow] == -1)
            {
                lastLoc[cow] = loc;
            }
            else
            {
                if(lastLoc[cow] != loc)
                {
                    count ++;
                }
                lastLoc[cow] = loc;

            }
            
        }

        PrintWriter pw = new PrintWriter(new File("crossroad.out"));
        pw.println(count);
        pw.close();
        System.out.println(count);


    }
}
