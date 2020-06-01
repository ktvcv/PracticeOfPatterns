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



    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
