import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class bucket {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("blist.in"));
        //Scanner in = new Scanner(System.in);
        int max = 0;
        int current = 0;

        ArrayList<Integer> s = new ArrayList<Integer>();
        ArrayList<Integer> t = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        int n = in.nextInt();
        for(int i = 0; i < n; i++)
        {
            s.add(in.nextInt());
            t.add(in.nextInt());
            b.add(in.nextInt());
        }
        ArrayList<Integer> time = new ArrayList<Integer>();

        time.addAll(s);
        time.addAll(t);

        Collections.sort(time);

        for(int i : time){
            for(int j = 0; j < n; j++)
            {
                if(s.get(j)==i)
                {
                    current+=b.get(j);

                    if(current>max)
                    {
                        max=current;
                    }
                    break;
                }

            }
            for(int j = 0; j < n; j++)
            {
                if(t.get(j) == i)
                {
                    current -= b.get(j);
                    break;
                }
            }

    }

        PrintWriter pw = new PrintWriter(new File("blist.out"));
        pw.print(max);
        pw.close();

}
    
}
