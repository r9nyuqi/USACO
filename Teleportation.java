import java.util.*;
import java.io.*;

public class Teleportation {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("teleport.in"));
		int c = in.nextInt();
        int d = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int x = Math.min(c,d);
        int y = Math.max(c,d);
        
        int lower = Math.min(a,b);
        int higher = Math.max(a,b);
        PrintWriter pw = new PrintWriter(new File("teleport.out"));
        pw.println(Math.min(Math.abs(x-lower) + Math.abs(y-higher),y-x));
        pw.close(); 

    }
}