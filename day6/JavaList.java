import java.io.*;
import java.util.*;

public class JavaList {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            list.add(sc.nextInt());
        }
        int t = sc.nextInt();
        while (t > 0) {
            String query = sc.next();
            if (query.equals("Insert")) {
                int index = sc.nextInt();
                int element = sc.nextInt();
                list.add(index, element);
            } else if (query.equals("Delete")) {
                int index = sc.nextInt();
                list.remove(index);
            }
            t--;
        }
        for (int num : list) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
