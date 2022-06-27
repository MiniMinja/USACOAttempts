import java.util.*;
public class U2022Opensleeping {
	static Scanner in;
	
	static int T;
	static ClassData[] cds;
	
	static int[] output;
	
	public static void main(String[] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		
		T = in.nextInt();
		cds = new ClassData[T];
		for(int i = 0;i<T;i++) {
			cds[i] = ClassData.getClassData(in);
		}
		
		output = new int[T];
	}
	
	public static void solve() {
		for(int i = 0;i<T;i++) {
			//find minVal that a ClassData could be
			
			//search through the ClassData with the minVal
			output[i] = search(cds[i], minVal);
		}
	}
	
	public static void output() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<T;i++) {
			sb.append(output[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int search(ClassData cd, int minVal) {
		
	}
}

class ClassData{
	int N;
	int[] a;
	
	public static ClassData getClassData(Scanner in) {
		ClassData ret = new ClassData();
		ret.N = in.nextInt();
		ret.a = new int[ret.N];
		for(int i = 0;i<ret.N;i++) {
			ret.a[i] = in.nextInt();
		}
		return ret;
	}
}