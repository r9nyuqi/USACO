import java.util.*;
import java.io.*;

public class Shell {
    public static void main(String[] args) throws FileNotFoundException
    {
       //Scanner scan = new Scanner(System.in);
            Scanner scan = new Scanner(new File("shell.in"));
            int n = scan.nextInt();
            int[] p1 = new int[n];
            int[] p2 = new int[n];
            int[] guess = new int[n];
            for(int i = 0; i<n; i++)
            {
                p1[i] = scan.nextInt() - 1;
                p2[i] = scan.nextInt() - 1;
                guess[i] = scan.nextInt() - 1;
            }

            int sum = 0;
            for(int i = 0; i < 3; i++)
            {
                int currentSum = 0;
                int[] arr = new int[3];
                for(int k = 0; k < 3; k++)
                {
                    if(k != i)
                    {
                        arr[k] = 0;
                    }
                    else{
                        arr[k] = 1;
                    }
                }
                
                for(int j = 0; j < n; j++)
                {
                    int place1 = p1[j];
                    int place2 = p2[j];
                    int guess1 = guess[j];
                    int temp = arr[place1];
                    arr[place1] = arr[place2];
                    arr[place2] = temp;
                   
                   
                    if(arr[guess1] == 1)
                    {
                        currentSum++;
                    }
                }
                if(currentSum >= sum)
                {
                    sum = currentSum;
                }
               
                
            }

            PrintWriter pw = new PrintWriter(new File("shell.out"));
            
            //System.out.println(sum);
            pw.print(sum);
            pw.close();
            //scan.close();
        }
       

    }

