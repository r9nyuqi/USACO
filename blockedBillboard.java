import java.util.*;
import java.io.*;
public class blockedBillboard {
	static int area = 0;
    
    public static void findArea(int[] lawnBill, int[] feedBill) {
		int xA = feedBill[0];
		int yA = feedBill[2];
		int xB = feedBill[3];
		int yB = feedBill[1];
		
		int xC = lawnBill[0];
		int yC = lawnBill[2];
		int xD = lawnBill[3];
		int yD = lawnBill[1];
		
		area = (yC - xC) * (xD - yD);
		
		if((xA <= xC && yA >= yC) && ((xB >= xD && yB < xD) || (yB <= yD && xB > yD))){ 
			
			area -= (yC - xC) * (Math.min(xB, xD) - Math.max(yB,  yD));
			return;
		}
		else if((xB >= xD && yB <= yD) && ((xA <= xC && yA > xC) || (yA >= yC && xA < yC))) {
		
			area -= (Math.min(yA, yC) - Math.max(xA, xC)) * (xD - yD);
			return;
		}
	}
	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(new FileReader("billboard.in"));
        Scanner in = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new FileWriter("billboard.out"));
		int[] lawnBill = new int[4]; 
	
		for(int i = 0; i < 4; i++) {
			lawnBill[i] = in.nextInt();
		}
		int[] feedBill = new int[4];
		
		for(int i = 0; i < 4; i++) {
			feedBill[i] = in.nextInt();
		}

		findArea(lawnBill, feedBill);
		pw.println(area);
		pw.close();
		
	}
	
}