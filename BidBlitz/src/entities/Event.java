package entities;

import java.util.ArrayList;
import java.util.List;

public class Event {
    int eventId;
    String eventName;
    String prizeName;
    int date; // relative date
    List<Member> registeredMembers;

    public Event(int eventId, String eventName, String prizeName, int date) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.prizeName = prizeName;
        this.date = date;
        registeredMembers = new ArrayList<>();
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public List<Member> getRegisteredMembers() {
        return registeredMembers;
    }

    public void setRegisteredMembers(List<Member> registeredMembers) {
        this.registeredMembers = registeredMembers;
    }
}
