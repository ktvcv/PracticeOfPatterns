package dss.News.ObservableNewsWithNotifications;

public class EmailNotificator implements Notificator {
    String email;

    public EmailNotificator(String email) {
        this.email = email;
    }

    @Override
    public void alarm(SubscriberWithNotification subscriber) {
        System.out.println( subscriber.getUniqueNickName() + "has new news notification sent to your email " + this.email);
    }

    @Override
    public String getNotificationSource() {
        return email;
    }

    @Override
    public void setNotificationSource(String email) {
        this.email = email;
    }
}
