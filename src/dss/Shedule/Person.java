package dss.Shedule;

import java.util.ArrayList;
import java.util.List;

public class Person implements IPerson {
    private String name;
    private String surname;
    private List<ProfileCalendar> profileCalendarList = new ArrayList<>();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        profileCalendarList.add(StandardProfile.getInstance());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        profileCalendarList.forEach(x -> events.addAll(x.getAllEvents()));
        return events;
    }

    public void addEvent(Event event, Profiles profiles) {
        ProfileCalendar profile = this.profileCalendarList
            .stream()
            .filter(e -> e.getProfileName().equals(profiles))
            .findFirst()
            .orElse(null);
        if (profile == null) {
            System.out.println("First, add needed profile");
            return;
        }

        List<Event> eventsCollision = checkForCollision(event);
        if (!eventsCollision.isEmpty()) {
            System.out.println("There some some collision : ");
            System.out.println(eventsCollision);
            System.out.println("////////////////////////////");
            return;
        }

        if (event.getStartDate().after(event.getEndDate())) {
            System.out.println("Error with dates");
            return;
        }
        profile.addEvent(event);
        this.profileCalendarList.removeIf(e -> e.getProfileName().equals(profiles));
        this.profileCalendarList.add(profile);

    }

    public void setStartEventsForProfile(List<Event> eventsForProfile, Profiles profiles) {
        ProfileCalendar profile = this.profileCalendarList
            .stream()
            .filter(e -> e.getProfileName().equals(profiles))
            .findFirst()
            .orElse(null);
        assert profile != null;
        profile.addEvents(eventsForProfile);
        this.profileCalendarList.removeIf(e -> e.getProfileName().equals(profiles));
        this.profileCalendarList.add(profile);

    }

    private List<Event> checkForCollision(Event event) {
        List<Event> events = getAllEvents();
        List<Event> events1 = new ArrayList<>();
        events.forEach(e -> {
            if (((((event.getStartDate().after(e.getStartDate())) || (event.getStartDate().equals(e.getStartDate())))
                && ((event.getEndDate().before(e.getEndDate())) || (event.getEndDate().equals(e.getEndDate())))
                || (((event.getStartDate().before(e.getStartDate())) || (event.getStartDate().equals(e.getEndDate()))))
                && (((event.getEndDate().after(e.getStartDate())) || (event.getEndDate().equals(e.getStartDate()))))
                && (((event.getEndDate().before(e.getEndDate())) || (event.getEndDate().equals(e.getEndDate())))))
                || ((((event.getStartDate().after(e.getStartDate())) || (event.getStartDate().equals(e.getStartDate()))))
                && (((event.getStartDate().before(e.getEndDate())) || (event.getStartDate().equals(e.getEndDate()))))
                && (((event.getEndDate().after(e.getEndDate())) || (event.getEndDate().equals(e.getEndDate())))))
                || (((event.getStartDate().before(e.getStartDate())) || (event.getStartDate().equals(e.getStartDate()))))
                && (((event.getEndDate().after(e.getEndDate())) || (event.getEndDate().equals(e.getEndDate())))))
            ) {
                events1.add(e);
            }
        });
        return events1;
    }

    public void setProfileCalendarList(List<ProfileCalendar> profileCalendarList) {
        this.profileCalendarList = profileCalendarList;
    }

    @Override
    public void addProfileCalendar(Profiles profiles) {
        if (this.profileCalendarList
            .stream()
            .filter(e -> e.getProfileName().equals(profiles))
            .findFirst()
            .orElse(null) == null
        ) {
            this.profileCalendarList.add(new Profile(profiles));
        }
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", profileCalendarList=" + profileCalendarList +
            '}';
    }
}
