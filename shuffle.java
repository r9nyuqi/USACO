import java.util.Scanner;
import java.io.*;


public class shuffle {
    public static void main(String[] args) throws java.io.IOException 
    {
        Scanner in = new Scanner(new File("shuffle.in"));
        int n = in.nextInt();
        int[] shuffle = new int[n];

        for (int i = 0; i < n; i++)
        {
            shuffle[i] = in.nextInt();
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) 
        { 
            arr[i] = in.nextInt(); 
        }
        
        PrintWriter out = new PrintWriter("shuffle.out");
        for (int j = 0; j < 3; j++) 
        {
            int[] prev = arr.clone();
            for (int i = 0; i < n; i++) 
            {
                arr[i] = prev[shuffle[i]-1];
            }
        } 
        for (int i = 0; i < n; i++)
        {
          out.println(arr[i]);
        }
		out.close();
    }
}