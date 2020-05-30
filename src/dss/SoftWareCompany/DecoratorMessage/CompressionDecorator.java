package dss.SoftWareCompany.DecoratorMessage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class CompressionDecorator extends MessageDecorator implements ICompressionStrategy{

    private final ICompressionStrategy compressionStrategy;

    public CompressionDecorator(IMessage wrappee, ICompressionStrategy compressionStrategy) {
        super(wrappee);
        this.compressionStrategy = compressionStrategy;
    }


    @Override
    public void write(String data) {
        try {
            super.write(zip(data));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        return unzip(super.read());
    }

    @Override
    public String zip(String plainText) {
        return compressionStrategy.zip(plainText);
    }

    @Override
    public String unzip(String zippedText) {
        return compressionStrategy.unzip(zippedText);
    }
}
