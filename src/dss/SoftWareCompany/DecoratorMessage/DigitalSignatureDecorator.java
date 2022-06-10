package dss.SoftWareCompany.DecoratorMessage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DigitalSignatureDecorator extends MessageDecorator implements IDigitalSignatureDecorator {

    private byte[] signature;
    private PublicKey publicKey;
    private Signature sig;

    public DigitalSignatureDecorator(IMessage wrappee) {
        super(wrappee);
    }

    @Override
    public void write(String data) throws
        NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        sign(data);
        super.write(data);
    }

    @Override
    public String read() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        if (verify(sig, signature, publicKey))
            return super.read();
        else return "Error";
    }


    @Override
    public void sign(String plainText) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException
    {
        KeyPair keyPair = getKeyPair();

        byte[] data = plainText.getBytes(UTF_8);

        Signature sig = Signature.getInstance("SHA1WithRSA");
        sig.initSign(keyPair.getPrivate());
        sig.update(data);
        this.signature = sig.sign();
        this.publicKey = keyPair.getPublic();
        this.sig = sig;

    }

    @Override
    public boolean verify(Signature signature, byte[] signatureByres, PublicKey publicKey)
        throws NoSuchAlgorithmException, InvalidKeyException, SignatureException
    {
        signature.initVerify(publicKey);
        sig.update(super.read().getBytes(UTF_8));

        return sig.verify(signatureByres);
    }

    private static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        return kpg.genKeyPair();
    }
}
