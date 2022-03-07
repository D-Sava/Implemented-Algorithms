import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args){

        int option = -1;

        do {

            Scanner optionScanner = new Scanner(System.in);
            System.out.println("========== OTP crypto-algorithm ==========");
            System.out.println("\nChoose an option\n");

            System.out.println("Option 1 - Encrypt");
            System.out.println("Option 2 - Decrypt");
            System.out.println("Option 3 - Exit\n");

            option = optionScanner.nextInt();

            switch (option){
                case 1:{
                    Scanner case1Scanner = new Scanner(System.in);

                    System.out.println("Enter your message:\n");
                    String message = case1Scanner.nextLine();

                    System.out.println("\nGenerating key...");
                    String key = generateKey(message.length());
                    System.out.println("Key: " +key+"\n");

                    System.out.println("\nEncrypting...");
                    String cipher = encrypt(key, message);
                    System.out.println("Cipher: "+cipher+"\n");

                    break;
                }
                case 2:{
                    Scanner case2Scanner = new Scanner(System.in);

                    System.out.println("Enter your cipher:\n");
                    String cipher = case2Scanner.nextLine();

                    System.out.println("Enter your key: \n");
                    String key = case2Scanner.nextLine();

                    System.out.println("\nDecrypting...");
                    String plainText = decrypt(key, cipher);
                    System.out.println("Plain Text: "+plainText +"\n");

                    break;
                }
                default:{
                    break;
                }
            }
        }while(option != 3);




    }

    public static String encrypt(String key, String plainText){

        byte[] key_ba = key.getBytes(StandardCharsets.UTF_8);
        byte[] ptext_ba = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] cipher_ba = new byte[key.length()];

        for(int i = 0; i < key.length(); i++){
            cipher_ba[i] = (byte)(key_ba[i] ^ ptext_ba[i]);
        }

        return new String(cipher_ba, StandardCharsets.UTF_8);
    }

    public static String decrypt(String key, String cipher){

        byte[] key_ba = key.getBytes(StandardCharsets.UTF_8);
        byte[] cipher_ba = cipher.getBytes(StandardCharsets.UTF_8);
        byte[] ptext_ba = new byte[key.length()];

        for(int i = 0; i < key.length(); i++){
            ptext_ba[i] = (byte)(key_ba[i] ^ cipher_ba[i]);
        }

        return new String(ptext_ba, StandardCharsets.UTF_8);
    }

    public static String generateKey(int length) {

        String key = "";

        int max = 90;
        int min = 65;

        for(int i = 0; i < length; i++){
            key += (char)(Math.random() * (max - min) + min);
        }

        return key;
    }

}
