package com.algos.leetcode.graph;

import java.util.*;

public class LC815BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //We will do dfs

        //Build Adj List
        // List is not linear
        // So lets build adj Map

        Map<Integer, List<StopAndBusNo>> routeMap = new HashMap<>();

        int len = routes.length;
        for(int i = 0 ; i < len; i++){
            int busNo = i;
            int[] busRoute = routes[busNo];
            int busRouteLen = busRoute.length;
            if(busRouteLen > 1) {
                for (int j = 0; j < busRouteLen; j++) {
                    List<StopAndBusNo> connectingStops = routeMap.getOrDefault(busRoute[j], new ArrayList<>());
                    connectingStops.add(new StopAndBusNo(busRoute[(j + 1) % busRouteLen], busNo));
                    routeMap.put(busRoute[j], connectingStops);
                }
            }
        }

        routeMap.forEach((key, value) -> System.out.println("key " + key + "value " + value.toString()));

// seed data for dfs
        Stack<StopInfo> stack = new Stack<>();
        List<StopAndBusNo> stopAndBusNo = routeMap.get(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        for(int i = 0; i < stopAndBusNo.size(); i++){
            stack.add(new StopInfo(stopAndBusNo.get(i), 1));

        }



        while(!stack.isEmpty()){
            StopInfo stopInfo = stack.pop();
            Integer stopNo = stopInfo.stopAndBusNo.stop;
            if(stopNo == target){
                return stopInfo.count;
            }
            if(!visited.contains(stopNo)) {
                stopAndBusNo = routeMap.get(stopNo);
                for (int i = 0; i < stopAndBusNo.size(); i++) {

                    if (stopInfo.stopAndBusNo.busNo == stopAndBusNo.get(i).busNo)
                        stack.add(new StopInfo(stopAndBusNo.get(i), stopInfo.count));
                    else {
                        stack.add(new StopInfo(stopAndBusNo.get(i), stopInfo.count + 1));
                    }

                }
            }

            visited.add(stopNo);



        }




        // Do DFS

        // Consider not possible case
        return -1;

    }

    class StopAndBusNo{

        public int stop;
        public int busNo;

        // getter and setters refine
        public StopAndBusNo (int stop, int busNo ){
            this.stop = stop;
            this.busNo = busNo;
        }

        @Override
        public String toString() {
            return "StopAndBusNo{" +
                    "stop=" + stop +
                    ", busNo=" + busNo +
                    '}';
        }
    }

    class StopInfo {

        public StopAndBusNo stopAndBusNo;
        public int count;
        public StopInfo (StopAndBusNo stopAndBusNo, int count ){
            this.stopAndBusNo = stopAndBusNo;
            this.count = count;
        }
    }
}
