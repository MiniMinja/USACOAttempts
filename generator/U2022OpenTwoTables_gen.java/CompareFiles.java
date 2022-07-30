import java.io.*;
import java.util.*;

public class CompareFiles {
    public static void main(String[] args) throws IOException{
        PrintWriter outputlog = new PrintWriter(new BufferedWriter(new FileWriter("comparison.log")));

        Scanner caseFile = new Scanner(new File("generated_cases.in"));
        ArrayList<TableData> tds = new ArrayList<TableData>();
        int t = caseFile.nextInt();
        for(int i = 0;i<t;i++){
            tds.add(
                new TableData(
                    caseFile.nextInt(), caseFile.nextInt(), 
                    caseFile.nextInt(), caseFile.nextInt(), 
                    caseFile.nextInt(), caseFile.nextInt(), 
                    caseFile.nextInt(), caseFile.nextInt()
                )
            );
        }


        Scanner f1 = new Scanner(new File("gap_out.txt"));
        Scanner f2 = new Scanner(new File("intersect_out.txt"));

        int c = 0;
        while(f1.hasNextDouble() && f2.hasNextDouble()){
            double d1 = f1.nextDouble();
            double d2 = f2.nextDouble();

            if(d1 != d2){
                outputlog.println("Error on case: " + c);
                outputlog.println(tds.get(c));
                outputlog.println("Gap gives: " + d1);
                outputlog.println("Intersect gives: " + d2);
                outputlog.println();
            }
            c++;
        }

        outputlog.close();
    }

    static class TableData{
        int W, H, x1, y1, x2, y2, w, h;

        public TableData(int W, int H, int x1, int y1, int x2, int y2, int w, int h){
            this.W = W;
            this.H = H;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.w = w;
            this.h = h;
        }

        public String toString(){
            String out = "";
            out += W + " " + H + "\n";
            out += x1 + " " + y1 + " " + x2 + " " + y2 + "\n";
            out += w + " " + h;
            return out;
        }
    }
}
