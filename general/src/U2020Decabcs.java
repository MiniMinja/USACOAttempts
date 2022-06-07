import java.util.*;
public class U2020Decabcs {
	
	static Scanner in;
	
	static int[] data;
	
	static StringBuilder output;
	
	public static void main(String[] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		
		data = new int[7];
		for(int i = 0;i<7;i++) {
			data[i] = in.nextInt();
		}
		
		output = new StringBuilder();
	}
	
	public static void solve() {
		Arrays.sort(data);
		int a = data[0];
		int b = data[1];
		int c = data[data.length - 1] - a - b;
		
		output.append(a).append(" ");
		output.append(b).append(" ");
		output.append(c);
	}
	
	public static void output() {
		System.out.println(output);
	}
}
