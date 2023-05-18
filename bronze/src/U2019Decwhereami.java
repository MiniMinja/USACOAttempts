import java.util.*;
import java.io.*;
public class U2019Decwhereami {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("whereami.in"));
		int n = Integer.parseInt(in.readLine());
		String street = in.readLine();
		in.close();
		
		HashSet<String> allSubstrings = new HashSet<String>();
		
		int minK = n;
		for(int k = n-1;k>=1;k--) {
			allSubstrings.clear();
			boolean kFailed = false;
			for(int i = 0;i<=street.length()-k;i++) {
				String substring = street.substring(i, i+k);
				if(allSubstrings.contains(substring)) {
					kFailed = true;
					break;
				}
				else {
					allSubstrings.add(substring);
				}
			}
			if(kFailed) {
				break;
			}
			else {
				minK = k;
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		out.println(minK);
		out.close();
	}
}
