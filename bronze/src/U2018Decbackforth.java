import java.util.*;
import java.io.*;

public class U2018Decbackforth {
	static Scanner in;
	static PrintWriter debug;
	static PrintWriter out;
	
	static ArrayList<Integer> barn1;
	static ArrayList<Integer> barn2;
	static HashSet<Integer> measures;
	
	public static void main(String[] args) throws IOException{
		//debug = new PrintWriter(new BufferedWriter(new FileWriter("log.txt")));
		
		in = new Scanner(new File("backforth.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		
		barn1 = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			barn1.add(in.nextInt());
		}
		barn2 = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			barn2.add(in.nextInt());
		}
		
		in.close();
		
		measures = new HashSet<Integer>();
		
		pass1(barn1, barn2, 1000, 0);
		
		out.println(measures.size());
		
		out.close();
	}
	
	public static void pass1(ArrayList<Integer> barn1, ArrayList<Integer> barn2, int milkreading, int k) {
		for(int i = 0;i<barn1.size();i++) {
			int bucket = barn1.get(i);
			if(bucket != -1) {
				barn1.set(i, -1);
				barn2.add(bucket);
				
				milkreading -= bucket;

				//debug.println("k: " + k);
				//debug.println("Transaction:\n \tbarn1= " + barn1 + " barn2= " + barn2);
				//debug.println("\tmilkreading: " + milkreading);
				//debug.println();
				pass2(barn1, barn2, milkreading, k+1);
				
				milkreading += bucket;
				
				barn2.remove(barn2.size()-1);
				barn1.set(i, bucket);
			}
		}
	}
	
	public static void pass2(ArrayList<Integer> barn1, ArrayList<Integer> barn2, int milkreading, int k) {
		
		for(int i = 0;i<barn2.size();i++) {
			int bucket = barn2.get(i);
			if(bucket != -1) {
				barn2.set(i, -1);
				barn1.add(bucket);
				
				milkreading += bucket;

				//debug.println("k: " + k);
				//debug.println("Transaction:\n \tbarn1= " + barn1 + " barn2= " + barn2);
				//debug.println("\tmilkreading: " + milkreading);
				//debug.println();
				if(k < 3) {
					pass1(barn1, barn2, milkreading, k+1);
				}
				else {
					measures.add(milkreading);
				}
				
				milkreading -= bucket;
				
				barn1.remove(barn1.size()-1);
				barn2.set(i, bucket);
				
			}
		}
	}
}
