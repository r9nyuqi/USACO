import java.util.*;
import java.io.*;

public class milkingorder {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] order = new int[m];
        int[] fin = new int[n];
        HashMap<Integer,Integer> place = new HashMap<Integer,Integer>();
        int[] key = new int[k];
        for(int i = 0; i < m; i++)
        {
            order[i] = in.nextInt();
        }
        for(int i = 0; i < k; i++)
        {
            int l = in.nextInt();
            key[i] = l;
            place.put(l,in.nextInt());
        }

        for(int i = 0; i < k; i++)
        {
            fin[key[i]] = place.get(key[i]);
        }

        


    }
}
