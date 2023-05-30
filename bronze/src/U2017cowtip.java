import java.util.*;
import java.io.*;
public class U2017cowtip {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("cowtip.in"));
		
		int n = Integer.parseInt(in.readLine());
		int[][] board = new int[n][n];
		for(int i = 0;i<n;i++) {
			String line = in.readLine();
			for(int j = 0;j<n;j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		
		in.close();
		
		int count = 0;
		for(int i = n-1;i>=0;i--) {
			for(int j = n-1;j>=0;j--) {
				if(board[i][j] == 1) {
					flippinator3000(board, i, j);
					count++;
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		
		out.println(count);
		
		out.close();
	}
	
	public static void flippinator3000(int[][] board, int row, int col) {
		for(int i = 0;i<=row;i++) {
			for(int j = 0;j<=col;j++) {
				if(board[i][j] == 1) board[i][j] = 0;
				else board[i][j] = 1;
			}
		}
	}
}
