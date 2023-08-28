import java.util.*;
import java.io.*;

public class squarePasture {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("square.in"));
		int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();
        int x4 = in.nextInt();
        int y4 = in.nextInt();

        int firstHighX = Math.max(x1,x2);
        int firstHighY = Math.max(y1,y2);
        int firstLowX = Math.min(x1,x2);
        int firstLowY = Math.min(y1,y2);
        int SecHighX = Math.max(x3,x4);
        int SecLowX = Math.min(x3,x4);
        int SecHighY= Math.max(y3,y4);
        int SecLowY= Math.min(y3,y4);

        int prem = 0;
        prem = Math.max(Math.abs(firstHighX-SecLowX),Math.abs(SecHighX-firstLowX));
        prem = Math.max(prem,Math.abs(firstHighY-SecLowY));
        prem = Math.max(prem,Math.abs(SecHighY-firstLowY));
        prem = Math.max(prem,Math.abs(firstHighX-SecHighX));
        prem = Math.max(prem,Math.abs(firstHighY-SecHighY));
        



        PrintWriter pw = new PrintWriter(new File("square.out"));
        pw.println(prem*prem);
        pw.close();
    }
}
