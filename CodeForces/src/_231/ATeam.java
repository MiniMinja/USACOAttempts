package _231;

import java.util.Scanner;

public class ATeam {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int totalSolve = 0;
		for(int i = 0;i<n;i++) {
			int p = in.nextInt();
			int v = in.nextInt();
			int t = in.nextInt();
			if(p+v+t >= 2) {
				totalSolve++;
			}
		}
		
		System.out.println(totalSolve);
		
	}
}
