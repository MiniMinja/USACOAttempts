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

	static PrintWriter output1;
	static PrintWriter output2;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("generated_cases.in"));
		output1 = new PrintWriter(new BufferedWriter(new FileWriter("gap_out.txt")));
		output2 = new PrintWriter(new BufferedWriter(new FileWriter("intersect_out.txt")));
		t = in.nextInt();
		while(t-- > 0) {
			init();
			gap_sol();
			output1();

			intersect_sol();
			output2();
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
	
	public static void gap_sol() {
		
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

	public static void intersect_sol(){
		//-1 case
		if((x2 - x1) + w > W && (y2 - y1) + h > H) {
			output = -1;
		}
		else { //in this part of the solution, the second table does fit
			
			if((x2 - x1) + w <= W) {// only if the second table fits in the horizontal direction
				int leftIntersect = Math.min(x2, w) - Math.max(x1, 0);
				if(leftIntersect < 0 ) leftIntersect = 0;
				
				int rightIntersect = Math.min(x2, W) - Math.max(x1, W-w);
				if(rightIntersect< 0) rightIntersect = 0;
				
				//System.out.println("Horizontal: ");
				//System.out.println(leftIntersect + " " + rightIntersect);
				
				output = Math.min(leftIntersect, rightIntersect);
			}
			
			if((y2 - y1) + h <= H) {// only if the second table fits in the vertical direction
				int botIntersect = Math.min(y2, h) - Math.max(y1, 0);
				if(botIntersect < 0 ) botIntersect = 0;
				
				int topIntersect = Math.min(y2, H) - Math.max(y1, H-h);
				if(topIntersect< 0) topIntersect = 0;
				
				//System.out.println("Vertical");
				//System.out.println(botIntersect + " " + topIntersect);
				
				output = Math.min(output, Math.min(botIntersect, topIntersect));
			}
		}
	}
	
	public static void output1() {
		output1.println(output);
	}

	public static void output2(){
		output2.println(output);
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


