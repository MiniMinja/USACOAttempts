import java.util.*;

public class CF863BKayaking {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int[] weights = new int[2*n];
		for(int i = 0;i<2*n;i++) {
			weights[i] = in.nextInt();
		}
		
		Arrays.sort(weights);
		
		int minInstability = Integer.MAX_VALUE;
		for(int s1 = 0;s1<weights.length-1;s1++) {
			for(int s2 = s1 + 1;s2<weights.length;s2++) {
				int inst = instability(weights, s1, s2);
				if(inst < minInstability) {
					minInstability = inst;
				}
			}
		}
		System.out.println(minInstability);
	}
	
	public static int instability(int[] weights, int s1, int s2) {
		int index = 0;
		int t = 0;
		while(index < weights.length-1) {
			if(index == s1 || index == s2) {
				index++;
			}
			else {
				int w1 = weights[index];
				int w2;
				if(index+1 == s1 || index+1 == s2) {
					w2 = weights[index+2];
					index += 3;
				}
				else {
					w2 = weights[index+1];
					index += 2;
				}
				t += w2 - w1;
			}
		}
		return t;
	}
}
