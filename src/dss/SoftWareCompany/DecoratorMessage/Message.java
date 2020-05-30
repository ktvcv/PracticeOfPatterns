package dss.SoftWareCompany.DecoratorMessage;

public class Message implements IMessage{
    String sender;
    String receiver;
    String text;

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
        this.text = data;
    }

    @Override
    public String read() {
        return this.text;
    }
}
