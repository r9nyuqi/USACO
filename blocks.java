import java.io.*;
import java.util.*;

public class blocks {
  public static void main (String [] args) throws IOException {
    
    Scanner in = new Scanner(new File("blocks.in "));
    int N = in.nextInt();  
    int[] ret = new int[26];
    for(int i = 0; i < N; i ++)
    {
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        String word1 = in.next();
  
        for(int j = 0; j < word1.length(); j++)
        {
            c1[(int) word1.charAt(j) - 97] ++;
        }

        String word2 = in.next();

        for(int j = 0; j < word2.length(); j++)
        {
            c2[(int) word2.charAt(j) - 97] ++;
        }
        for(int j = 0; j < 26; j++){
            ret[j] += Math.max(c1[j], c2[j]);
        }
    }
    PrintWriter pw = new PrintWriter(new FileWriter("blocks.out"));

    for(int i : ret)
    {
        pw.println(i);
    }




    pw.close();
  }
}
