import java.util.*;
import java.io.*;
public class outofplace {
    
    public static void main(String[] args) throws FileNotFoundException
    {
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File("outofplace.in"));
        int n = in.nextInt();
        int[] cows = new int[n];
        for(int i = 0; i < n; i ++)
        {
            cows[i] = in.nextInt();
        }
        int bessie = 0;
        int bessieIndex = 0;
        for(int i = 0; i < n-1; i++)
        {
            if(cows[i] > cows[i+1])
            {
                if(i == 0)
                {
                    bessie = cows[0];
                    bessieIndex = 0;
                }
                else if(i != 0)
                {
                    bessie = cows[i+1];
                    bessieIndex = i+1;
                }
            }
        }

        int actualIndex = 0;
        for(int i = 0; i < n; i ++)
        {
            if(cows[i] < bessie)
            {
                actualIndex ++;
            }
            else
            {
                break;
            }
        }

        int count = 0;
        if(bessieIndex > actualIndex)
        {
            ArrayList<Integer> num = new ArrayList<Integer>();
            for(int i = actualIndex; i < bessieIndex; i++)
            {
                if(!num.contains(cows[i]))
                {
                    count ++;
                    num.add(cows[i]);
                }
            }
        }
        else if(bessieIndex < actualIndex)
        {
            ArrayList<Integer> num = new ArrayList<Integer>();
            for(int i = actualIndex; i > bessieIndex; i--)
            {
                if(!num.contains(cows[i]))
                {
                    count ++;
                    num.add(cows[i]);
                }
            }
        }

        PrintWriter pw = new PrintWriter(new File("outofplace.out"));
        pw.println(count);
        pw.close();
        System.out.println(count);
    }
}
