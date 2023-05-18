import java.io.*;
import java.util.*;

public class U2021Febyearofthecow {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[][] lines = new String[n][];
		for(int i =0;i<n;i++) {
			lines[i] = in.readLine().split(" ");
		}
		in.close();
		
		HashMap<String, Integer> yearBorn = new HashMap<String, Integer>();
		yearBorn.put("Bessie", 0);
		
		for(int i = 0;i<n;i++) {
			String cow = lines[i][0];
			String relative = lines[i][3];
			String relativeYear = lines[i][4];
			String relativeCow = lines[i][lines[i].length-1];
			
			
		}
		
		
	}
	
	public static int getRelativeDistance(String year1, String year2, String relative) {
		if(relative.eq)
	}
}
