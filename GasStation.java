/*
Given two integer arrays A and B of size N.
There are N gas stations along a circular route, where the amount of gas at station i is A[i].

You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i
to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and
ending up at i again.

Input Format

The first argument given is the integer array A.
The second argument given is the integer array B.
Output Format

Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
For Example

Input 1:
    A =  [1, 2]
    B =  [2, 1]

Output 1:
    1

Explanation 1:
  If you start from index 0, you can fill in A[0] = 1 amount of gas. 
  Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1. 
        
  If you start from index 1, you can fill in A[1] = 2 amount of gas. 
  Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0. 
  So, you travel to station 0 and still have 1 unit of gas left over. 
  You fill in A[0] = 1 unit of additional gas, making your current gas = 2. 
  It costs you B[0] = 2 to get to station 1, which you do and complete the circuit. 
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        
        /*
        1.choose your starting index as 0.
        2.check if you can go to the next gas station with what fuel you get from your current gas station plus the fuel you saved in your journey so far.
            a. if yes : go to next gas station and follow step 2 again.
            b. if not : change your starting index to the gas station NEXT to your current gas station.
        */   
        
        int totalRem = 0;
        int startIndex = 0;
        int currrem = 0;
        for(int i=0; i<A.size(); i++){
            int rem = A.get(i) - B.get(i);
            currrem += rem; //Add the remianing to current remaining
            totalRem += rem; //keep increaind total remaining fuel
            if(currrem < 0){ //we cannot go to next station with fuel so change starting point to next index, reset the current remaining fuel
                currrem = 0;
                startIndex = i+1;
            }
        }
        
        if(totalRem >= 0){ //if total remaining is GE 0 it means solution is possible and startIndex is our answer
            return startIndex;
        }
        else{
            return -1;
        }
        
        // for(int i=0; i<A.size(); i++){
            
        //     int tank = 0;
        //     int count = 0;
        //     boolean found = true;
        //     int j = i;
            
        //     while(count < A.size()){
                
        //         if(tank + A.get(j) >= B.get(j)){
        //             tank = tank + A.get(j) - B.get(j);
        //             j = (j+1) % A.size();
        //         }
        //         else{
        //             found = false;
        //             break;
        //         }
        //         count++;
        //     }
            
        //     if(found == true){
        //         return i;
        //     }
            
        // }
        // return -1;
    }
}

        
