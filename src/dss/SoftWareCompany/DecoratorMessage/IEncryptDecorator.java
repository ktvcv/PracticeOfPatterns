package dss.SoftWareCompany.DecoratorMessage;

public interface IEncryptDecorator {
    String encrypt(String text);
    String decode(String text);
}
