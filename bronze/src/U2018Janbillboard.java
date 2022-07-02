import java.util.*;
import java.io.*;
public class U2018Janbillboard {
	static class Rect{
		int x1, y1, x2, y2;
		
		public Rect(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	static BufferedReader in;
	static PrintWriter out;
	
	static Rect l, f;
	
	static int area;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("billboard.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		l = new Rect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(in.readLine());
		f = new Rect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		area = 0;
		
		in.close();
	}
	
	public static void solve() {
		int[][] view = new int[2001][2001];
		
		for(int i = l.y1;i<l.y2;i++) {
			for(int j = l.x1;j<l.x2;j++) {
				view[i + 1000][j + 1000] = 1;
			}
		}
		
		for(int i = f.y1;i<f.y2;i++) {
			for(int j = f.x1;j<f.x2;j++) {
				view[i + 1000][j + 1000] = 0;
			}
		}
		
		boolean foundLawnmower = false;
		int minX1 = 2001, minY1 = 2001, maxX2 = -1, maxY2 = -1;
		for(int i = 0;i<2001;i++) {
			for(int j = 0;j<2001;j++) {
				if(view[i][j] == 1) {
					foundLawnmower = true;
					if(j < minX1) {
						minX1 = j;
					}
					if(j + 1 > maxX2) {
						maxX2 = j + 1;
					}
					if(i < minY1) {
						minY1 = i;
					}
					if(i + 1 > maxY2) {
						maxY2 = i + 1;
					}
				}
			}
		}
		//System.out.println(minX1 + " " + minY1 + " " + maxX2 + " " + maxY2);
		if(foundLawnmower) {
			area = (maxX2 - minX1) * (maxY2 - minY1);
		}
	}
	
	public static void output() {
		out.println(area);
		out.close();
	}
}


