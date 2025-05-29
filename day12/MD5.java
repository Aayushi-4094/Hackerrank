import java.security.*;
import java.util.*;

public class MD5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); // Read input string
        scanner.close();
        
        try {
            // Create MD5 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Convert input string to bytes and compute the hash
            byte[] hashBytes = md.digest(input.getBytes());
            
            // Convert hash bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b)); // Lowercase hex
            }
            
            // Print the MD5 hash
            System.out.println(sb.toString());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5 algorithm not found");
        }
    }
}
