import java.io.*;
import java.util.*;

public class circle {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cbarn.out"));

        int n = in.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
        {
            list.add(in.nextInt());
        }
        
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            int sum = 0;
            int count = 1;
            for (int j = i + 1; j < n + i; j++)
            {
                sum += list.get(j % n) * count;
                count++;
            }
            sumList.add(sum);
        }

        pw.println(Collections.min(sumList));
        pw.close();
    }
}