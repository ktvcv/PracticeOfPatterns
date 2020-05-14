package dss.News.ObservableNewsWithNotifications;

import dss.News.ObservableNews.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class SubscriberWithNotification extends Subscriber {

    List<Notificator> notificator = new ArrayList<>();

    public List<Notificator> getNotificator() {
        return notificator;
    }

    public void setNotificator(Notificator notificator) {
        this.notificator.add(notificator);
    }

    public SubscriberWithNotification(String uniqueNickName) {
        super(uniqueNickName);
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
    }

    @Override
    public String getUniqueNickName() {
        return super.getUniqueNickName();
    }

    @Override
    public void setUniqueNickName(String uniqueNickName) {
        super.setUniqueNickName(uniqueNickName);
    }

    @Override
    public List<String> getNews() {
        return super.getNews();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
