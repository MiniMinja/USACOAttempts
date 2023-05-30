import java.util.*;
import java.io.*;
public class U2016div7 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("div7.in"));
		int n = Integer.parseInt(in.readLine());
		int[] prefMinIndexes = new int[7];
		int[] prefMaxIndexes = new int[7];
		Arrays.fill(prefMinIndexes, Integer.MAX_VALUE);
		prefMinIndexes[0] = 0;
		long currSum = 0;
		for(int i = 1;i<=n;i++) {
			currSum += Integer.parseInt(in.readLine());
			int index = (int)(currSum % 7);
			prefMinIndexes[index] = Math.min(prefMinIndexes[index], i);
			prefMaxIndexes[index] = i;
		}
		in.close();
		int maxDiff = 0;
		for(int i = 0;i<7;i++) {
			if(prefMinIndexes[i] <= n) {
				int diff = prefMaxIndexes[i] - prefMinIndexes[i];
				if(diff > maxDiff) maxDiff = diff;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		out.println(maxDiff);
		out.close();
	}
}
