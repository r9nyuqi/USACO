import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class hoofpaperscissors {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileReader("hps.in"));
     
        int n = in.nextInt();
        int[] paperArr = new int[n];
        int[] hoofArr = new int[n];
        int[] scissorsArr = new int[n];
        int paper = 0;
        int hoof = 0;
        int sum = 0;
        for (int i =0 ; i <n;i++)
        {
            String str = in.next();
            if (str.equals("H")) 
                hoof += 1;
            if (str.equals("P")) 
                paper += 1;
            if (str.equals("S")) 
                sum += 1;
            paperArr[i] = paper;
            scissorsArr[i] = sum;
            hoofArr[i] = hoof;
        }
        int max = 0;
        for (int i= 0; i <n;i++)
            max = Math.max(max,Math.max(scissorsArr[i],Math.max(paperArr[i],hoofArr[i])) + Math.max(scissorsArr[n-1] - scissorsArr[i], Math.max(paperArr[n-1]-paperArr[i],hoofArr[n-1]-hoofArr[i])));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        pw.println(max);
        pw.close();
    }
}