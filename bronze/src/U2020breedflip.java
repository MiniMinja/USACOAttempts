import java.util.*;
import java.io.*;
public class U2020breedflip {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("breedflip.in"));
		int n = Integer.parseInt(in.readLine());
		String a = in.readLine();
		String b = in.readLine();
		in.close();
		
		boolean diffPrev = false;
		int diffC = 0;
		for(int i = 0;i<n;i++) {
			if(a.charAt(i) != b.charAt(i)) {
				if(!diffPrev) {
					diffC++;
				}
				diffPrev = true;
			}
			else {
				diffPrev = false;
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		out.println(diffC);
		out.close();
	}
}
