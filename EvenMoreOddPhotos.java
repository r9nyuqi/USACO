import java.util.*;
import java.io.*;

public class EvenMoreOddPhotos {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
        {
            int a = in.nextInt();
            if(a % 2 == 0)
            {
                even.add(a);
            }
            else
            {
                odd.add(a);
            }
        }

        
        int ans = 0;
       
        if(even.size() == odd.size() || even.size() == odd.size()+1)
        {
            ans = odd.size() + even.size();
        }
        else if(even.size() > odd.size() +1)
        {
            ans = odd.size()*2 +1;
        }
        else 
        {
            while(odd.size() > even.size())
            {
                odd.remove(0);
                odd.remove(0);
                even.add(2);
            }
            
            if(even.size() == odd.size() || even.size() == odd.size()+1)
            {
                ans = odd.size() + even.size();
            }
            else if(even.size() > odd.size() +1)
            {
                ans = odd.size()*2 +1;
            }
        }
        
        System.out.println(ans);
    }
}
