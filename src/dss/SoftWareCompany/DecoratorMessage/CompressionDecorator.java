package dss.SoftWareCompany.DecoratorMessage;

public class CompressionDecorator extends MessageDecorator implements ICompressionStrategy{

    private ICompressionStrategy compressionStrategy;

    public CompressionDecorator(IMessage wrappee, ICompressionStrategy compressionStrategy) {
        super(wrappee);
        this.compressionStrategy = compressionStrategy;
    }

    @Override
    public void write(String data) {
        super.write(zip(data));
    }

    @Override
    public String read() {
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
