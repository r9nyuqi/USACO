import java.util.*;
import java.io.*;

public class FencePainting {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("paint.in"));
		int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int bessieA = Math.min(c,d);
        int bessieB = Math.max(d,c);
        int fjA = Math.min(a,b);
        int fjB = Math.max(a,b);
        PrintWriter pw = new PrintWriter(new File("paint.out"));
        int min = Math.max(fjB-bessieA, bessieB-fjA);
        pw.println(Math.min(min,fjB-fjA+bessieB-bessieA));
        pw.close();
    }
}