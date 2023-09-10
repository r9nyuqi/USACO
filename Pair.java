import java.util.*;
import java.io.*;

public class Pair {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("pairup.in"));
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < n; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            for(int j = 0; j < a; j++)
            {
                arr.add(b);
            }
        }
        Collections.sort(arr);

        int left = 0;
        int right = arr.size()-1;

        int max = 0;
        for(int i = 0; i < arr.size()/2; i++)
        {
            max = Math.max(max,arr.get(left) + arr.get(right));
        }

        PrintWriter pw = new PrintWriter(new File("pairup.out"));
        pw.println(max);
        pw.close();
        System.out.println(max);
    }
}
