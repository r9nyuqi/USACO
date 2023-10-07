import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class sleepyCowHerding {

    public static void main(String[] args) throws FileNotFoundException
    {
    Scanner in = new Scanner(new File("herding.in"));
    PrintWriter pw = new PrintWriter(new File("herding.out"));
    int min;
	int max;
	
    int b = in.nextInt();
	int e = in.nextInt();
	int m = in.nextInt();
	
	if(e == b + 1 && m == b + 2) {
		min = 0;
	}
	
	else if(e == b + 2 || m == e + 2) {
		min = 1;
	}
	
	else {
		min = 2;
	}
	
	max = Math.max(e - b-1, m - e - 1);
		
	pw.println(min);
	pw.print(max);
	pw.close();

	}
}

