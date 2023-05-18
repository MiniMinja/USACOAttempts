import java.io.*;
import java.util.*;
public class CCC08s4twentyfour {
	static Scanner in;
	
	//static PrintWriter out;
	
	static int N;
	
	static int[][] hands;
	
	static ArrayList<int[]> handPossibility;
	static int[] possibility;
	static boolean[] taken;
	
	static int[][] expressionStack;
	
	static int[] maxVals;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		init();
		solve();
		output();
	}
	
	public static void init() {
		N = in.nextInt();
		
		hands = new int[N][4];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<4;j++) {
				hands[i][j] = in.nextInt();
			}
		}
		
		maxVals = new int[N];
		for(int i = 0;i<N;i++) {
			maxVals[i] = -1;
		}
		
		handPossibility = new ArrayList<int[]>();
		possibility = new int[4];
		taken = new boolean[4];
		
		expressionStack = new int[4][];
		for(int i = 0;i<4;i++) {
			expressionStack[i] = new int[4-i];
		}
		//try {
		//	out = new PrintWriter(new BufferedWriter(new FileWriter("error.txt")));
		//} catch (IOException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	}
	
	public static void solve() {
		
		for(int i = 0;i<N;i++) {
			handPossibility.clear();
			genHandPerm(0, i);
			//for(int[] perm: handPossibility) {
			//	out.println(Arrays.toString(perm));
			//}
			//out.println();
			
			for(int k = 0;k<handPossibility.size();k++) {
				for(int j = 0;j<4;j++) {
					expressionStack[0][j] = handPossibility.get(k)[j];
					
				}
				search(0, i);
			}
		}
	}
	
	public static void output() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			sb.append(maxVals[i]).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		
		//out.close();
	}
	
	public static void search(int k, int handIndex) {
		if(k == 3) {
			//for(int[] expr: expressionStack) {
			//	out.println(Arrays.toString(expr));
			//}
			//out.println();
			if(expressionStack[3][0] >= maxVals[handIndex] && expressionStack[3][0] <= 24) {
				maxVals[handIndex] = expressionStack[3][0];
			}
		}
		else {
			int[] expr = expressionStack[k];
			
			int[] nextExpr = expressionStack[k + 1];
			
			for(int i = 0;i<expr.length - 1;i++) {
				int num1 = expr[i];
				int num2 = expr[i + 1];
				
				for(int j = 0;j<i;j++) nextExpr[j] = expr[j];
				for(int j = i + 2;j<expr.length;j++) nextExpr[j-1] = expr[j];
				
				//add 
				nextExpr[i] = num1 + num2;
				search(k + 1, handIndex);
				
				//sub
				nextExpr[i] = num1 - num2;
				search(k + 1, handIndex);
				
				//mult
				nextExpr[i] = num1 * num2;
				search(k + 1, handIndex);
				
				//div
				if(num2 != 0 && num1 % num2 == 0) {
					nextExpr[i] = num1 / num2;
					search(k + 1, handIndex);
				}
			}
		}
	}
	
	public static void genHandPerm(int k, int handIndex) {
		if(k == 4) {
			int[] permutationCopy = new int[4];
			for(int i = 0;i<4;i++) permutationCopy[i] = possibility[i];
			handPossibility.add(permutationCopy);
		}
		else {
			for(int i = 0;i<4;i++) {
				if(!taken[i]) {
					possibility[k] = hands[handIndex][i];
					taken[i] = true;
					genHandPerm(k + 1, handIndex);
					taken[i] = false;
				}
			}
		}
	}
}
/*
16
16
24
22
24
*/