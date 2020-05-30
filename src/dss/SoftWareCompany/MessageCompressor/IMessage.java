package dss.SoftWareCompany.MessageCompressor;

public interface IMessage {
    void write(String data);
    String read();
}
