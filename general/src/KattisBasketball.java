import java.util.*;

public class KattisBasketball {

    static Scanner in;
    static String s;

    public static void main(String[] args) {

        in = new Scanner(System.in);
        s = in.next();
        System.out.println(s.charAt(s.length()-2));
    }
}