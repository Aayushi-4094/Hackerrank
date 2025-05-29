import java.util.*;

public class PrimeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        Prime ob = new Prime();
        ob.checkPrime(a);
        ob.checkPrime(a, b);
        ob.checkPrime(a, b, c);
        ob.checkPrime(a, b, c, d, e);
    }
}

class Prime {
    public void checkPrime(int... numbers) {
        for (int n : numbers) {
            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
