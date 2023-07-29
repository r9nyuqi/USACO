import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class mowing{
  public static void main(String[] args) throws FileNotFoundException{
    Scanner scan = new Scanner(new File("mowing.in"));
    int n = scan.nextInt();
    int[][] arr = new int[2000][2000];
    int t = 1;
    int x = 1000;
    int y = 1000;
    int time = 0;
    char dir = 'a';
    int c = 1000000000;
    ArrayList<Integer> list = new ArrayList<Integer>();

    for(int i = 0; i < n; i++){
      dir = scan.next().charAt(0);
      time = scan.nextInt();
      while(time>0){

        arr[x][y]=t;
        if(dir == 'N')
        {
          y++;
        }
        else if(dir == 'S')
        {
          y--;
        }
        else if(dir == 'E')
        {
          x--;
        }
        else
        {
          x++;
        }

        time--;
        t++;
        if(arr[x][y]!=0)
        {
          c = Math.min(t-arr[x][y],c);
        }
      }
      
      
    }
    PrintWriter pw = new PrintWriter(new File("mowing.out"));
    pw.println(c);
    pw.close();
    System.out.println(c);
  }
}