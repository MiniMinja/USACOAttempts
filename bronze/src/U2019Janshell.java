import java.util.*;
import java.io.*;
public class U2019Janshell {
	static BufferedReader in;
	static PrintWriter out;
	
	static int N;
	static int[][] swaps;
	static int[] guesses;
	
	static int maxScore;
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("shell.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		
		N = Integer.parseInt(in.readLine());
		swaps = new int[N][2];
		guesses = new int[N];
		StringTokenizer st;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			swaps[i][0] = Integer.parseInt(st.nextToken());
			swaps[i][1] = Integer.parseInt(st.nextToken());
			guesses[i] = Integer.parseInt(st.nextToken());
		}
		
		maxScore = -1;
		
		in.close();
	}
	
	public static void solve() {
		//3 simulations
		for(int i = 0;i<3;i++) {
			//initialize simulation
			int[] shells = new int[3];
			shells[i] = 1;
			
			//run simulation
			int score = simulate(shells);
			
			//compute results from simulation
			if(score > maxScore) {
				maxScore = score;
			}
		}
		
		
	}
	
	public static void output() {
		out.println(maxScore);
		out.close();
	}
	
	public static int simulate(int[] shells) {
		int score = 0;
		for(int i = 0;i<N;i++) {
			//swap shells
			int i1 = swaps[i][0] - 1;
			int i2 = swaps[i][1] - 1;
			int temp = shells[i1];
			shells[i1] = shells[i2];
			shells[i2] = temp;
			
			//confirm 
			int gi = guesses[i] - 1;
			if(shells[gi] == 1) {
				score++;
			}
		}
		return score;
	}
}
