package com.algos.greedyAlgorithms.arrays;

import java.util.Arrays;


/*
@link
https:www.geeksforgeeks.org/find-k-bookings-possible-given-arrival-departure-times/
*/


//region Description
/*A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms.
 Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms
 in the hotel to satisfy the demand. A hotel manager has to process N advance bookings of rooms for the next
  season. His hotel has K rooms. Bookings contain an arrival date and a departure date.
 He wants to find out whether there are enough rooms in the hotel to satisfy the demand.*/
//endregion



/*
Input :  Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K: 1
        Output: False
        Hotel manager needs at least two
        rooms as the second and third
        intervals overlap.
*/
public class KBookingsPossibleWithGivenArrivalAndDeparture {

    public static void main(String[] args) {
        int[] arrival = {1,3,5};
        int[] dep = {2,6,8};
        int rooms = 1;

        KBookingsPossibleWithGivenArrivalAndDeparture kBookingsPossibleWithGivenArrivalAndDeparture = new KBookingsPossibleWithGivenArrivalAndDeparture();
        System.out.println(kBookingsPossibleWithGivenArrivalAndDeparture.find(arrival,dep, rooms));;

    }

    public boolean find(int[] arr, int[] dep, int rooms){

        int[] merge = new int[2*arr.length];

        for (int i = 0; i < arr.length; i++) {
            merge[i] = arr[i]*10;
        }

        for (int i = 0; i < dep.length; i++) {
            merge[i+ arr.length] = dep[i]*10 + 1;
        }

        Arrays.sort(merge);
        for (int aMerge : merge) {
            System.out.println(aMerge);
        }

        int counter = 0;
        int roomsNeeded = 0;
        for (int i : merge) {
            if (i % 10 == 0 ){
                counter++;
            } else {
                counter--;
            }

            if(counter == 0){
                roomsNeeded++;

            }
        }

        return rooms == roomsNeeded;
    }
}
