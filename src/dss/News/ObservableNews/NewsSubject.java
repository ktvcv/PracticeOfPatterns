package dss.News.ObservableNews;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class NewsSubject extends Observable {

    List<String> news = new ArrayList<>();

    public NewsSubject() {
        super();
    }

    @Override
    public synchronized void addObserver(Observer o){
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    public  void  addNews(String news)
    {
        this.news.add(news);
        setChanged();
        notifyObservers(news);
    }

}
