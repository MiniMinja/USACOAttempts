package PathDisplayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class PathDisplayer extends JPanel{
	
	public static class Board{
		public static final int X = 150, Y = 150;
		public static final int WIDTH = 490, HEIGHT = 490;
		
		public static final int[][][] coords = new int[7][7][2];
		
		static {
			for(int i = 0;i<7;i++) {
				for(int j = 0;j<7;j++) {
					coords[i][j][0] = X + j * (WIDTH / 7);
					coords[i][j][1] = Y + i * (HEIGHT / 7);
				}
			}
		}
		
		public static int X2() {
			return X + WIDTH;
		}
		
		public static int Y2() {
			return Y + HEIGHT;
		}
	}
	
	private JFrame window;
	
	private static int boardNum;
	
	public PathDisplayer() {
		window = new JFrame("PathDisplayer");
		
		this.setPreferredSize(new Dimension(800, 800));
		this.setMinimumSize(new Dimension(800, 800));
		this.setMaximumSize(new Dimension(800, 800));
		window.add(this);
		
		window.addKeyListener(new KeyAdapter() {
			
			boolean d_pressed;
			boolean a_pressed;
			
			public void keyPressed(KeyEvent e) {
				
			}

			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					boardNum++;
					if(boardNum >= gridpaths.size()) boardNum = 0;
				}
				else if(e.getKeyCode() == KeyEvent.VK_A) {
					boardNum--;
					if(boardNum < 0) boardNum = gridpaths.size() - 1;
				}
				window.repaint();
			}
		
		});
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		boardNum = 0;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//draw the layout for the boards
		g.setColor(Color.BLACK);
		g.drawRect(Board.X, Board.Y, Board.WIDTH, Board.HEIGHT);
		for(int i = 0;i<7;i++) {
			for(int j = 0;j<7;j++) {
				g.drawRect(Board.coords[i][j][0], Board.coords[i][j][1], Board.WIDTH / 7, Board.HEIGHT / 7);
			}
		}
		
		//draw the paths
		int row = 0;
		int col = 0;
		char[] gridpath = gridpaths.get(boardNum);
		for(int i = 0;i<gridpath.length;i++) {
			g.setColor(Color.RED);
			if(gridRule[i] != '?') {
				g.setColor(Color.BLUE);
			}
			
			//System.out.println(gridpath[i] + " " + row + " " + col);
			int midX = Board.coords[row][col][0] + Board.WIDTH / 14;
			int midY = Board.coords[row][col][1] + Board.HEIGHT / 14;
			int dx = 0;
			int dy = 0;
			if(gridpath[i] == UP) {
				dy -= Board.HEIGHT / 7;
				row--;
			}
			else if(gridpath[i] == DOWN) {
				dy += Board.HEIGHT / 7;
				row++;
			}
			else if(gridpath[i] == LEFT) {
				dx -= Board.HEIGHT / 7;
				col--;
			}
			else {
				dx += Board.HEIGHT / 7;
				col++;
			}
			g.drawLine(midX, midY, midX + dx, midY + dy);
		}
	}
	
	public static final char UP = 'U', DOWN = 'D', RIGHT = 'R', LEFT = 'L';
	
	public static char[] gridRule;
	public static ArrayList<char[]> gridpaths;
	
	public static void main(String[] args){
		
		try {
			gridpaths = new ArrayList<char[]>();
			getGridData();
			
			PathDisplayer displayer = new PathDisplayer();
			
		}catch(IOException e) {
			System.out.println("Can't find pathsData file");
		}
	}
	
	public static void getGridData() throws IOException{
		BufferedReader gridfile = new BufferedReader(new FileReader("src/PathDisplayer/pathsData.txt"));
		
		int count = Integer.parseInt(gridfile.readLine())/2;
		gridRule = gridfile.readLine().toCharArray();
		for(int n = 0;n<count;n++) {
			String line = gridfile.readLine()
							.replace("[", "")
							.replace("]","")
							.replace(",", "")
							.replace(" ", "");
			gridpaths.add(line.toCharArray());
		}
	}
}
