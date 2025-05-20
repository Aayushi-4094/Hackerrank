package day2;
import java.util.*;

public class StaticInitialiserBlock {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =  new Scanner(System.in);
        int b = sc.nextInt();
        int h = sc.nextInt();
        try {
            if (b <= 0 || h <= 0) {
                throw new Exception("Breadth and height must be positive");
            } else {
                System.out.println(b * h);
            }
        } catch (Exception e) {
            System.out.println("java.lang.Exception: " + e.getMessage());
        }
    }
}

