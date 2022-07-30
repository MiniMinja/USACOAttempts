import java.util.*;
public class CSESCreatingStrings {
	static Scanner in;
	
	static String generate;
	
	static int[] charCount;
	
	static ArrayList<Character> permutation;
	
	static int count;
	
	
	static StringBuilder output;
	
	public static void main(String[] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		
		generate = in.nextLine();
		charCount = new int[26];
		for(int i = 0;i<generate.length();i++) {
			charCount[generate.charAt(i) - 'a']++;
		}
		
		permutation = new ArrayList<Character>();
		
		count = 0;
		output = new StringBuilder();
	}
	
	public static void solve() {
		char[] gen = generate.toCharArray();
		Arrays.sort(gen);
		generate = new String(gen);
		permutation(0);
	}
	
	public static void output() {
		System.out.println(count);
		System.out.print(output);
	}
	
	public static void permutation(int k) {
		if(k == generate.length()) {
			for(char c: permutation) {
				output.append(c);
			}
			output.append('\n');
			count++;
		}
		else {
			for(int i = 0;i<charCount.length;i++) {
				if(charCount[i] > 0) {
					permutation.add((char)(i + 'a'));
					charCount[i]--;
					permutation(k + 1);
					permutation.remove(permutation.size() - 1);
					charCount[i]++;
				}
			}
		}
	}
}
