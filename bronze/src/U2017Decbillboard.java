import java.util.*;
import java.io.*;

public class U2017Decbillboard {
	static BufferedReader in;
	static PrintWriter out;
	
	static int[] b1_data;
	static int[] b2_data;
	static int[] t_data;
	
	static int exposedArea;
	

	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("billboard.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		b1_data = new int[4];
		b2_data = new int[4];
		t_data = new int[4];
		
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0;i<4;i++) {
			b1_data[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i = 0;i<4;i++) {
			b2_data[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for(int i = 0;i<4;i++) {
			t_data[i] = Integer.parseInt(st.nextToken());
		}
		
		in.close();
	}
	
	/* Solution 1
	public static void solve() {
		int[][] grid = new int[2001][2001];
		
		for(int i = b1_data[1];i<b1_data[3];i++) {
			for(int j = b1_data[0];j<b1_data[2];j++) {
				grid[i + 1000][j + 1000] = 1;
			}
		}
		
		for(int i = b2_data[1];i<b2_data[3];i++) {
			for(int j = b2_data[0];j<b2_data[2];j++) {
				grid[i + 1000][j + 1000] = 1;
			}
		}
		
		for(int i = t_data[1];i<t_data[3];i++) {
			for(int j = t_data[0];j<t_data[2];j++) {
				grid[i + 1000][j + 1000] = 0;
			}
		}
		
		exposedArea = 0;
		for(int i = 0;i<2001;i++) {
			for(int j = 0;j<2001;j++) {
				if(grid[i][j] == 1) exposedArea++;
			}
		}
	}
	*/
	
	public static void solve() {
		Rect b1, b2, t;
		
		b1 = new Rect(b1_data);
		b2 = new Rect(b2_data);
		t = new Rect(t_data);
		
		exposedArea = b1.area() + b2.area() - Rect.intersect(b1, t) - Rect.intersect(b2, t);
	}
	
	public static void output() {
		out.println(exposedArea);
		out.close();
	}
}

class Rect{
	int x1, y1, x2, y2;
	
	Rect(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	Rect(int[] a){
		this.x1 = a[0];
		this.y1 = a[1];
		this.x2 = a[2];
		this.y2 = a[3];
	}
	
	int area() {
		return (x2 - x1) * (y2 - y1);
	}
	
	static int intersect(Rect a, Rect b) {
		int xOverlap = Math.min(a.x2, b.x2) - Math.max(a.x1, b.x1);
		if(xOverlap < 0) xOverlap = 0;
		int yOverlap = Math.min(a.y2, b.y2) - Math.max(a.y1, b.y1);
		if(yOverlap < 0) yOverlap = 0;
		return xOverlap * yOverlap;
	}
}
