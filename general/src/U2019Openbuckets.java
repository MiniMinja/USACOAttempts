import java.util.*;
import java.io.*;

public class U2019Openbuckets {
	/*
	 * error case: L, B, R are all in the same row/col
	 * 
	 */
	static BufferedReader in;
	static PrintWriter out;
	
	static char[][] grid;
	
	static int shortestPath;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("buckets.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
		
		grid = new char[10][];
		for(int i = 0;i<10;i++) {
			grid[i] = in.readLine().toCharArray();
		}
		
		in.close();
	}
	
	public static void solve() {
		int br = -1, bc = -1, lr = -1, lc = -1, rr = -1, rc = -1;
		for(int i = 0;i<10;i++) {
			for(int j = 0;j<10;j++) {
				if(grid[i][j] == 'B') {
					br = i;
					bc = j;
				}
				if(grid[i][j] == 'R') {
					rr = i;
					rc = j;
				}
				if(grid[i][j] == 'L') {
					lr = i;
					lc = j;
				}
			}
		}
		
		int pathLength = Math.abs(lr - br) + Math.abs(lc - bc) - 1;
		
		if((br == lr && rr == lr && (bc < rc && rc < lc || lc < rc && rc < bc)) ||
			(bc == lc && rc == lc && (br < rr && rr < lr || lr < rr && rr < br))) {
			pathLength += 2;
		}
		
		shortestPath = pathLength;
	}
	
	public static void output() {
		out.println(shortestPath);
		out.close();
	}
}
