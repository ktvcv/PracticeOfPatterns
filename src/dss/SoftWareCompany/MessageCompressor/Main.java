package dss.SoftWareCompany.MessageCompressor;

public class Main {
    public static void main(String[] args) {

        Message messageHuffman = new Message("Forex", "John Doe", new HuffmanCompression());
        messageHuffman.write("Data");
        System.out.println("Unzipped text " + messageHuffman.read());

        Message messageLZC = new Message("Forex", "John Doe", new LempelZivCompression());
        messageLZC.write("Data");
        System.out.println("Unzipped text " + messageLZC.read());

        Message message = new Message("Forex", "John Doe");
        message.write("Data");
        System.out.println("Unzipped text " + message.read());


    }
}
