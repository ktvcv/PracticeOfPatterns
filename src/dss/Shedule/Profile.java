package dss.Shedule;

import java.util.ArrayList;
import java.util.List;

public class Profile implements ProfileCalendar {

    private List<Event> events = new ArrayList<>();
    private Profiles profile;

    public Profile(Profiles profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Profile{" +
            "events=" + events +
            ", profile=" + profile +
            '}';
    }

    @Override
    public void addEvent(Event event) {
        this.events.add(event);
    }

    @Override
    public boolean deleteEvent(Event event) {
        return events.remove(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return this.events;
    }

    @Override
    public Profiles getProfileName() {
        return this.profile;
    }

    @Override
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvents(List<Event> events) {
        this.events.addAll(events);
    }
}
