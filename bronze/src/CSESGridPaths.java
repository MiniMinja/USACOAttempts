import java.io.*;

/*
??????R??????U??????????????????????????LD????D?
 */
import java.util.*;
public class CSESGridPaths {
	//static PrintWriter out;
	
	public static final int[][] posChanges = {
			{-1, 0, 'U'}, // U
			{0, 1, 'R'},  // R
			{1, 0, 'D'},  // D
			{0, -1, 'L'}  // L
	};
	
	static Scanner in;
	
	static int[][] grid;
	
	static char[] pathRule;
	
	static ArrayList<Character> path;
	static int count;
	
	public static void main(String[] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		/*
		try {
			out = new PrintWriter(new FileWriter("pathsData.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
		
		grid = new int[7][7];
		
		pathRule = in.nextLine().toCharArray();
		
		path = new ArrayList<Character>();
	}
	
	public static void solve() {
		if(pathRule[0] == 'R') {
			path.add('R');
			grid[0][0] = 1;
			grid[0][1] = 2;
			
			search(0, 1, 3);
		}
		else {
			path.add('D');
			grid[0][0] = 1;
			grid[1][0] = 2;
			
			search(1, 0, 3);
		}
	}
	
	public static void output() {
		System.out.println(count * 2);
		//out.close();
	}
	
	//static int calls = 0;
	public static boolean search(int row, int col, int depth) {
		//System.out.println("Call: "+ calls + " Depth: " + depth);
		//System.out.println("Path: " + path);
		//printBoard();
		//calls++;
		if(path.size() == pathRule.length) {
			for(int i = 0;i<path.size();i++) {
				if(pathRule[i] != '?' && path.get(i) != pathRule[i]) {
					return false;
				}
			}
			//for(char c: path) {
			//	out.print(c);
			//}
			//out.println();
			count++;
		}
		else if(row == 6 && col == 0) {
			return false;
		}
		else {
			for(int i = 0;i<posChanges.length;i++) {
				int newRow = row + posChanges[i][0];
				int newCol = col + posChanges[i][1];
				//System.out.println("Checking: " + newRow + " " + newCol + " " + (char)posChanges[i][2]);
				
				if(0 <= newRow && newRow < 7 &&
					0 <= newCol && newCol < 7 && 
					grid[newRow][newCol] == 0) {
					
					if( !( !canGoStraight(row, col, path.get(path.size() - 1)) &&
						   canGoLeft(row, col, path.get(path.size()-1)) &&
						   canGoRight(row, col, path.get(path.size()-1)) )   ) {
						grid[newRow][newCol] = depth;
						path.add((char)posChanges[i][2]);
						search(newRow, newCol, depth + 1);
						grid[newRow][newCol] = 0;
						path.remove(path.size() - 1);
					}
				}
			}
		}
		return false;
	}
	
	public static boolean canGoStraight(int row, int col, char prevDir) {
		int[] pc = getChanges(prevDir);
		return 0 <= row+pc[0] && row+pc[0] <= 6 &&
				0 <= col + pc[1] && col + pc[1] <= 6 &&
				grid[row+pc[0]][col + pc[1]] == 0;
	}
	
	public static boolean canGoLeft(int row, int col, char prevDir) {
		if(prevDir == 'U') {
			return canGoStraight(row, col, 'L');
		}
		else if(prevDir == 'R') {
			return canGoStraight(row, col, 'U');
		}
		else if(prevDir == 'D') {
			return canGoStraight(row, col, 'R');
		}
		else {
			return canGoStraight(row, col, 'D');
		}
	}
	
	public static boolean canGoRight(int row, int col, char prevDir) {
		if(prevDir == 'U') {
			return canGoStraight(row, col, 'R');
		}
		else if(prevDir == 'R') {
			return canGoStraight(row, col, 'D');
		}
		else if(prevDir == 'D') {
			return canGoStraight(row, col, 'L');
		}
		else {
			return canGoStraight(row, col, 'U');
		}
	}
	
	public static int[] getChanges(char c) {
		if(c == 'U') {
			return posChanges[0];
		}
		else if(c == 'R') {
			return posChanges[1];
		}
		else if(c == 'D') {
			return posChanges[2];
		}
		else  {
			return posChanges[3];
		}
	}
	
	public static void printBoard() {
		for(int[] row: grid) {
			for(int i = 0;i<row.length;i++) {
				System.out.print(row[i] + " ");
			}
			System.out.println();
		}
	}
}
