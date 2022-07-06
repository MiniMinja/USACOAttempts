import java.util.*;
import java.io.*;

public class CF1555BTwoTables_gen{
    public static void main(String[] args) throws IOException{
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("generated_cases.in")));

        out.println(5000); //5000 test cases

        Random r = new Random();
        
        for(int test_case = 0;test_case < 5000; test_case++){
            //W and H will be 50-100
            int W = r.nextInt(51) + 50;
            int H = r.nextInt(51) + 50;

            int x1 = r.nextInt(W);
            int x2 = r.nextInt(W - x1) + x1 + 1;

            int y1 = r.nextInt(H);
            int y2 = r.nextInt(H - y1) + y1 + 1;

            int w = r.nextInt(W) + 1;
            int h = r.nextInt(H) + 1;

            out.println(W + " " + H);
            out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            out.println(w + " " + h);
        }

        out.close();
    }
}