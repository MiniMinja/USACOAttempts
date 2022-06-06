
import java.util.Scanner;

public class CF546ASoldierAndBananas {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int k = in.nextInt();
		int n = in.nextInt();
		int w = in.nextInt();
		
		int totalCost = k * w * (w + 1) / 2;
		
		int output = 0;
		if(totalCost > n) {
			output = totalCost - n;
		}
		
		System.out.println(output);
	}
}
