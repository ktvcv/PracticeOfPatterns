package dss.SoftWareCompany.DecoratorMessage;

import java.io.UnsupportedEncodingException;
import java.security.*;

public interface IDigitalSignatureDecorator {
    void sign(String plainText) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException;
    boolean verify(Signature signature, byte[] signatureBytes, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;
}
