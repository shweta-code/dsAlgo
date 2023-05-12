package com.algos.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LeetCode2402MeetingRoomsIIITwoHeaps {


    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Room> occupied = new PriorityQueue<>(n, (room1, room2) -> {
            if (room1.getEndTime() == room2.getEndTime()) {
                return room1.getRoomNo() - room2.getRoomNo();
            }
            return room1.getEndTime() - room2.getEndTime();
        });

        PriorityQueue<Room> free = new PriorityQueue<>(n, Comparator.comparingInt(Room::getRoomNo));



        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            rooms[i] = new Room(i);
            occupied.offer(rooms[i]);
        }

        int i = 0;
        Arrays.sort(meetings, (m1, m2) -> {
            if (m1[0] == m2[0]) {
                return m1[1] - m2[1];
            }
            return m1[0] - m2[0];
        });

        // It will fail for testMostBooked2
        // As rooms are not getting free even if the meeting ends
        // They are always occupied
        while (i < meetings.length) {


            while (occupied.size() > 0 && meetings[i][0] >= occupied.peek().getEndTime()) {
                Room room = occupied.poll();
                assert room != null;
                room.setEndTime(0);
                free.offer(room);
            }

            Room room;
            if (free.size() > 0) {
                room = free.poll();
            } else {
                room = occupied.poll();
            }
            System.out.printf("%d -> %d - %d", room.getRoomNo(), meetings[i][0], meetings[i][1]);
            System.out.println();

            room.incrementCount();
            room.setEndTime(Math.max(meetings[i][0], room.getEndTime()) +(meetings[i][1]- meetings[i][0]));
            occupied.offer(room);
            i++;

        }
//        return 0;

//        Optional<Room> maxCountRoom = Arrays.stream(rooms).max(Comparator.comparingInt(Room::getCount));

        List<Room> collect = Arrays.stream(rooms).sorted((room1, room2) -> {
            if (room1.getCount() == room2.getCount()) {
                return room1.getRoomNo() - room2.getRoomNo();
            }
            return room2.getCount() - room1.getCount();
        }).collect(Collectors.toList());

        collect.forEach(s -> System.out.println(s.roomNo +"-> "+ s.getCount()));

        return collect.get(0).getRoomNo();
    }

    static class Room {

        private final int roomNo;
        private  int count;
        private  int endTime;

        public int getEndTime(){
            return endTime;
        }

        public int getCount(){
            return count;
        }

        public int getRoomNo(){
            return roomNo;
        }

        public Room(int roomNo){
            this.roomNo = roomNo;
            this.count = 0;
            this.endTime = 0;
        }

        public void incrementCount(){
            count++;
        }

        public void setEndTime(int endTime){
            this.endTime = endTime;
        }
    }

}
