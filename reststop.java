import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class reststop {
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("reststops.in"));

		int n = in.nextInt();
		long rf = in.nextLong();
		long rb = in.nextLong();
		
		long[] c = new long[n];
		long[] p = new long[n];
		
		for (int i = 0; i < n; i++) {
		
			p[i] = in.nextLong();
			c[i] = in.nextLong();
		}
		
		in.close();
		
		long[] rest = new long[n];
		rest[n-1] = c[n-1];
		
		for (int i = n - 2; i >= 0; i--) 
        {
			rest[i] = Math.max(rest[i+1], c[i]);
		}
		
		ArrayList<Integer> changes = new ArrayList<Integer>();
		
		for (int i = 0; i < n - 1; i++) 
        {
			if (rest[i] != rest[i+1]) 
            {
				changes.add(i);
			}
		}
		
		changes.add(n - 1);
		
		long john = 0, bessie = 0, co = 0, op = 0;
		
		for (int i = 0; i < changes.size(); i++) 
        {
			bessie = john + (p[changes.get(i)] - op) * rb;
			john = rf * p[changes.get(i)];
			co += (john - bessie) * c[changes.get(i)];
			op = p[changes.get(i)];
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out"))); 
		pw.println(co);
		pw.close();
		System.out.println(co);
	}
}