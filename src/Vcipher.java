import java.util.Scanner;

public class Vcipher {

    //Encryption
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char ctr = text.charAt(i); if (ctr < 'a' || ctr > 'z') continue;
            result.append((char) ((ctr + key.charAt(j) - 2 * 'a') % 26 + 'a'));
            j = ++j % key.length();
        }

        return result.toString();
    }

    //Decryption
    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        text = text.toLowerCase();
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char ctr = text.charAt(i); if (ctr < 'a' || ctr > 'z') continue;
            result.append((char) ((ctr - key.charAt(j) + 26) % 26 + 'a'));
            j = ++j % key.length();
        }

        return result.toString();
    }

    // Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vigenere Cipher!");
        System.out.println("This program will ask you for some text to encode.");
        System.out.println("It will also ask for a key to encode the text.");
        System.out.println("Finally it will show you how the message looks encoded and decoded!.");

        System.out.println("Enter the string you want to encode:");
        String plaintext = scanner.nextLine();

        System.out.println("Enter the key string for the message you want to encode:");
        String key = scanner.nextLine();

        String encrypted = encrypt(plaintext, key);
        System.out.println("This is the encrypted message: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("This is the decrypted message: " + decrypted);

        scanner.close();
    }
}
