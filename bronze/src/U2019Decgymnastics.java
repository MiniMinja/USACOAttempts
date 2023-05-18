import java.io.*;
import java.util.*;
public class U2019Decgymnastics {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("gymnastics.in"));
		int k = in.nextInt();
		int n = in.nextInt();
		
		int[][] rankings = new int[k][n];
		for(int i = 0;i<k;i++) {
			for(int j = 0;j<n;j++) {
				rankings[i][j] = in.nextInt();
			}
		}
		
		in.close();
		
		int[][] pairing = new int[n+1][n+1];
		for(int j = 0;j<n-1;j++) {
			for(int l = j+1;l<n;l++) {
				int cow1 = rankings[0][j];
				int cow2 = rankings[0][l];
				pairing[cow1][cow2]++;
			}
		}
		
		for(int i = 0;i<k;i++) {
			for(int j = 0;j<n-1;j++) {
				for(int l = j+1;l<n;l++) {
					int cow1 = rankings[i][j];
					int cow2 = rankings[i][l];
					if(pairing[cow1][cow2] == 1) {
						//the pair stays 1
					}
					else {
						pairing[cow2][cow1] = 0;
					}
				}
			}
		}
		
		int consistentPairs = 0;
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				if(pairing[i][j] == 1) {
					consistentPairs++;
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		out.println(consistentPairs);
		out.close();
		
	}
	
	public static void printArray(int[][] p) {
		for(int i = 0;i<p.length;i++) {
			for(int j = 0;j<p[i].length;j++) {
				System.out.print(p[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
