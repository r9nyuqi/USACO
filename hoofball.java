import java.util.*;
import java.io.*;

public class hoofball {
    
    static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new File("hoofball.in"));
		//Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        for(int i =0; i <n; i++)
        {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        double count = 0;
        for(int i = 0; i < n; i++)
        {
            if(isCycle(i))
            {
                count += 0.5;
            }
            else if(isConnected(i) == false)
            {
                count ++;
            }
        }

        PrintWriter pw = new PrintWriter(new File("hoofball.out"));
        pw.println((int)count);
        pw.close();
        System.out.println((int)count);
        
    }

    public static boolean isCycle(int n)
    {
        if(n == 0)
        {
            if(pointTo(1) == 0 && pointTo(2) != 1)
            {
                return true;
            }

        }
        else if (n == arr.length-1)
        {
            if(pointTo(arr.length-2) == arr.length-1 && pointTo(arr.length-3) != arr.length-2)
            {
                return true;
            }
        }
        else
        {
            if(n != 1 && n != arr.length-2)
            {
                if(pointTo(n+1) == n && pointTo(n) == n+1 && pointTo(n-1) != n && pointTo(n+2) != n+1)
                {
                    return true;
                }
                else if(pointTo(n-1) == n && pointTo(n) == n-1 && pointTo(n-2) != n-1 && pointTo(n+1) != n)
                {
                    return true;
                }
            }
            else
            {
                if(n == 1)
                {
                    if(pointTo(n+1) == n && pointTo(n) == n+1 && pointTo(n-1) != n && pointTo(n+2) != n+1)
                    {
                        return true;
                    }
                    else if(pointTo(n-1) == n && pointTo(n) == n-1 && pointTo(n+1) != n)
                    {
                        return true;
                    }
                    
                }
                else if (n == arr.length-2)
                {   
                    if(pointTo(n+1) == n && pointTo(n) == n+1 && pointTo(n-1) != n)
                    {
                        return true;
                    }
                    else if(pointTo(n-1) == n && pointTo(n) == n-1 && pointTo(n-2) != n-1 && pointTo(n+1) != n)
                    {
                        return true;
                    }
                }
            }
            
        }
        return false;
    }

    public static boolean isConnected(int n)
    {
        if(isCycle(n))
        {
            return true;
        }
        if(n == 0)
        {
            if(pointTo(1) == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(n == arr.length-1)
        {
            if(pointTo(arr.length-2) == arr.length-1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(pointTo(n-1) == n || pointTo((n+1)) == n)
            {
                return true;
            }
            else
            {
                return false;
            }
        }


    }

    public static int pointTo(int n)
    {
        int r = 0;
        if(n == 0)
        {
            r = n+1;
        }
        else if(n == arr.length-1)
        {
            r = arr.length-2;
        }
        else
        {
            if(Math.abs(arr[n] - arr[n-1]) <= Math.abs(arr[n+1] - arr[n]))
            {
                r = n-1;
            }
            else
            {
                r = n+1;
            }
        }
        return r;
    }
}
