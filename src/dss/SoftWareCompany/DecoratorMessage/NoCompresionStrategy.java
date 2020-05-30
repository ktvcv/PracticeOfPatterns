package dss.SoftWareCompany.DecoratorMessage;

public class NoCompresionStrategy implements ICompressionStrategy {

    @Override
    public String zip(String plainText) {
        return plainText;
    }

    @Override
    public String unzip(String zippedText) {
        return zippedText;
    }
}
