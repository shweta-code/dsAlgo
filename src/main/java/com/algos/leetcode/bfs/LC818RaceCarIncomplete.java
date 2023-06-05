package com.algos.leetcode.bfs;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LC818RaceCarIncomplete {

    public int racecar(int target) {

        Queue<PositionSpeedMoves> bfsQ = new ArrayDeque<>();
        bfsQ.add(new PositionSpeedMoves(0,1,0, new String()));
        Set<Pair<Integer, Integer>> positionsTraversed = new HashSet<>();

        while (!bfsQ.isEmpty()) {
            PositionSpeedMoves positionSpeedMoves = bfsQ.poll();
            int position = positionSpeedMoves.getPos();
            int speed = positionSpeedMoves.getSpeed();
            positionsTraversed.add(new Pair<>(position, speed));
            int moves = positionSpeedMoves.getMoves();
            String instructions = positionSpeedMoves.getInstructions();
            System.out.println("Position ->"+position);
            System.out.println("Speed -> "+speed);
            System.out.println("Instructions -> "+ instructions);
            if (position == target) {
                return moves;
            }

            // A
            if (!positionsTraversed.contains(new Pair<>(position+speed, speed)) && position+speed >0) {
                bfsQ.add(new PositionSpeedMoves(position+speed, 2*speed, moves+1, instructions+"A"));
            }

            // R
            if (speed > 0 && position >0 && !positionsTraversed.contains(new Pair<>(position, -1))) {
                bfsQ.add(new PositionSpeedMoves(position, -1, moves+1, instructions + "R"));
            }

            //R
            if (speed < 0 && position >0 && !positionsTraversed.contains(new Pair<>(position, 1))) {
                bfsQ.add(new PositionSpeedMoves(position, 1, moves+1, instructions+"R"));
            }
        }
        return -1;
    }


    class PositionSpeedMoves {
        private final int pos;
        private final int speed;
        private final int moves;
        private final String instructions;

        public PositionSpeedMoves(int pos, int speed, int moves, String instructions) {
            this.pos = pos;
            this.speed = speed;
            this.moves = moves;
            this.instructions = instructions;
        }

        public int getPos() {
            return pos;
        }

        public int getSpeed() {
            return speed;
        }

        public int getMoves() {
            return moves;
        }

        public String getInstructions() {
            return instructions;
        }
    }

}
