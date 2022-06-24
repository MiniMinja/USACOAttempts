import java.util.*;
public class U2022Openliars {
    static Scanner in;

    static int N;
	static char[] LG;
	static int[] loc;
	
	static int minLiars;

	public static void main(String[] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);

		N = in.nextInt();
		LG = new char[N];
		loc = new int[N];

		for(int i = 0;i<N;i++){
			LG[i] = in.next().charAt(0);
			loc[i] = in.nextInt();
		}

		minLiars = Integer.MAX_VALUE;
	}
	
	public static void solve() {
		//generate markpoints to search for
		int[] markPoints = new int[N];
		for(int i = 0;i<N;i++){
			int offset = 1;
			if(LG[i] == 'L'){
				offset = -1;
			}

			markPoints[i] = loc[i] + offset;
		}

		//check each markpoint
		for(int markpoint: markPoints){
			int liars = search(markpoint);
			if(minLiars > liars){
				minLiars = liars;
			}
		}
	}
	
	public static void output() {
		System.out.println(minLiars);
	}

	public static int search(int markpoint){
		//count the number of liars if markpoint was here
		int liars = 0;
		for(int i = 0;i<N;i++){
			if(LG[i] == 'G'){
				if(markpoint <= loc[i]) liars++;
			}
			else{
				if(markpoint >= loc[i]) liars++;
			}
		}
		return liars;
	}
}
