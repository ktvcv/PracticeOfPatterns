package dss.SoftWareCompany.DecoratorMessage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class MessageDecorator implements IMessage{

    private IMessage wrappee;


    public MessageDecorator(IMessage wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void write(String data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        wrappee.write(data);
    }

    @Override
    public String read() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        return wrappee.read();
    }
}
