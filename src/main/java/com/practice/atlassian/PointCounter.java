package com.practice.atlassian;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class PointCounter {

   /* A Hackathon
    Multiple participants
    Audience is handed over ballot _ Ordered
    Team has one participant only - name
    1. 3 points
    2. 2 points
    3. 1 points


    People allowed to vote to max 3 of his favourite participants.

    Output list pf participants in order of desc points


    List<String> findWinner(List<Vote> votes) - Ballot having 3 participants name
  */

    public static void main(String[] args) {

        String part1 = "Part1"; // 3
        String part2 = "Part2"; // 2 3 -5
        String part3 = "Part3";// 1 2 - 3
        String part4 = "Part4";//1  3 - 4
        String part5 = "Part5";//2
        String part6 = "Part6";//1
        List<String> parts1 = new ArrayList<>();
        List<String> parts2 = new ArrayList<>();
        List<String> parts3 = new ArrayList<>();
        parts1.add(part1);
        parts1.add(part2);
        parts1.add(part3);
        parts2.add(part2);
        parts2.add(part3);
        parts2.add(part4);
        parts3.add(part4);
        parts3.add(part5);
        parts3.add(part6);


        Vote vote1 = new Vote(parts1);
        Vote vote2 = new Vote(parts2);
        Vote vote3 = new Vote(parts3);
        List<Vote> votes = new ArrayList<>();
        votes.add(vote1);
        votes.add(vote2);
        votes.add(vote3);

        PointCounter pointCounter = new PointCounter();
        List<String> winners = pointCounter.findWinner(votes);
        System.out.println(Arrays.toString(winners.toArray()));


    }

    public List<String> findWinner(List<Vote> votes){

        Map<String, Integer> participantToPointsOfVotes = new HashMap<>();
        Map<String, Counter> participantToCounter = new HashMap<>();

        for (Vote vote :
                votes) {
            // Assuming valid votes
            String firstPart = vote.favouriteParticipants.get(0);
            String secondPart = vote.favouriteParticipants.get(1);
            String thirdPart = vote.favouriteParticipants.get(2);

            // Enum for pints associated to each position
            participantToPointsOfVotes.put( firstPart, participantToPointsOfVotes.getOrDefault(firstPart, 0)+3);
            participantToPointsOfVotes.put( secondPart, participantToPointsOfVotes.getOrDefault(secondPart, 0)+2);
            participantToPointsOfVotes.put( thirdPart, participantToPointsOfVotes.getOrDefault(thirdPart, 0)+1);

            Counter counter1 = participantToCounter.getOrDefault(firstPart, new Counter());
            counter1.noOfPOints += 3;
            counter1.threePointers += 1;
            participantToCounter.put(firstPart, counter1);


            Counter counter2 = participantToCounter.getOrDefault(secondPart, new Counter());
            counter2.noOfPOints += 2;
            counter2.twoPointers += 1;
            participantToCounter.put(secondPart, counter2);

            Counter counter3 = participantToCounter.getOrDefault(thirdPart, new Counter());
            counter3.noOfPOints += 1;
            counter3.onePointers += 1;
            participantToCounter.put(thirdPart, counter3);
        }

        List<Entry<String, Integer>> collect = new ArrayList<>(participantToPointsOfVotes.entrySet());
        collect.sort((o1, o2) -> {
            // How we decide
            return o2.getValue().compareTo(o1.getValue());
        });


        List<Entry<String, Counter>> participantToCounterList = new ArrayList<>(participantToCounter.entrySet());
        participantToCounterList.sort((o1, o2) -> {
            // How we decide
            if(o2.getValue().noOfPOints == (o1.getValue().noOfPOints)){
                if(o2.getValue().threePointers == (o1.getValue().threePointers)){
                    if(o2.getValue().twoPointers == (o1.getValue().twoPointers)) {
                        // Write
                    }

                    return Integer.compare(o2.getValue().twoPointers, o1.getValue().twoPointers);

                }

                return Integer.compare(o2.getValue().threePointers, o1.getValue().threePointers);
            }
            return Integer.compare(o2.getValue().noOfPOints, o1.getValue().noOfPOints);

        });

        List<String> ans = new ArrayList<>();
        for (Entry<String, Counter> entry :
                participantToCounterList) {
            ans.add(entry.getKey());
        }


        return ans;


    }

}

class Vote  {

    List<String> favouriteParticipants = new ArrayList<>();
    public Vote(List<String> favouriteParticipants){
        if (favouriteParticipants.size() > 3){
            // proper messaging.
            throw new IllegalArgumentException();
        }
        this.favouriteParticipants = favouriteParticipants;
    }

}

class Counter {

    int noOfPOints;
    int threePointers;
    int twoPointers;
    int onePointers;
}
