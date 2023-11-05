import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class paintingbarn {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader("paintbarn.in"));
     
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] barn = new int[1002][1002];
        for (int i= 0; i < N;i++){
            
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            barn[y1][x1] += 1;
            barn[y2][x2] += 1;
            barn[y1][x2] -= 1;
            barn[y2][x1] -= 1;
        }
        int ans =0 ;
        int[][] sums = new int[1002][1002];
        for (int i= 0; i < 1002;i++){
            for (int j= 0; j < 1002;j++)
            {
                int sum = 0;
                sum += barn[i][j];
                if (j > 0) 
                {
                    sum += sums[i][j-1];
                }

                if (i > 0) 
                {
                    sum += sums[i-1][j];
                }
                if (j > 0 && i > 0) 
                {
                    sum -= sums[i-1][j-1];
                }
                sums[i][j] = sum;
                if (sum == M)
                {
                    ans += 1;
                } 
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        pw.println(ans);
        pw.close();
    }
}