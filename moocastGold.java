import java.util.*;
import java.io.*;

public class moocastGold {
    static int[] x;
    static int[] y; 
    public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("moocast.in"));
		int n = in.nextInt();
        x = new int[n];
        y = new int[n]; 

        for(int i = 0; i < n; i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        
        
    }
}