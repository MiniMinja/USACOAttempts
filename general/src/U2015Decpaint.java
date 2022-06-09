import java.util.*;
import java.io.*;

public class U2015Decpaint {
	static BufferedReader in;
	static PrintWriter out;
	
	static int a, b, c, d;
	 
	static int totalPainted;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("paint.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		in.close();
	}
	
	/* Solution 1
	public static void solve() {
		int[] fences = new int[101];
		for(int i = a;i<b;i++) {
			fences[i] = 1;
		}
		for(int i = c;i<d;i++) {
			fences[i] = 1;
		}
		
		totalPainted = 0;
		for(int i = 0;i<100;i++) {
			if(fences[i] == 1)
				totalPainted++;
		}
	}
	*/
	
	public static void solve() {
		int intersect = Math.min(b, d) - Math.max(a, c);
		if(intersect < 0 ) intersect = 0;
		
		totalPainted = b - a + d - c - intersect;
	}
	
	public static void output() {
		out.println(totalPainted);
		out.close();
	}
}
