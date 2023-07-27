import java.util.*;
import java.io.*;

public class mowing {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(new File("mowing.in"));
        Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        String[] directions = new String[n];
        int x = Integer.MAX_VALUE;
        int[] steps = new int[n];
        int[][] grid = new int[1000][10000];
        for(int i = 0; i < n; i++)
        {
            directions[i] = in.next();
            steps[i] = in.nextInt();
        }
        grid[500][500] = 1;
        int cordX = 500; 
        int cordY = 500;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            
            for(int j = 0; j < steps[i]; j++)
            {
                if(directions[i].equals("N"))
                {   
                    cordY++;
                }
                else if(directions[i].equals("E"))
                {
                    cordX++;
                }
                else if(directions[i].equals("S"))
                {
                    cordY--;
                }
                else if(directions[i].equals("W"))
                {
                    cordX--;
                }
                if(grid[cordX][cordY] == 1)
                {
                    grid[cordX][cordY] = 2;
                }
                else
                    grid[cordX][cordY] = 1;
            
            }
        }
        boolean start = false;
        cordX = 500;
        cordY = 500;
        int tempx = 0;
        int tempy = 0;
        for(int i = 0; i < n; i++)
        {
            
            for(int j = 0; j < steps[i]; j++)
            {
                if(directions[i].equals("N"))
                {   
                    cordY++;
                    
                }
                else if(directions[i].equals("E"))
                {
                    cordX++;
                    
                }
                else if(directions[i].equals("S"))
                {
                    cordY--;
                     
                }
                else if(directions[i].equals("W"))
                {
                    cordX--;
                    
                }
                if(start)
                {
                    count++;
                }
                if(start && grid[cordX][cordY] == 2 && cordX == tempx && cordY == tempy)
                {
                    x = Math.min(x,count);
                    start = false;
                    count = 0;
                    if(!(cordX == tempx && cordY == tempy))
                    {
                        tempx = cordX;
                        tempy = cordY;
                    }
                }
                if(grid[cordX][cordY] == 2)
                {
                    tempx = cordX;
                    tempy = cordY;
                    start = true;
                    
                }
                
            
            }
        }
        if(x == Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
        System.out.println(x);
    }
}