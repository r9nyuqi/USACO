import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BerryPicking {
    public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("berries.in"));
        //Scanner in = new Scanner(System.in);
		int numTrees = in.nextInt();
        int numBaskets = in.nextInt();
        int sum = 0; 
        PriorityQueue<Integer> trees = new PriorityQueue<>((a,b) -> b-a);
        int[] berries = new int[numTrees];
        for(int i = 0; i < numTrees; i++)
        {
           berries[i] = in.nextInt();
           trees.add(berries[i]);
        }   
        int x = trees.peek();
        for(int z = 1; z <= x; z++)
        {
            if(trees.peek() > 0)
            {

            
            int currentSum = 0;
            
            trees = new PriorityQueue<>((a,b) -> b-a);
            for(int k = 0; k < numTrees; k++)
            {
                trees.add(berries[k]);
            }   
            for(int j = 1; j <= numBaskets/2; j++)
            {
                trees.add(trees.peek()-z);
                trees.poll();
                
            }

            for(int j = 1; j <= numBaskets/2; j++)
            {
                if(trees.peek() > z)
                {
                    currentSum += z;
                    trees.add(trees.peek()-z);
                    trees.poll();
                }
                else
                {
                    currentSum += trees.peek();
                    trees.poll();
                }
               
               
               
                if (currentSum >= sum)
                {
                    sum = currentSum;
                }
                
                
            }
            // System.out.println();
            // System.out.println(currentSum);
            // System.out.println(sum);
            ;
            
        }
        }
        PrintWriter pw = new PrintWriter(new File("berries.out"));
        //System.out.println(sum);
		pw.print(sum);
		pw.close();

        
        
        
        

        
        


    
}}
