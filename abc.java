import java.io.*;
import java.util.*;
public class abc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums[] = new int[7];
		for (int i = 0; i < 7; i++) { nums[i] = sc.nextInt(); }
		Arrays.sort(nums);
		int a = nums[0], b = nums[1];
		int c = nums[6] - a - b;

		
		System.out.println(a + " " + b + " " + c);
	}
}