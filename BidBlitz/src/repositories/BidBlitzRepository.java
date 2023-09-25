package repositories;

import entities.Event;
import entities.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BidBlitzRepository {
    List<Member>  memberList;
    List<Event> eventList;

    public HashMap<String, List<Integer>> getHashMapOfEventBids() {
        return hashMapOfEventBids;
    }

    public void setHashMapOfEventBids(HashMap<String, List<Integer>> hashMapOfEventBids) {
        this.hashMapOfEventBids = hashMapOfEventBids;
    }

    HashMap<String,List<Integer>> hashMapOfEventBids; // key = eventId_memeberId

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public BidBlitzRepository() {
        memberList = new ArrayList<>();
        eventList = new ArrayList<>();
        hashMapOfEventBids = new HashMap<>();
    }
}
