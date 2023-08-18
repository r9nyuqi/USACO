import java.io.*;
import java.util.*;
public class Diamonds {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("diamond.in"));
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) 
        {
			list[i] = in.nextInt();
		}
		Arrays.sort(list);
		
		int[] left = getLeftmost(list, k);
		
		int[] leftSize = new int[n];
		for (int i = 0; i < n; i++) 
        {
			leftSize[i] = i - left[i] + 1;
			if(i > 0) 
            { 
                leftSize[i] = Math.max(leftSize[i], leftSize[i - 1]); 
            }
		}
	
		int[] right = getRightmost(list, k);
		
		int[] rightSize = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			rightSize[i] = right[i] - i + 1;
			if (i < n - 1) {
				rightSize[i] = Math.max(rightSize[i], rightSize[i + 1]);
			}
		}
		int ret = 0;
		for (int i = 0; i < n - 1; i++) {
			ret = Math.max(ret, leftSize[i] + rightSize[i + 1]);
		}
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		pw.println(ret);
		pw.close();
	}

	public static int[] getRightmost(int[] list, int k) 
    {
		int[] ret = new int[list.length];
		int j = list.length - 1;
		for (int i = list.length - 1; i >= 0; i--) {
			while (j >= 0 && list[j] - list[i] > k) 
            { 
                j--; 
            }
			ret[i] = j;
		}
		return ret;
	}

	public static int[] getLeftmost(int[] list, int k) {
		int[] ret = new int[list.length];
		int j = 0;
		for (int i = 0; i < list.length; i++) {
			while (j < list.length && list[i] - list[j] > k) 
            {
                j++; 
            }
			ret[i] = j;
		}
		return ret;
	}
}