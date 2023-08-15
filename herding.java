import java.util.*;
import java.io.*;

public class herding{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("herding.in"));
		int[] arr = new int[3];
        for(int i = 0; i < 3; i ++)
        {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int a = arr[2] - arr[1];
        int b = arr[1] - arr[0];
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        PrintWriter pw = new PrintWriter(new File("herding.out"));
        pw.println(min-1);
        pw.println(max-1);
        pw.close();
       
    }
}
