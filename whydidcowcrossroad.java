import java.io.*;
import java.util.Scanner;

public class whydidcowcrossroad {
    public static void main(String[]args) throws IOException {
        Scanner in = new Scanner(new File("maxcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		
        int n = in.nextInt();
        int k = in.nextInt();
        int b = in.nextInt();

        int lights[] = new int[n + 1];
        int min = Integer.MAX_VALUE;

        int pre[] = new int[n+1];
        for(int i = 0; i < b; i++)
        {
            int id = in.nextInt();
            lights[id] = -1;
        }


        for(int i = 1 ; i < n + 1; i ++)
        {
            if(lights[i] == -1){
                pre[i] = 1;
            }
            pre[i] = pre[i] + pre[i - 1];

        }
        for(int i = 1; i < n + 1; i++){
            if(lights[i] == 0 && i + k - 1 <= n)
            {
                if(pre[i + k - 1] - pre[i - 1] < min)
                {
                    min = pre[i + k - 1] - pre[i - 1];
                }
            }
        }
        pw.println(min);
        pw.close();
    }
}