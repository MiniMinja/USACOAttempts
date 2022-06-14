import java.util.*;
import java.io.*;

public class CF1555BTwoTables {
	static Scanner in;
	
	static int t;
	static int W, H;
	static int x1, y1, x2, y2;
	static int w1, h1;
	static int w2, h2;
	
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
		w1 = x2 - x1;
		h1 = y2 - y1;
		w2 = in.nextInt();
		h2 = in.nextInt();
		
	}
	
	public static void solve() {
		
		/*
		Rect room = new Rect(W, H);
		Rect t1 = new Rect(x2-x1, y2-y1);
		Rect t2 = new Rect(w, h);
		*/
		
		if(w1 + w2 > W && h1 + h2 > H) {
			output = -1;
			return;
		}
		
		int min = Integer.MAX_VALUE;
		
		if(w1 + w2 <= W) {
			int leftgap = x1;
			int rightgap = W - x2;
			min = Math.min(w2-leftgap, w2-rightgap);
		}
		
		if(h1 + h2 <= H) {
			min = Math.min(min, h2 - y1);
			min = Math.min(min, h2 - (H - y2));
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


