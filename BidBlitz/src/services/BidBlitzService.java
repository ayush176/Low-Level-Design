package services;

import entities.Event;
import entities.Member;
import repositories.BidBlitzRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BidBlitzService {
    BidBlitzRepository bidBlitzRepository;

    public BidBlitzService() {
        bidBlitzRepository = new BidBlitzRepository();
    }

    public void addMember(int id, String name, int coins) {
        Member member = new Member(id, name, coins);
        bidBlitzRepository.getMemberList().add(member);
        System.out.println(name + " added successfully");
    }

    public void addEvent(int id, String name, String prizeName, int date) {
        Event event = new Event(id, name, prizeName, date);
        bidBlitzRepository.getEventList().add(event);
        System.out.println(name + " with prize " + prizeName + " added successfully");
    }

    public void registerMember(int memberId, int eventId) {
        List<Event> eventList = bidBlitzRepository.getEventList().stream()
                .filter(event -> event.getEventId() == eventId).collect(Collectors.toList());

        if (eventList == null || eventList.isEmpty()) {
            System.out.println("Event is not present");
            return;
        }

        List<Member> memberList = bidBlitzRepository.getMemberList().stream()
                .filter(member -> member.getMemberId() == memberId).collect(Collectors.toList());

        if (memberList == null || memberList.isEmpty()) {
            System.out.println("Member not present");
            return;
        }

        eventList.get(0).getRegisteredMembers().add(memberList.get(0));

        System.out.println(memberList.get(0).getMemberName() +
                " registered to the " +
                eventList.get(0).getEventName() +
                " event successfully");
    }

    public void sumbitBid(int memberId, int eventId, String bidsString) {
        List<Event> eventList = bidBlitzRepository.getEventList().stream()
                .filter(event -> event.getEventId() == eventId).collect(Collectors.toList());

        if (eventList == null || eventList.isEmpty()) {
            System.out.println("Event is not present");
            return;
        }

        Event event = eventList.get(0);

        long memberPresent = event.getRegisteredMembers().stream()
                .filter(member -> member.getMemberId() == memberId).count();

        if (memberPresent == 0) {
            System.out.println("Member did not registered for this event");
            return;
        }

        String[] bidsStringArr = bidsString.trim().split(" ");
        List<Integer> bids = new ArrayList<>();
        for (int i = 0; i < bidsStringArr.length; i++) {
            bids.add(Integer.parseInt(bidsStringArr[i]));
        }

        String mapKey = generateMapKey(eventId, memberId);
        Collections.sort(bids);

        bidBlitzRepository.getHashMapOfEventBids().put(mapKey, bids);

        System.out.println("BIDS submitted successfully");

    }

    public void declareWinner(int eventId) {
        bidBlitzRepository.getHashMapOfEventBids();
        List<Event> eventList = bidBlitzRepository.getEventList().stream()
                .filter(event1 -> event1.getEventId() == eventId).collect(Collectors.toList());

        if (eventList == null || eventList.isEmpty()) {
            System.out.println("Event is not present");
            return;
        }

        Event event = eventList.get(0);

        //member
        List<Member> memberList = event.getRegisteredMembers();

        String winner = "";
        int minBid = 1000000;

//        for (Map.Entry mp: bidBlitzRepository.getHashMapOfEventBids().entrySet()){
//            String key = mp.getKey();
//            String generat
//        }
        for (Member member : memberList) {
            String key = generateMapKey(eventId, member.getMemberId());

            List<Integer> bids = bidBlitzRepository.getHashMapOfEventBids().get(key);
            if (minBid > bids.get(0)) {
                minBid = bids.get(0);
                winner = member.getMemberName();
            }
        }
        System.out.println(winner + " wins the " + event.getPrizeName() + " with lowest bid " + minBid);

    }

    private String generateMapKey(int eventId, int memberId) {
        return eventId + "_" + memberId;
    }
}
