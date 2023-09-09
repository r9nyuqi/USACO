import java.util.*;
import java.io.*;

public class breedCount {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("bcount.in"));
		int n = in.nextInt();
        int q = in.nextInt();
        ;
        int[] one = new int[n];
        int[] two = new int[n];
        int[] three = new int[n];
        int a = in.nextInt();
        
        if(a == 1)
        {
            one[0] = 1;
        }
        else if(a == 3)
        {
            three[0] = 1;
        }
        else
        {
            two[0] = 1;
        }
        for(int i = 1; i < n; i++)
        {
            int b = in.nextInt();
            
            one[i] = one[i-1];
            two[i] = two[i-1];
            three[i] = three[i-1];
            if(b ==1)
            {
                one[i] ++;
            }
            else if(b ==2)
            {
                two[i] ++;
            }
            else if(b ==3 )
            {
                three[i] ++;
            }
        }

        PrintWriter pw = new PrintWriter(new File("bcount.out"));
        for(int i = 0; i < q; i++)
        {
             int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			
			if (x != 0) {
				pw.print(one[y] - one[x - 1]);
				pw.print(" ");
				pw.print(two[y] - two[x - 1]);
				pw.print(" ");
				pw.println(three[y] - three[x - 1]);
			} else {
				pw.print(one[y]);
				pw.print(" ");
				pw.print(two[y]);
				pw.print(" ");
				pw.println(three[y]);
			}
        }

        pw.close();
    }
}