import java.util.*;
import java.io.*;

public class U2021evenoddphotos {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] line = in.readLine().split(" ");
		in.close();
		
		Stack<Integer> odds = new Stack<Integer>();
		Stack<Integer> evens = new Stack<Integer>();
		for(int i = 0;i<line.length;i++) {
			int num = Integer.parseInt(line[i]);
			if(num % 2 == 0) evens.push(num);
			else odds.push(num);
		}
		
		int groups = 0;
		boolean evenMode = true;
		while(true) {
			if(evenMode) {
				if(evens.size() > 0) {
					evens.pop();
				}
				else if(odds.size() >= 2){
					odds.pop();
					odds.pop();
				}
				else if(odds.size() == 1) {
					groups--;
					break;
				}
				else {
					break;
				}
				groups++;
				evenMode = false;
			}
			else {
				if(odds.size() > 0) {
					odds.pop();
				}
				else {
					break;
				}
				groups++;
				evenMode = true;
			}
		}
		
		System.out.println(groups);
	}
}
