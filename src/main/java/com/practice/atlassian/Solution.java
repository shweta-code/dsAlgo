package com.practice.atlassian;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
       Snake snake = new Snake();
       snake.move(Direction.Up);
       snake.move(Direction.Right);
    }


}

class Snake {
    Deque<Coordinate> cordinates = new ArrayDeque<>();

    Set<Coordinate> setOfCoordinates;
    Coordinate beginningCoordinate;
    Coordinate endCoordinate;

    int steps = 0;
    int size = 3;

    public Snake (){
        cordinates.add(new Coordinate(0,0));
        cordinates.add(new Coordinate(1,0));
        cordinates.add(new Coordinate(2,0));

        // duplicacy
        setOfCoordinates.add(new Coordinate(2,0));
        setOfCoordinates.add(new Coordinate(1,0));
        setOfCoordinates.add(new Coordinate(0,0));
        size = cordinates.size();

        // initialize snake
    }

    public boolean move(Direction direction){

        Coordinate newBeginningCoordinate = null;

        // switch case
        if(direction == Direction.Left){
            int newBeginningCoordinateX = beginningCoordinate.x + Direction.Left.x;
            int newBeginningCoordinateY = beginningCoordinate.y + Direction.Left.y;
            newBeginningCoordinate = new Coordinate(newBeginningCoordinateX, newBeginningCoordinateY);
        } else if (direction == Direction.Right) {
            int newBeginningCoordinateX = beginningCoordinate.x + Direction.Right.x;
            int newBeginningCoordinateY = beginningCoordinate.y + Direction.Right.y;
            newBeginningCoordinate = new Coordinate(newBeginningCoordinateX, newBeginningCoordinateY);
        }  else if (direction == Direction.Up) {
            int newBeginningCoordinateX = beginningCoordinate.x + Direction.Up.x;
            int newBeginningCoordinateY = beginningCoordinate.y + Direction.Up.y;
            newBeginningCoordinate = new Coordinate(newBeginningCoordinateX, newBeginningCoordinateY);
        }  else if (direction == Direction.Down) {
            int newBeginningCoordinateX = beginningCoordinate.x + Direction.Down.x;
            int newBeginningCoordinateY = beginningCoordinate.y + Direction.Down.y;
            newBeginningCoordinate = new Coordinate(newBeginningCoordinateX, newBeginningCoordinateY);
        }  else {
            // throw invalid argument exception
        }


        cordinates.offerFirst(newBeginningCoordinate);
        steps++;
        if(cordinates.contains(newBeginningCoordinate)){
            // end of the gape
            return false;
        } else if(steps < 5) {
            Coordinate endCoordinate = cordinates.pollLast();
            setOfCoordinates.add(newBeginningCoordinate);
            setOfCoordinates.remove(endCoordinate);
            beginningCoordinate = newBeginningCoordinate;
            size = cordinates.size();
            return true;
        } else {
            setOfCoordinates.add(newBeginningCoordinate);
            beginningCoordinate = newBeginningCoordinate;
            steps = 0;
            size = cordinates.size();
            return true;
        }


    }






}
class Coordinate {

    int x;
    int y;

    // getters and setters

    // equals and hashCode


    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}

enum Direction {

    Up(0, 1),

    Down(0, -1),

    Left(-1, 0),
    Right (1, 0);

    Direction(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int x;
    public int y;

}