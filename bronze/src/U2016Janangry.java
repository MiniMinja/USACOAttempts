import java.io.*;
import java.util.*;

public class U2016Janangry {
	public static class Haybale{
		int x;
		boolean detonated;
		
		public Haybale(int x) {
			this.x = x;
		}
		
		public void detonate() { detonated = true;}
		public void reset() {detonated = false;}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Haybale> haybales = new ArrayList<Haybale>();
		for(int i = 0;i<n;i++) {
			int d = Integer.parseInt(br.readLine());
			haybales.add( new Haybale(d) );
		}
		
		int maxScore = 0;
		for(Haybale h: haybales) {
			h.detonate();
			int score = detonate(h, haybales, 1);
			for(Haybale h2: haybales){
				h2.reset();
			}
			if(score > maxScore) {
				maxScore = score;
			}
		}
		System.out.println(maxScore);
		pw.println(maxScore);
		
		br.close();
		pw.close();
	}
	
	public static int detonate(Haybale h, ArrayList<Haybale> haybales, int radius) {
		int score = 1;
		ArrayList<Haybale> toDetonate = new ArrayList<Haybale>();
		for(Haybale other: haybales) {
			if(!other.detonated) {
				int distance = Math.abs(h.x - other.x);
				if(distance <= radius) {
					other.detonate();
					toDetonate.add(other);
				}
			}
		}
		for(Haybale td: toDetonate){
			score += detonate(td, haybales, radius+1);
		}
		return score;
	}
}
