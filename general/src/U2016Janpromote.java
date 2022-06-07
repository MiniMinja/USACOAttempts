import java.io.*;
import java.util.*;

public class U2016Janpromote {
	static BufferedReader in;
	static PrintWriter out;
	
	static int[] oldDivisions;
	static int[] newDivisions;
	
	static StringBuilder output;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("promote.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
		
		oldDivisions = new int[4];
		newDivisions = new int[4];
		
		for(int i = 0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			oldDivisions[i] = Integer.parseInt(st.nextToken());
			newDivisions[i] = Integer.parseInt(st.nextToken());
		}
		
		output = new StringBuilder();
		
		in.close();
	}
	
	public static void solve() {
		int pp = newDivisions[3] - oldDivisions[3];
		int gp = newDivisions[2] - oldDivisions[2] + pp;
		int sp = newDivisions[1] - oldDivisions[1] + gp;
		
		output.append(pp).append("\n");
		output.append(gp).append("\n");
		output.append(sp).append("\n");
	}
	
	public static void output() {
		out.print(output.toString());
		out.close();
	}
}
