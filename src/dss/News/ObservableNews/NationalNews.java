package dss.News.ObservableNews;

import java.util.Observer;

public class NationalNews extends NewsSubject {
    public NationalNews() {
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
