package dss.News.ObservableNews;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer {
    private String uniqueNickName;
    private List<String> news = new ArrayList<>();

    public Subscriber(String uniqueNickName) {
        this.uniqueNickName = uniqueNickName;
    }

    @Override
    public void update(Observable o, Object arg) {
        news.add((String)arg);
        System.out.println("New news: " + arg);
    }

    public String getUniqueNickName() {
        return uniqueNickName;
    }

    public void setUniqueNickName(String uniqueNickName) {
        this.uniqueNickName = uniqueNickName;
    }

    public List<String> getNews() {
        return news;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "uniqueNickName='" + uniqueNickName + '\'' +
                ", news=" + news +
                '}';
    }
}
