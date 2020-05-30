package dss.News.ObservableNewsWithNotifications;

public interface Notificator {
    void alarm(SubscriberWithNotification subscriber);
    String getNotificationSource();
    void setNotificationSource(String source);
}
