import java.io.*;
import java.util.*;

public class triangles {
    public static void main(String[] args) throws IOException {
       
        Scanner in = new Scanner(new FileReader("triangles.in"));
        
        PrintWriter pw = new PrintWriter(new FileWriter("triangles.out"));
       
       
        
        int result = 0;


        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (i == j || x[i] != x[j]) 
                {
                    continue; 
                }
                for (int k = 0; k < n; k++) 
                { 
                    if (i == k || y[i] != y[k]) 
                    {   
                        continue; 
                    }
                    result = Math.max(result, Math.abs(y[j] - y[i]) * Math.abs(x[k] - x[i]));
                }
            }
        }


        pw.println(result);                         
        pw.close();                                  
    }
}