import java.util.*;
import java.io.*;
public class U2019Declineup {
	public static final String[] cows = {
			"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"
	};
	
	public static class Pair{
		int cow1, cow2;
		public Pair(int cow1, int cow2) {
			this.cow1 = cow1;
			this.cow2 = cow2;
		}
		
		public Pair(String c1, String c2) {
			for(int i = 0;i<cows.length;i++) {
				if(cows[i].equals(c1)) cow1 = i;
				if(cows[i].equals(c2)) cow2 = i;
			}
		}
	}
	
	static BufferedReader in;
	static PrintWriter out;
	
	static int n;
	static Pair[] pairs;
	
	static ArrayList<Integer> permutation;
	static boolean[] taken;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("lineup.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		
		n = Integer.parseInt(in.readLine());
		pairs = new Pair[n];
		for(int i = 0;i<n;i++) {
			String[] pair_str = in.readLine().split(" must be milked beside ");
			pairs[i] = new Pair(pair_str[0], pair_str[1]);
		}
		
		permutation = new ArrayList<Integer>();
		taken = new boolean[cows.length];
		
		in.close();
	}
	
	public static void solve() {
		permutation(0);
	}
	
	public static void output() {
		StringBuilder sb = new StringBuilder();
		for(int i: permutation) {
			if(sb.length() > 0) sb.append("\n");
			sb.append(cows[i]);
		}
		out.println(sb);
		out.close();
	}
	
	public static boolean permutation(int k) {
		if(k == cows.length) {
			int conditionsMet = 0;
			for(Pair p: pairs) {
				for(int i = 0;i<permutation.size()- 1;i++) {
					if(p.cow1 == permutation.get(i) && p.cow2 == permutation.get(i+1)) {
						conditionsMet++;
					}
					else if(p.cow1 == permutation.get(i + 1) && p.cow2 == permutation.get(i)) {
						conditionsMet++;
					}
				}
			}
			if(conditionsMet == pairs.length) {
				return true;
			}
		}
		else {
			for(int i = 0;i<cows.length;i++) {
				if(!taken[i]) {
					permutation.add(i);
					taken[i] = true;
					if(permutation(k + 1)) return true;
					else {
						permutation.remove(permutation.size()-1);
						taken[i] = false;
					}
				}
			}
		}
		return false;
	}
}

