import java.util.*;
import java.io.*;

public class rug {
    static String[] direction;
    static int[] x;
    static int[] y;
    static ArrayList<String> east;
    static ArrayList<String> north;
    static ArrayList<Integer> eX;
    static ArrayList<Integer> nX;
    static ArrayList<Integer> eY;
    static ArrayList<Integer> nY;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        direction = new String[n];
        x = new int[n];
        y = new int[n];
        east = new ArrayList<>();
        north = new ArrayList<>();
        eX = new ArrayList<>();
        nX = new ArrayList<>();
        eY = new ArrayList<>();
        nY = new ArrayList<>();
        for(int i = 0; i < n; i ++)
        {
            direction[i] = in.next();
            x[i] = in.nextInt();
            y[i] = in.nextInt();

        }
        for(int i = 0; i < n; i ++)
        {
            if(direction[i].equals("E"))
            {
                east.add(direction[i]);
                eX.add(x[i]);
                eY.add(y[i]);
            }
            else if(direction[i].equals("N"))
            {
                north.add(direction[i]);
                nX.add(x[i]);
                nY.add(y[i]);
                

            }

        }

        for(int i = 0; i < n; i++)
        {
            int sub = Integer.MAX_VALUE;
            int count = Integer.MAX_VALUE;
            if(direction[i].equals("E"))
            {
                boolean blocked = false;
                for(int j = 0; j < north.size(); j++)
                {
                    for(int k = 0; k < east.size(); k++)
                    {
                        if(nX.get(j) - eX.get(k) < nX.get(j) - x[i] && nX.get(k) > x[i])
                        {
                            blocked = true;
                        }
                    }
                    if((y[i] - nY.get(j)) < (nX.get(j) - x[i]) && nY.get(j) <= y[i] && !blocked)
                    {
                        sub = (nX.get(j) - x[i]);
                    }
                    count = Math.min(count,sub);
                    

                }

            } 
            else if(direction[i].equals("N"))
            {
                boolean blocked = false;
                for(int j = 0; j < east.size(); j++)
                {
                    for(int k = 0; k < north.size(); k++)
                    {

                    }
                    if(x[i] - eX.get(j) < eY.get(j) - y[i] && eX.get(j) <= x[i])
                    {
                        count = eY.get(j) - y[i];
                    }
                    count = Math.min(count,sub);

                }

            }
            if(count == Integer.MAX_VALUE)
            {
                System.out.println("Infinity");
            }
            else
            {
                System.out.println(count);
            }

        }
    }
}

