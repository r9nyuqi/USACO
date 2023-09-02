import java.util.*;
import java.io.*;

public class TickTackToe {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("tttt.in"));
		//Scanner in = new Scanner(System.in);
        String[][] grid = new String[3][3];
        for(int i = 0; i < 3; i ++)
        {
            String word = in.next();
            grid[i][0] = word.substring(0,1);
            grid[i][1] = word.substring(1,2);
            grid[i][2] = word.substring(2,3);
        }

        ArrayList<String> oneTeam = new ArrayList<String>();
        ArrayList<String> twoTeam = new ArrayList<String>();

        int one = 0;
        int two = 0;

        if(grid[0][0].equals(grid[0][1]) && grid[0][0].equals(grid[0][2]) && grid[0][1].equals(grid[0][2]))
        {
            if(!oneTeam.contains(grid[0][0]))
            {
                one += 1;
                oneTeam.add(grid[0][0]);
            }
            

        }
        else if(grid[0][0].equals(grid[0][1]) || grid[0][0].equals(grid[0][2]) || grid[0][1].equals(grid[0][2]))
        {
            two ++;
        }

        if(grid[1][0].equals(grid[1][1]) && grid[1][0].equals(grid[1][2]) && grid[1][1].equals(grid[1][2]))
        {
            if(!oneTeam.contains(grid[1][0]))
            {
                one += 1;
                oneTeam.add(grid[1][0]);
            }
        }
        else if(grid[1][0].equals(grid[1][1]) || grid[1][0].equals(grid[1][2]) || grid[1][1].equals(grid[1][2]))
        {
            two ++;
        }

        if(grid[2][0].equals(grid[2][1]) && grid[2][0].equals(grid[2][2]) && grid[2][1].equals(grid[2][2]))
        {
            if(!oneTeam.contains(grid[2][0]))
            {
                one += 1;
                oneTeam.add(grid[2][0]);
            }
        }
        else if(grid[2][0].equals(grid[2][1]) || grid[2][0].equals(grid[2][2]) || grid[2][1].equals(grid[2][2]))
        {
            two ++;
        }

        if(grid[0][0].equals(grid[1][0]) && grid[0][0].equals(grid[2][0]) && grid[1][0].equals(grid[2][0]))
        {
            if(!oneTeam.contains(grid[0][0]))
            {
                one += 1;
                oneTeam.add(grid[0][0]);
            }
        }
        else if(grid[0][0].equals(grid[1][0]) || grid[0][0].equals(grid[2][0]) || grid[1][0].equals(grid[2][0]))
        {
            two ++;
        }

        if(grid[0][1].equals(grid[1][1]) && grid[0][1].equals(grid[2][1]) && grid[1][1].equals(grid[2][1]))
        {
            if(!oneTeam.contains(grid[1][1]))
            {
                one += 1;
                oneTeam.add(grid[1][1]);
            }
        }
        else if(grid[0][1].equals(grid[1][1]) || grid[0][1].equals(grid[2][1]) || grid[1][1].equals(grid[2][1]))
        {
            two ++;
        }
        
        if(grid[0][2].equals(grid[1][2]) && grid[0][2].equals(grid[2][2]) && grid[1][2].equals(grid[2][2]))
        {
            if(!oneTeam.contains(grid[0][2]))
            {
                one += 1;
                oneTeam.add(grid[0][2]);
            }
        }
        else if(grid[0][2].equals(grid[1][2]) || grid[0][2].equals(grid[2][2]) || grid[1][2].equals(grid[2][2]))
        {
            two ++;
        }


        if(grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2]) && grid[1][1].equals(grid[2][2]))
        {
            if(!oneTeam.contains(grid[0][0]))
            {
                one += 1;
                oneTeam.add(grid[0][0]);
            }
        }
        else if(grid[0][0].equals(grid[1][1]) || grid[0][0].equals(grid[2][2]) || grid[1][1].equals(grid[2][2]))
        {
            two ++;
        }

        if(grid[0][2].equals(grid[1][1]) && grid[0][2].equals(grid[2][0]) && grid[1][1].equals(grid[2][0]))
        {
            if(!oneTeam.contains(grid[0][2]))
            {
                one += 1;
                oneTeam.add(grid[0][2]);
            }
        }
        else if(grid[0][2].equals(grid[1][1]) || grid[0][2].equals(grid[2][0]) || grid[1][1].equals(grid[2][0]))
        {
            two ++;
        }
        PrintWriter pw = new PrintWriter(new File("tttt.out"));
        pw.println(one);
        pw.println(two);
        pw.close();
        System.out.println(one);
        System.out.println(two);


    }
}