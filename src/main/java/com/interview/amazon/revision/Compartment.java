package com.interview.amazon.revision;



/*Given a string = |*|***| containing of | and *
    | - start/end of container
    * - inventory
    startingIndices - [ 1 , 3 , 5]
    endingIndices   - [ 2 , 4 , 6]
    These are all queries startingIndices , endingIndices
    You have to tell what is the inventory contained in startingIndex - endingIndex [1-2] - |* = 0
    You have to tell what is the inventory contained in startingIndex - endingIndex [3-4] - |* = 0
    You have to tell what is the inventory contained in startingIndex - endingIndex [5-6] - ** = 0
    */
public class Compartment {

    public static void main(String[] args) {

    }

    public void findIndexOfClosestLeftAndRightWallsAtEachPoint(String sequence) {

        // construct left and right arrays
        // find no of walls between two pair of walls - wallIndex
        //

    }

    public enum Notation{
        WALL('|'),
        INVENTORY('*');

        private char wallNotation;
        Notation(char wallNotation){
            this.wallNotation = wallNotation;
        }

    }
}
