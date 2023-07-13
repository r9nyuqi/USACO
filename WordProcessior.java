import java.util.*;
import java.io.*;

public class WordProcessior {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("word.in"));
		int n = in.nextInt();
        int k = in.nextInt();
        String[] arr = (in.nextLine()).split(" ");
        String r = "";
      
        for(int i = 0; i< arr.length; i++)
        {
            if(r.length() + arr[i].length() - i <= k)
            {
               r += arr[i];
            }
            else
            {
                System.out.println(r);
                r = "";
            }

           
        }
    }
}