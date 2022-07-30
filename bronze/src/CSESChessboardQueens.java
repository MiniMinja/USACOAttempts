import java.util.*;
public class CSESChessboardQueens {
	static Scanner in;
	
	static int[][] board;
	static int[] cols;
	static int[] diag1;
	static int[] diag2;
	
	static int count;
	
	public static void main(String[] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		
		board = new int[8][8];
		for(int i = 0;i<8;i++) {
			String line = in.nextLine();
			for(int j = 0;j<8;j++) {
				if(line.charAt(j) == '*') {
					board[i][j] = -1;
				}
			}
		}
		
		cols = new int[8];
		diag1 = new int[16];
		diag2 = new int[16];
		
		count = 0;
	}
	
	public static void solve() {
		search(0);
	}
	
	public static void output(){
		System.out.println(count);
	}
	
	public static void search(int row) {
		if(row == 8) {
			count++;
		}
		else {
			
			for(int col = 0;col<8;col++) {
				if(board[row][col] != -1) {
					
					if(cols[col] == 0 && diag1[row + col] == 0 && diag2[row-col + 7] == 0) {
						
						cols[col] = 1; diag1[row + col] = 1; diag2[row-col+7] = 1;
						search(row + 1);
						cols[col] = 0; diag1[row + col] = 0;diag2[row-col + 7] = 0;
						
					}
					
				}
			}
			
		}
	}
}
