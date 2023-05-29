import java.util.*;

public class CSES1621DistinctNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for(int i = 0;i<n;i++) {
			nums[i] = in.nextInt();
		}
		
		Arrays.sort(nums);
		
		int count = 1;
		for(int i = 0;i<nums.length-1;i++) {
			if(nums[i] != nums[i+1]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
