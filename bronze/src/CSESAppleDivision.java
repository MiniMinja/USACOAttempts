import java.util.*;
public class CSESAppleDivision {
	static Scanner in;

	static int n;
	static int[] p;
	
	static HashSet<Integer> subset;
	
	static long minDiff;
	
	public static void main(String[] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		
		n = in.nextInt();
		p = new int[n];
		for(int i = 0;i<n;i++) {
			p[i] = in.nextInt();
		}
		
		subset = new HashSet<Integer>();
		
		minDiff = Integer.MAX_VALUE;
	}
	
	public static void solve() {
		search(0);
	}
	
	public static void output() {
		System.out.println(minDiff);
	}
	
	public static void search(int k) {
		if(k == n) {
			//System.out.println(subset);
			long w1 = 0;
			long w2 = 0;
			for(int i = 0;i<n;i++) {
				if(subset.contains(i)) {
					w1 += p[i];
				}
				else {
					w2 += p[i];
				}
			}
			
			long diff = Math.abs(w1 - w2);
			if (diff < minDiff) {
				minDiff = diff;
			}
		}
		else {
			search(k + 1);
			subset.add(k);
			search(k + 1);
			subset.remove(k);
		}
	}
}
