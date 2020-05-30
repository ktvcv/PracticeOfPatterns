package dss.SoftWareCompany.DecoratorMessage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Base64;

public class EncryptionDecorator extends MessageDecorator implements IEncryptDecorator{
    public EncryptionDecorator(IMessage wrappee) {
        super(wrappee);
    }

    @Override
    public void write(String data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        super.write(encrypt(data));
    }

    @Override
    public String read() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        return decode(super.read());
    }

    @Override
    public String encrypt(String text) {
        byte[] result = text.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    @Override
    public String decode(String text) {
        byte[] result = Base64.getDecoder().decode(text);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
