package CSESAppleDivision;

import java.util.*;
import java.io.*;

public class Generator {
	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter("testcase.txt"));
		
		Random r = new Random();
		
		int n = 20;
		pw.println(n);
		for(int i = 0;i<n;i++) {
			int num = r.nextInt();
		}
	}
}
