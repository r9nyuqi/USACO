import java.util.*;
import java.io.*;

public class censoring {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("censor.in"));
        //Scanner in = new Scanner(System.in);
		String word = in.next();
        String censor = in.next();

        for(int i = 0; i < word.length(); i ++)
        {
            boolean match = false;
            if(word.charAt(i) == censor.charAt(0))
            {
                match = true;
                int index = i;
                i ++;
                for(int j = 1; j < censor.length(); j++)
                {
                    if(word.charAt(i) != (censor.charAt(j)))
                    {
                        i-= j-1;
                        match = false;
                        break;
                    }
                    i++;
                }
                if(match)
                {
                    word = word.substring(0,index) + word.substring(i);
                    i = index-censor.length();
                }
            }
        }

        PrintWriter pw = new PrintWriter(new File("censor.out"));
        pw.println(word);
        pw.close();
        System.out.println(word);
    }
}