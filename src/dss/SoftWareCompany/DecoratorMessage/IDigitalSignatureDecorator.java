package dss.SoftWareCompany.DecoratorMessage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public interface IDigitalSignatureDecorator {
    void sign(String plainText)
        throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException;

    boolean verify(Signature signature, byte[] signatureBytes, PublicKey publicKey)
        throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;
}
