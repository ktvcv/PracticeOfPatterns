package dss.News.ObservableNews;

import java.util.Observer;

public class SportNews extends NewsSubject {
    public SportNews() {
        super();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }
}
