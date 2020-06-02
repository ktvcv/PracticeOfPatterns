package dss.Shedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Person person = new Person("Sofia", "Paraz");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        person.addProfileCalendar(Profiles.PAS);
        person.addProfileCalendar(Profiles.STUDENT);
        person.addProfileCalendar(Profiles.PROFESSOR);

        person.addEvent(new Event("Lesson1", dateFormat.parse("2020-09-01 08:30:00"),dateFormat.parse("2020-09-01 12:30:00"),"Description"), Profiles.STUDENT);
        person.addEvent(new Event("Lesson2", dateFormat.parse("2020-09-02 10:30:00"),dateFormat.parse("2020-09-02 12:30:00"),"Description"), Profiles.STUDENT);
        person.addEvent(new Event("Lesson3", dateFormat.parse("2020-09-01 08:00:00"),dateFormat.parse("2020-09-01 11:30:00"),"Description"), Profiles.PROFESSOR);
        person.addEvent(new Event("Library revision", dateFormat.parse("2020-09-01 08:30:00"),dateFormat.parse("2020-09-01 09:30:00"),"Description"), Profiles.PAS);

        person.getAllEvents().forEach(System.out::println);
    }
}
