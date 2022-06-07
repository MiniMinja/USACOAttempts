import java.io.*;
import java.util.*;

public class U2016Janpromote {
	static BufferedReader in;
	static PrintWriter out;
	
	static int p1, p2, g1, g2, s1, s2, b1, b2;
	
	static StringBuilder output;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("promote.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
		
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		b1 = Integer.parseInt(st.nextToken());
		b2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		s1 = Integer.parseInt(st.nextToken());
		s2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		g1 = Integer.parseInt(st.nextToken());
		g2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		output = new StringBuilder();
		
		in.close();
	}
	
	public static void solve() {
		int pp = p2 - p1;
		int gp = g2 - g1 + pp;
		int sp = s2 - s1 + gp;
		
		output.append(sp).append("\n");
		output.append(gp).append("\n");
		output.append(pp).append("\n");
	}
	
	public static void output() {
		out.print(output.toString());
		out.close();
	}
}
