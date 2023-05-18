import java.util.*;
import java.io.*;

public class U2019Declineup {
	static String[] cows;
	
	public static void main(String[] args) throws IOException{
		cows = "Bessie Buttercup Belinda Beatrice Bella Blue Betsy Sue".split(" ");
		Arrays.sort(cows);
		
		Scanner in = new Scanner(new File("lineup.in"));
		int n = Integer.parseInt(in.nextLine());
		String[][] conditions = new String[n][];
		for(int i = 0;i<n;i++) {
			String[] pair = in.nextLine().split(" must be milked beside ");
			conditions[i] = pair;
		}
		in.close();
		
		String[] order = permute(new String[cows.length], 0, conditions);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		for(int i = 0;i<order.length;i++) {
			out.println(order[i]);
		}
		out.close();
	}
	
	public static String[] permute(String[] currOrder, int k, String[][] conditions) {
		if(k == cows.length) {
			//check
			for(String[] condition: conditions) { // "for each condition in conditions"
				if(!checkCondition(currOrder, condition)) {
					return null;
				}
			}
			return currOrder;
		}
		else {
			for(int i = 0;i<cows.length;i++) {
				if(cows[i] != null) { // if available
					currOrder[k] = cows[i];
					cows[i] = null;
					
					if(permute(currOrder, k+1, conditions) != null) {
						return currOrder;
					}
					
					cows[i] = currOrder[k];
					currOrder[k] = null;
				}
			}
			return null;
		}
	}
	
	public static boolean checkCondition(String[] currOrder, String[] condition) {
		for(int i = 0;i<currOrder.length;i++) {
			if(i > 0 && currOrder[i].equals(condition[0]) && currOrder[i-1].equals(condition[1])) {
				return true;
			}
			if(i < currOrder.length-1 && currOrder[i].equals(condition[0]) && currOrder[i+1].equals(condition[1])) {
				return true;
			}
		}
		return false;
	}
}

