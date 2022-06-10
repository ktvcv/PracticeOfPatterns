package dss.SoftWareCompany.DecoratorMessage;

public interface ICompressionStrategy {
    String zip(String plainText);

    String unzip(String zippedText);
}
