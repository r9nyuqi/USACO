import java.util.*;
import java.io.*;
import java.lang.Math;

public class lost {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter("lostcow.out");

        int fj = in.nextInt();
        int b = in.nextInt();

        int total = 0;
        int dist = 1;
        int fj_pos = fj;

        while (true) {
            int new_position = fj + dist;

            if (new_position > b && fj < b) 
            {
                pw.println(Integer.toString(total + b - fj_pos));
                break;
            }

            if (new_position < b && fj > b) 
            {
                pw.println(Integer.toString(total + fj_pos - b));
                break;
            }
            
            if (new_position == b) 
            {
                pw.println(Integer.toString(total + Math.abs(b - fj_pos)));
				break;
            }

            total += Math.abs(new_position - fj_pos);
            dist *= -2;
            fj_pos = new_position;
        }
        pw.close();
    }
}
