import java.util.*;
import java.io.*;
public class U2015bcount {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("bcount.in"));
		String[] nq = in.readLine().split(" ");
		int n = Integer.parseInt(nq[0]);
		int q = Integer.parseInt(nq[1]);
		int[][] prefix3 = new int[n][3];
		for(int i = 0;i<n;i++) {
			if(i > 0) {
				prefix3[i][0] = prefix3[i-1][0];
				prefix3[i][1] = prefix3[i-1][1];
				prefix3[i][2] = prefix3[i-1][2];
			}
			int cow = Integer.parseInt(in.readLine());
			prefix3[i][cow-1]++;
		}
		int[][] outputs = new int[q][3];
		for(int i = 0;i<q;i++) {
			String[] ab = in.readLine().split(" ");
			int a = Integer.parseInt(ab[0])-1;
			int b = Integer.parseInt(ab[1])-1;
			if(a > 0) {
				outputs[i][0] = prefix3[b][0] - prefix3[a-1][0];
				outputs[i][1] = prefix3[b][1] - prefix3[a-1][1];
				outputs[i][2] = prefix3[b][2] - prefix3[a-1][2];
			}
			else{
				outputs[i][0] = prefix3[b][0];
				outputs[i][1] = prefix3[b][1];
				outputs[i][2] = prefix3[b][2];
			}
		}
		in.close();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		for(int i = 0;i<outputs.length;i++) {
			out.println(outputs[i][0] + " " + outputs[i][1] + " " + outputs[i][2]);
		}
		out.close();
	}
}
