import java.util.*;
import java.io.*;

public class censoring {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("censor.in"));
        //Scanner in = new Scanner(System.in);
		String word = in.next();
        String censor = in.next();
        StringBuilder r = new StringBuilder();
       
        for(int i = 0; i < word.length(); i++)
        {
            r.append(word.charAt(i));
            if(r.length() >= censor.length())
            {
                if(r.substring((r.length()-censor.length())).equals(censor))
                {
                    r.delete((r.length()-censor.length()),r.length());
                }
            }
            
        }

       
        

        PrintWriter pw = new PrintWriter(new File("censor.out"));
        pw.println(r);
        pw.close();
        System.out.println(r);
    }
}