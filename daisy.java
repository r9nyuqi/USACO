import java.util.*;
public class daisy {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] pasture = new int[n];
		
		for(int i=0; i<n; i++)
        {
			pasture[i] = in.nextInt();
        }
		
		int num = 0;
		
		for(int i=0; i<n-1; i++) 
        {
			for(int j=i+1; j<n; j++) 
            {
				double avg = 0;
				
				for(int k=i; k<=j; k++)
					avg+=pasture[k];
				
				avg/=((j-i)+1);
				
				for(int k=i; k<=j; k++) 
                {
					if((double)pasture[k] == avg) 
                    {
						num++;
						break;
					}
				}
			}
		}
		System.out.println(num+n);
	}
}
