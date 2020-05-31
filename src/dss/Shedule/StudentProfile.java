package dss.Shedule;

import java.util.ArrayList;
import java.util.List;

public class StudentProfile implements ProfileCalendar{

    private static StudentProfile instance;
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

    private StudentProfile() {
        // this code makes lazy initialization
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static StudentProfile getInstance() {
        if (instance == null) {
            instance = new StudentProfile();
        }
        return instance;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
