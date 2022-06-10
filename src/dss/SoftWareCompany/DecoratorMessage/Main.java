package dss.SoftWareCompany.DecoratorMessage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        String messageText = "New message about prices on Apple stocks";
        Message message = new Message("Forex", "Jonh Doe");
        MessageDecorator encoded = new CompressionDecorator(
            new EncryptionDecorator(
                new DigitalSignatureDecorator(message)), new HuffmanCompression());
        encoded.write(messageText);


        System.out.println("- Input ----------------");
        System.out.println(messageText);
        System.out.println("- Encoded --------------");
        System.out.println(message.read());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.read());
    }
}
