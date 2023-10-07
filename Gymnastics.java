import java.io.*;
import java.util.*;
import java.util.Arrays;
public class Gymnastics {
public static void main(String[] args) throws IOException {
Scanner in = new Scanner(new FileReader("gymnastics.in"));
PrintWriter pw = new PrintWriter(new FileWriter("gymnastics.out"));

int k = in.nextInt();
int n = in.nextInt();
int[][] cows = new int[k][n];
for (int i = 0; i < k; i++) 
{
  for (int j = 0; j < n; j++) 
  {
    cows[i][j] = in.nextInt();
  }
}
int count = 0;
for (int i = 0; i < n; i++) 
{
  for (int j = 0; j < n; j++) 
  {
    int cow1 = cows[0][i];
    int cow2 = cows[0][j];
    int pairs = 0;
    if (cow1 != cow2) 
    {
      for (int l = 0; l < k; l++) 
      {
        int pos1 = 0;
        int pos2 = 0;
        for (int m = 0; m < n; m++) 
        {
          if (cows[l][m] == cow1)
          {
            pos1 = m;
          } 
          if (cows[l][m] == cow2)
          {
            pos2 = m;
          } 
        }
        if (pos1 < pos2) pairs++;
      }
    }
    if (pairs == k) count++;
  }
}
pw.println(count);
pw.close();
	}
} 
