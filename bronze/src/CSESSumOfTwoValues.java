import java.util.*;
import java.io.*;
public class CSESSumOfTwoValues {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		String[] values = in.readLine().split(" ");
		HashMap<Integer, Integer> checkedVals = new HashMap<Integer, Integer>();
		boolean found = false;
		for(int i = 0;i<values.length;i++) {
			int value = Integer.parseInt(values[i]);
			if(checkedVals.containsKey(x-value)) {
				System.out.println(checkedVals.get(x-value) + " " + (i+1));
				found = true;
				break;
			}
			else {
				checkedVals.put(value, i+1);
			}
		}
		if(!found) {
			System.out.println("IMPOSSIBLE");
		}
		in.close();
	}
}
