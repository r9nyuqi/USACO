
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class race {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("race.in"));

        int k = in.nextInt();
        int n = in.nextInt();
		PrintWriter pw = new PrintWriter("race.out");
        for (int i = 0; i < n; i += 1) {
            
			int ending_speed = in.nextInt();

            int remain = k;
            int speed = 0;
            int time = 0;

            while (true) 
			{
                speed += 1;
                remain -= speed;
                time += 1;

                if (remain <= 0) 
				{
                    break;
                }

                if (speed >= ending_speed) 
				{
                    remain -= speed;
                    time += 1;

                    if (remain <= 0) 
					{
                        break;
                    }
                }
            }

            pw.println(time);
        }
        pw.close();
    }
}