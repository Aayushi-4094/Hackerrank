import java.security.*;
import java.util.*;

public class SHA256 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // Read input string
        scanner.close();

        try {
            // Create SHA-256 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());

            // Convert hash bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b)); // lower-case hex
            }

            // Print SHA-256 hash
            System.out.println(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("SHA-256 algorithm not found");
        }
    }
}
