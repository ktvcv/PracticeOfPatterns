package dss.Shedule;

import java.util.ArrayList;
import java.util.List;

public class Person implements IPerson{
    private String name;
    private String surname;
    private List<ProfileCalendar> profileCalendarList = new ArrayList<>();
    private List<Profiles> profiles;

    public List<Profiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profiles> profiles) {
        this.profiles = profiles;
    }

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

    public List<Event> getProfileCalendarList() {
        List<Event> events = new ArrayList<>();
        profileCalendarList.forEach(x -> events.addAll(x.getAllEvents()));
        return events;
    }

    public void setProfileCalendarList(List<ProfileCalendar> profileCalendarList) {
        this.profileCalendarList = profileCalendarList;
    }

    @Override
    public void addProfileCalendar(Profiles profiles) {
        if((profiles == Profiles.PAS) && (!this.profiles.contains(Profiles.PAS)))
        {
            this.profileCalendarList.add(new PASProfile());
        }
        else if(profiles == Profiles.STUDENT) {
            this.profileCalendarList.add(StudentProfile.getInstance());
        }
    }


}
