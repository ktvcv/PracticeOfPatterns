package dss.News.ObservableNewsWithNotifications;

public class MobileNotificator implements Notificator {
    String mobilePhone;

    @Override
    public void alarm(SubscriberWithNotification subscriber) {
        System.out.println( subscriber.getUniqueNickName() + " has new news notification sent to your phone " + this.mobilePhone);
    }

    public MobileNotificator(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String getNotificationSource() {
        return mobilePhone;
    }

    @Override
    public void setNotificationSource(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
