import java.util.*;
public class U2022Openliars {
	public static void main(String[] args) {
		Random r = new Random();
		int N = r.nextInt(100);
		System.out.println(N);
		
		for(int i = 0;i<N;i++) {
			boolean L = r.nextBoolean();
			if(L) {
				System.out.print("L ");
			}
			else {
				System.out.print("G ");
			}
			
			int spot = r.nextInt(100);
			System.out.println(spot);
		}
	}
}
