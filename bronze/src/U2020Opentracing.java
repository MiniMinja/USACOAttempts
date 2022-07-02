import java.util.*;
import java.io.*;

public class U2020Opentracing{
    static BufferedReader in;
    static PrintWriter out;

    static int N, T;
    static int[] health;
    static Interaction[] timestamp;

    static int pZCount;
    static int lowK;
    static int highK;

    public static void main(String[] args) throws IOException{
        init();
        solve();
        output();
    }

    public static void init() throws IOException{
        in = new BufferedReader(new FileReader("tracing.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));

        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        String health_s = in.readLine();
        health = new int[N];
        for(int i = 0;i<N;i++){
            health[i] = health_s.charAt(i) - '0';
        }

        timestamp = new Interaction[250];
        for(int i = 0;i<T;i++){
            st = new StringTokenizer(in.readLine());
            int t = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            timestamp[t] = new Interaction(c1, c2);
        }

        pZCount = 0;
        lowK = Integer.MAX_VALUE;
        highK = -1;

        in.close();
    }

    public static void solve(){
        int[] retVals = new int[3];
        for(int i = 0;i<N;i++){
        	retVals[0] = 0;
        	retVals[1] = Integer.MAX_VALUE;
        	retVals[2] = -1;

            if(health[i] == 1) {
	            search(i, retVals);
	            if(retVals[0] == 1){
	                pZCount++;
	                if(retVals[1] < lowK) lowK = retVals[1];
	                if(retVals[2] > highK) highK = retVals[2];
	            }
            }
        }
    }

    public static void output(){
    	if(pZCount == 0 || lowK == Integer.MAX_VALUE || highK == -1) {
    		return;
    	}
    	
    	out.print(pZCount + " ");
    	out.print(lowK + " ");
    	if(highK > 100) {
    		out.println("Infinity");
    	}
    	else {
    		out.println(highK);
    	}
        out.close();
    }

/*
simulates through timestamp assuming a cow is patientZero
retVals gives { whether the patientZero IS patient zero, low K value, high K value }
*/
    public static void search(int patientZero, int[] retVals){
    	for(int pK = 0;pK <= 101;pK++) {
        	int[] simul_health = new int[N];
        	int[] simul_k = new int[N];
    		
        	simul_health[patientZero] = 1;
        	simul_k[patientZero] = pK;
    		for(int i = 0;i<timestamp.length;i++) {
    			if(timestamp[i] != null) {
    				
    				//spread infection
    				if(simul_k[timestamp[i].cow1] > 0 && simul_health[timestamp[i].cow2] == 0) {
    					simul_health[timestamp[i].cow2] = 1;
    					simul_k[timestamp[i].cow2] = pK + 1;
    				}
    				
    				//both ways?
    				if(simul_k[timestamp[i].cow2] > 0 && simul_health[timestamp[i].cow1] == 0) {
    					simul_health[timestamp[i].cow1] = 1;
    					simul_k[timestamp[i].cow1] = pK + 1;
    				}
    				
					
					simul_k[timestamp[i].cow1]--;
					simul_k[timestamp[i].cow2]--;
    			}
    		}
    		
    		if(compare(simul_health, health)) {
    			retVals[0] = 1;
    			if(pK < retVals[1]) retVals[1] = pK;
    			if(pK > retVals[2]) retVals[2] = pK;
    		}
    	}
    }
    
    public static boolean compare(int[] a, int[] b) {
    	for(int i = 0;i<a.length;i++) {
    		if(a[i] != b[i]) return false;
    	}
    	return true;
    }
}

class Interaction{
    int cow1, cow2;

    public Interaction(int cow1, int cow2){
        this.cow1 = cow1;
        this.cow2 = cow2;
    }
}