import java.util.*;
import java.io.*;

public class U2017Febcowqueue {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		int n = Integer.parseInt(br.readLine());
		int[][] times = new int[n][2];
		for(int i = 0;i<n;i++) {
			String[] line = br.readLine().split(" ");
			times[i][0] = Integer.parseInt(line[0]);
			times[i][1] = Integer.parseInt(line[1]);
		}
		Arrays.sort(times, (a, b) ->{
			return a[0]- b[0];
		});
		int nextFreeTime = times[0][0] + times[0][1];
		for(int i = 1;i<n;i++) {
			int nextCowTime = times[i][0];
			int nextCowDuration = times[i][1];
			if(nextCowTime < nextFreeTime) {
				nextFreeTime += nextCowDuration;
			}
			else {
				nextFreeTime = nextCowTime + nextCowDuration;
			}
		}
		pw.println(nextFreeTime);
		br.close();
		pw.close();
	}
}
