import java.util.*;
import java.io.*;

public class CF1555BTwoTables {
	static Scanner in;
	
	static int t;
	static int W, H;
	static int x1, y1, x2, y2;
	static int w1, h1;
	static int w, h;
	
	static double output;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		t = in.nextInt();
		while(t-- > 0) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		
		W = in.nextInt();
		H = in.nextInt();
		x1 = in.nextInt();
		y1 = in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		w = in.nextInt();
		h = in.nextInt();
		
	}
	
	public static void solve() {
		
		Rect room = new Rect(W, H);
		Rect t1 = new Rect(x2-x1, y2-y1);
		Rect t2 = new Rect(w, h);
		
		if(t1.w + t2.w > room.w && t1.h + t2.h > room.h) {
			output = -1;
			return;
		}
		
		int min = Integer.MAX_VALUE;
		
		if(t1.w + t2.w <= W) {
			int leftgap = x1;
			int rightgap = W - x2;
			min = Math.min(t2.w-leftgap, t2.w-rightgap);
		}
		
		if(t1.h + t2.h <= H) {
			min = Math.min(min, t2.h - y1);
			min = Math.min(min, t2.h - (H - y2));
		}
		
		if(min < 0) output = 0;
		else output = min;
	}
	
	public static void output() {
		System.out.println(output);
	}
	
	public static int intersect(int a, int b, int c, int d) {
		return Math.max(Math.min(b, d) - Math.max(a, c), 0);
	}
	
	static class Rect{
		int w, h;
		
		Rect(int w, int h){
			this.w = w;
			this.h = h;
		}
	}
}


