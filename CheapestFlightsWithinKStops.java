/*
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price 
from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:

The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.

Constraints:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.
*/


class TripInfo implements Comparable<TripInfo>{
    int dst;
    int cost;
    int stops;
    TripInfo(int dst,int cost,int stops){
        this.dst = dst;
        this.cost = cost;
        this.stops = stops;
    }
    public int compareTo(TripInfo ti){
        return this.cost - ti.cost;
    }
}

class Solution {
      
    HashMap<Integer,ArrayList<TripInfo>> map = null;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
       
        //Creating Adjanceny List for later retrieval
        map = new HashMap<>();
        for(int i=0; i<flights.length; i++){
            if(map.containsKey(flights[i][0])){
                ArrayList<TripInfo> al = map.get(flights[i][0]);
                al.add(new TripInfo(flights[i][1],flights[i][2],0));
                map.put(flights[i][0],al);
            }
            else{
                ArrayList<TripInfo> al = new ArrayList<>();
                al.add(new TripInfo(flights[i][1],flights[i][2],0));
                map.put(flights[i][0],al); 
            }
        }
        
        //Heap is used to store min value distance node from source at the top
        //As pe Dijkstra Algorithm
        PriorityQueue<TripInfo> heap = new PriorityQueue<>();
        if(map.containsKey(src)){
            ArrayList<TripInfo> al = map.get(src);
            heap.addAll(al);
        }
        
        
        //BFS
        while(!heap.isEmpty()){
           
            TripInfo lowest = heap.poll();
           
            //Once we reach destination its the lowest path sum destination
            if(lowest.dst == dst){
                return lowest.cost;
            }
            
            //Number of stops check
            if(lowest.stops == K){
                continue;
            }
            
            if(map.containsKey(lowest.dst)){
                ArrayList<TripInfo> al = map.get(lowest.dst);
                
                //Add all flights from cheapest destination
                for(int i=0; i<al.size(); i++){
                    heap.add(new TripInfo(al.get(i).dst, 
                                          lowest.cost + al.get(i).cost, 
                                          lowest.stops + 1)
                            );
                }
            }
        }
        
        return -1;
        
    }
    
}
