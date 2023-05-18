import java.util.*;
import java.io.*;

public class U2018Decmixmilk {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("mixmilk.in"));
		int c1, m1, c2, m2, c3, m3;
		c1 = in.nextInt();
		m1 = in.nextInt();
		c2 = in.nextInt();
		m2 = in.nextInt();
		c3 = in.nextInt();
		m3 = in.nextInt();
		in.close();
		
		for(int i = 0;i<33;i++) {
			int amount = Math.min(m1, c2-m2);
			m1-=amount;
			m2+=amount;
			
			amount = Math.min(m2, c3-m3);
			m2-=amount;
			m3+=amount;
			
			amount = Math.min(m3, c1-m1);
			m3-=amount;
			m1+=amount;
		}
		int amount = Math.min(m1, c2-m2);
		m1-=amount;
		m2+=amount;
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		out.println(m1);
		out.println(m2);
		out.println(m3);
		out.close();
	}
}
