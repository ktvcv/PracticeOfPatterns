package dss.Shedule;

import java.util.List;

public interface ProfileCalendar {
    void addEvent(Event event);
    boolean deleteEvent(Event event);
    List<Event> getAllEvents();
    Profiles getProfileName();
    void  setEvents(List<Event> events);
    void addEvents(List<Event> events);
}
