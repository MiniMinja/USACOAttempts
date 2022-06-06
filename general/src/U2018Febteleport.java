
import java.util.*;
import java.io.*;

public class U2018Febteleport {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a, b, x, y;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int straightDistance = Math.abs(a - b);
		int teleportDistance1 = Math.abs(a - x) + Math.abs(y - b);
		int teleportDistance2 = Math.abs(a - y) + Math.abs(x - b);
		
		int output = Math.min(straightDistance, Math.min(teleportDistance1, teleportDistance2));
		
		out.println(output);
		
		in.close();
		out.close();
	}
}
