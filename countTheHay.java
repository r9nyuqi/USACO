import java.util.*;
import java.io.*;

public class countTheHay{
    
    static int[] hay;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("haybales.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int q = in.nextInt();
        hay = new int[n];
        for(int i = 0; i < n; i ++)
        {
            hay[i] = in.nextInt();
        }
        Arrays.sort(hay);

        PrintWriter pw = new PrintWriter(new File("haybales.out"));
        for(int i = 0; i < q; i++)
        {

            int start = in.nextInt();
            int end = in.nextInt();
            int left = left(start);
            int right = right(end);
            pw.println(right-left);
            System.out.println(right-left);
        }

        pw.close();

    }

    public static int left(int num)
    {
        int low = 0;
        int high = hay.length;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(hay[mid] >= num)
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;

    }

     public static int right(int num)
    {
        int low = 0;
        int high = hay.length;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(hay[mid] > num)
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;

    }
}
