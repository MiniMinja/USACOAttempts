import java.util.*;
import java.io.*;

public class U2016Openbcs {
	static BufferedReader in;
	static PrintWriter out;
	
	static int N, K;
	static char[][] figure;
	static ArrayList<Piece> pieces;
	
	static int p1;
	static int p2;
	
	public static void main(String[] args) throws IOException{
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException{
		in = new BufferedReader(new FileReader("bcs.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("bcs.out")));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		figure = new char[N * 3][N * 3];
		for(int i = 0 ;i<N * 3;i++) {
			for(int j = 0;j<N * 3;j++) {
				figure[i][j] = '.';
			}
		}
		for(int i = N;i<N * 2;i++) {
			String line = in.readLine();
			for(int j = N;j<N * 2;j++) {
				figure[i][j] = line.charAt(j - N);
			}
		}
		
		pieces = new ArrayList<Piece>();
		for(int i = 0;i<K;i++) {
			char[][] piece = new char[N][];
			for(int j = 0;j<N;j++) {
				piece[j] = in.readLine().toCharArray();
			}
			pieces.add(new Piece(i, piece));
		}
		
		in.close();
	}
	
	public static void solve() {
		//find the pieces that can fit into the figure
		ArrayList<Piece> workingPieces = new ArrayList<Piece>();
		for(int i = 0;i<pieces.size();i++) {
			if(pieces.get(i).fitLocs.size() > 0) {
				workingPieces.add(pieces.get(i));
			}
		}
		for(Piece p: workingPieces) {
			printPiece(p.data);
			for(int[] fitloc: p.fitLocs) {
				System.out.println(Arrays.toString(fitloc));
			}
		}
		
		//try combining two pieces to see if they make the whole picture
		if(workingPieces.size() > 2) {
			for(int i = 0;i<workingPieces.size() - 1;i++) {
				for(int j = i + 1;j<workingPieces.size();j++) {
					if(superimpose(workingPieces.get(i), workingPieces.get(j))) {
						p1 = i + 1;
						p2 = j + 1;
						return;
					}
				}
			}
		}
		else if(workingPieces.size() == 2){
			p1 = workingPieces.get(0).id + 1;
			p2 = workingPieces.get(1).id + 1;
		}
		else {
			p1 = -1;
			p2 = -1;
		}
	}
	
	public static void output() {
		if(p1 != -1 && p2 != -1) {
			out.println(p1 + " " + p2);
		}
		out.close();
	}
	
	
	// ------------ DEBUG ----------------------
	public static void printFigure() {
		for(int i = 0;i<N * 3;i++) {
			for(int j = 0;j<N*3;j++) {
				System.out.print(figure[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void printPiece(char[][] p) {
		for(int j = 0;j<N;j++) {
			for(int k = 0;k<N;k++) {
				System.out.print(p[j][k]);
			}
			System.out.println();
		}
			System.out.println();
	}
	// ------------ DEBUG ----------------------


	/*
	 * test case: might work in multiple places
	 */
	
	public static boolean matchesAt(char[][] piece, int row, int col) {
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(figure[row + i][col + j] == '.' && piece[i][j] == '#') {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean superimpose(Piece a, Piece b) {
		char[][] figureBuilt = new char[N * 3][N * 3];
		for(int i = 0;i<N * 3;i++) {
			for(int j = 0;j<N * 3;j++) {
				figureBuilt[i][j] = '.';
			}
		}
		
		for(int[] loc1: a.fitLocs) {
			//impose a in certain location
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					figureBuilt[i + loc1[0]][j + loc1[1]] = a.data[i][j];
				}
			}
			
			for(int[] loc2: b.fitLocs) {
				//a flag for the state of superimposing
				boolean maySuperimpose = true;
				for(int i = 0;i<N;i++) {
					for(int j = 0;j<N;j++) {
						if(figureBuilt[i + loc2[0]][j + loc2[1]] == '#' && b.data[i][j] == '#') {
							maySuperimpose = false;
						}
						else if(figureBuilt[i + loc2[0]][j + loc2[1]] == '.') {
							figureBuilt[i + loc2[0]][j + loc2[1]] = b.data[i][j];
						}
						
						if(!maySuperimpose) break;
					}
					if(!maySuperimpose) break;
				}

				if(maySuperimpose) {
					if(compareFigures(figureBuilt)) return true;
				}
			}
			
			//unimpose a for this location
			for(int i = 0;i<N * 3;i++) {
				for(int j = 0;j<N * 3;j++) {
					figureBuilt[i][j] = '.';
				}
			}
		}
		return false;
	}
	
	public static boolean compareFigures(char[][] figureBuilt) {
		for(int i = 0;i<N * 3;i++) {
			for(int j = 0;j<N * 3;j++) {
				if(figureBuilt[i][j] != figure[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}

class Piece{
	int id;
	char[][] data;
	ArrayList<int[]> fitLocs;
	
	public Piece(int id, char[][] data) {
		this.id = id;
		this.data = data;
		fitLocs = new ArrayList<int[]>();
		
		for(int i = 0;i<=U2016Openbcs.N * 2;i++) {
			for(int j = 0;j<=U2016Openbcs.N * 2;j++) {
				
				if(U2016Openbcs.matchesAt(data, i, j)) {
					fitLocs.add(new int[] {i, j});
				}
			}
		}
	}
}
