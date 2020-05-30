package dss.SoftWareCompany.DecoratorMessage;

public class MessageDecorator implements IMessage{

    private IMessage wrappee;


    public MessageDecorator(IMessage wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void write(String data) {
        wrappee.write(data);
    }

    @Override
    public String read() {
        return wrappee.read();
    }
}
