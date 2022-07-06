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
			int min = -1;
			for(int j:cds[i].a) {
				if(j > min) {
					min = j;
				}
			}
			
			int lwv = 100_001;
			for(int j = min;j<=100_000;j++) {
				if(search(cds[i], j)) {
					lwv = j;
					break;
				}
			}
			
			//find the number of changes it takes to meet this value
			int changes = 0;
			int groupSum = 0;
			for(int j = 0;j<cds[i].N;j++) {
				if(cds[i].a[j] + groupSum == lwv) {
					groupSum = 0;
				}
				else {
					groupSum += cds[i].a[j];
					changes++;
				}
			}
			output[i] = changes;
		}
	}
	
	public static void output() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<T;i++) {
			sb.append(output[i]).append("\n");
		}
		System.out.println(sb.toString().substring(0, sb.length() - 1));
	}
	
	public static boolean search(ClassData cd, int checkVal) {
		int groupSum = 0;
		for(int i = 0;i<cd.N;i++) {
			if(cd.a[i] + groupSum > checkVal) {
				return false;
			}
			else if(cd.a[i] + groupSum == checkVal) {
				groupSum = 0;
			}
			else {
				groupSum += cd.a[i];
			}
		}
		return groupSum == 0;
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