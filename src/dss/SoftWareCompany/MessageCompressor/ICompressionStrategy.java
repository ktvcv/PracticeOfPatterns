package dss.SoftWareCompany.MessageCompressor;

public interface ICompressionStrategy {
    String zip(String plainText);

    String unzip(String zippedText);
}
