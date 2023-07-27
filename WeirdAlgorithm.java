import java.util.*;
import java.io.*;

public class WeirdAlgorithm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        while(n != 1)
        {
            if(n % 2 ==0)
            {
                n/=2;
            }
            else
            {
                n*=3;
                n+=1;
            }
            System.out.println(n);
        }
    }
    
}