import java.util.*;
import java.io.*;

public class U2020Janword {
	
	static BufferedReader in;
	static PrintWriter out;
	
	static int N, K;
	static String[] essay;
	
	static StringBuilder output;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("word.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		essay = in.readLine().split(" ");
		
		output = new StringBuilder();
		
		in.close();
	}
	
	public static void solve() {
		int currentLineSize = 0;
		for(int i = 0;i<essay.length;i++) {
			if(essay[i].length() + currentLineSize > K) {
				output.append("\n");
				currentLineSize = 0;
			}
			
			if(currentLineSize != 0) output.append(" ");
			output.append(essay[i]);
			currentLineSize += essay[i].length();
		}
	}
	
	public static void output() {
		out.println(output);
		out.close();
	}
}
