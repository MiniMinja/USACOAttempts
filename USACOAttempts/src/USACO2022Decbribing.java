import java.util.*;

public class USACO2022Decbribing {
	static Scanner in;

	static int moonies, icecream;
	
	static Score[] scores;
	
	static int totalPP;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
		output();
	}
	
	public static void init() {
		int N = in.nextInt();
		
		moonies = in.nextInt();
		icecream = in.nextInt();
		
		scores = new Score[N];
		for(int i = 0;i<N;i++) {
			scores[i] = new Score(in.nextInt(),in.nextInt(),in.nextInt());
		}
	}
	
	public static void solve() {
		Arrays.sort(scores, new Comparator<Score>() {
			public int compare(Score a, Score b) {
				if(a.discount_cost < b.discount_cost) {
					return -1;
				}
				else if(a.discount_cost == b.discount_cost) {
					if(a.popPerBuck < b.popPerBuck) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else {
					return 1;
				}
			}
		});
		for(int i = 0;i<scores.length;i++) {
			int discountAmount = icecream / scores[i].discount_cost;
			int actualDiscountedAmount = Math.min(discountAmount, scores[i].cost);
			scores[i].cost -= actualDiscountedAmount;
			icecream -= actualDiscountedAmount * scores[i].discount_cost;
		}
		
		Arrays.sort(scores);
		/*
		for(Score s: scores) {
			System.out.println(s);
		}
		*/
		
		totalPP = 0;
		for(int i = 0;i<scores.length;i++) {
			if(moonies >= scores[i].cost) {
				moonies -= scores[i].cost;
				totalPP += scores[i].popularity;
			}
		}
	}
	
	public static void output() {
		System.out.println(totalPP);
	}
	
	static class Score implements Comparable<Score>{
		int popularity, cost, discount_cost;
		
		double popPerBuck;
		
		boolean discounted;
		
		public Score(int p, int c, int d) {
			popularity = p;
			cost = c;
			discount_cost = d;
			
			popPerBuck = (double)popularity / cost;
		}
		
		public int compareTo(Score other) {
			if(popPerBuck < other.popPerBuck) {
				return 1;
			}
			else {
				return -1;
			}
		}
		
		public String toString() {
			return "" + popularity + " " + cost + " " + discount_cost
					+ " | ppb: " + popPerBuck;
		}
	}
}
