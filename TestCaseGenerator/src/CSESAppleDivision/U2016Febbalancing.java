package CSESAppleDivision;
import java.util.*;
import java.io.*;

public class U2016Febbalancing {
	static BufferedReader in;
	static PrintWriter out;
	
	static int N;
	static int[][] cows;
	
	static int M;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("balancing.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		
		N = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		cows = new int[N][2];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.MAX_VALUE;
		
		in.close();
	}
	
	public static void solve() {
		Arrays.sort(cows, new Comparator<int[]>(){
			public int compare(int[] a, int []b) {
				return a[0] - b[0];
			}
		});
		
		for(int i = 0;i<N;i++) {
			int aboveCount = 0;
			int belowCount = 0;
			for(int j = 0;j<N;j++) {
				if(cows[j][1] <= cows[i][1]) belowCount++;
				else aboveCount++;
			}
			
			int leftAbove = 0;
		}
		
				
	}
	
	public static void output() {
		out.println(M);
		out.close();
	}
	
	public static int search(int a, int b) {
		int q1 = 0, q2 = 0, q3 = 0, q4 = 0;
		for(int i = 0;i<N;i++) {
			if(cows[i][0] > a && cows[i][1] > b) q1++;
			else if(cows[i][0] > a && cows[i][1] < b) q2++;
			else if(cows[i][0] < a && cows[i][1] < b) q3++;
			else if(cows[i][0] < a && cows[i][1] > b) q4++;
		}
		return Math.max(Math.max(q1, q2), Math.max(q3, q4));
	}
}
