import java.util.*;
import java.io.*;

public class milkingorder {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("milkorder.in"));
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        ArrayList<Integer> cows = new ArrayList<Integer>();
        int[] order = new int[m];

        for(int i = 0; i < n; i++)
        {
            cows.add(0);
        }
        for(int i = 0; i < m; i++)
        {
            order[i] = in.nextInt();
        }

        for(int i = 0; i < k; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt()-1;
            cows.set(b,a);
        }
        if(!cows.contains(order[m-1]))
        {
            for(int i = n-1; i >= 0; i--)
            {
                if(cows.get(i) == 0)
                {
                    cows.set(i,order[m-1]);
                    break;
                }
            }
        }

        for(int i = m-2; i >= 0; i--)
        {
           if(!cows.contains(order[i]))
           {
                for(int j = n-1; j >= 0; j--)
                {
                    if(cows.get(j) == 0)
                    {
                        if(j < cows.indexOf(order[i+1]))
                        {
                            cows.set(j,order[i]);
                            break;
                        }
                    }
                }
           }

        }

        PrintWriter pw = new PrintWriter(new File("milkorder.out"));
        boolean con = false;
        if(cows.contains(1))
        {
            con =true;
        }
        for(int i = 0; i < cows.size(); i++)
        {
            if(con)
            {
                if(cows.get(i) == 1)
                {
                    pw.println(i+1);
                    System.out.println(i+1);
                    break;
                }
            }
            else
            {
                if(cows.get(i) == 0)
                {
                    pw.println(i+1);
                    System.out.println(i+1);
                    break;
                }
            }
        }
        pw.close();

        

        


    }
}

