import java.util.*;
import java.io.*;

public class cowTip {
	public static void main(String[] args) throws IOException{
		
		
		Scanner in = new Scanner(new FileReader("cowtip.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("cowtip.out"));
		
		
		int cows = in.nextInt();
		char[][] field = new char[cows][cows];
		
		for(int i = 0; i < cows; i++) 
        {
			field[i] = in.next().toCharArray();
		}
		
		int tips = 0;
		for(int i = cows - 1; i >= 0; i--) 
        {
			for(int j = cows - 1; j >= 0; j --) 
            {
				
				if(field[i][j] == '1') 
                {
					tips ++;
					for(int z = i; z >= 0; z--) 
                    {
						for(int a = j; a >= 0; a --) 
                        {
							if(field[z][a] == '1') 
                            {
								field[z][a] = '0';
							}
							
							else 
                            {
								field[z][a] = '1';
							}
						}
					}
				}
			}
		}
		
		pw.print(tips);
		pw.close();
	}
}
