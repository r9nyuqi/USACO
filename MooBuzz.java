import java.util.*;
import java.io.*;

public class MooBuzz {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("moobuzz.in"));
        //Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        int[] first8 = {14, 1, 2, 4, 7, 8, 11, 13};
		int res = 0;
		res = (n- 1) / 8;
		res *= 15;
		res += first8[n% 8];
      

        PrintWriter pw = new PrintWriter(new File("moobuzz.out"));
		pw.print(n);
		pw.close();
    }
}