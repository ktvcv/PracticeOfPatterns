package dss.SoftWareCompany.DecoratorMessage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public interface IMessage {
    void write(String data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException;
    String read() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;
}
