package dss.News.ObservableNewsWithNotifications;

public interface Notificator {
    void alarm();
    String getNotificationSource();
    void setNotificationSource(String source);
}
