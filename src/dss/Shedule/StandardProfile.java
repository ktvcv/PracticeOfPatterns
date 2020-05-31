package dss.Shedule;

import java.util.ArrayList;
import java.util.List;

public class StandardProfile implements ProfileCalendar{

    private static StandardProfile instance;
    private List<Event> events = new ArrayList<>();
    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public boolean deleteEvent(Event event) {
        return events.remove(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return this.events;
    }

    private StandardProfile() {
        // this code makes lazy initialization
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static StandardProfile getInstance() {
        if (instance == null) {
            instance = new StandardProfile();
        }
        return instance;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
