
import java.util.*;

public class SplitString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String[] str = s.split("[^a-zA-Z]+");
        int l = 0;
        for (String st : str) {
            if (!st.isEmpty()) {
                l++;
            }
        }
        System.out.println(l);
        for (String st : str) {
            if (!st.isEmpty()) {
                System.out.println(st);
            }
        }
        scan.close();
    }
}

