package dss.SoftWareCompany.MessageCompressor;

public class Message implements IMessage {

    private String sender;
    private String receiver;
    private String text;
    private ICompressionStrategy compressionStrategy = new NoCompresionStrategy();

    public Message(String sender, String receiver, ICompressionStrategy compressionStrategy) {
        this.sender = sender;
        this.receiver = receiver;
        this.compressionStrategy = compressionStrategy;
    }

    public Message(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public void write(String data) {
        this.text = this.compressionStrategy.zip(data);
        System.out.println("Zipped text: " + this.text);
    }

    @Override
    public String read() {
        return this.compressionStrategy.unzip(this.text);
    }
}
