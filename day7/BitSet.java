
import java.io.*;
import java.util.*;

public class BitSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine(); // Consume newline left-over
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        for (int i = 0; i < m; i++) {
            String[] op = in.nextLine().split(" ");
            if (op[0].equals("SET") || op[0].equals("FLIP")) {
                int x = Integer.parseInt(op[1]);
                int y = Integer.parseInt(op[2]) - 1;
                if (op[0].equals("SET")) {
                    if (x == 1) {
                        b1.set(y);
                    } else {
                        b2.set(y);
                    }
                } else {
                    if (x == 1) {
                        b1.flip(y);
                    } else {
                        b2.flip(y);
                    }
                }
            } else {
                int x = Integer.parseInt(op[1]);
                if (op[0].equals("AND")) {
                    if (x == 1) {
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                } else if (op[0].equals("OR")) {
                    if (x == 1) {
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                } else if (op[0].equals("XOR")) {
                    if (x == 1) {
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                }
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
    }
}

