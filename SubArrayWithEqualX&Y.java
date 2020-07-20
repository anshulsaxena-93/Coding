/*
Problem Description
Given an integer array A and two integers B and C.
You need to find the number of subarrays in which the number of occurrences of B is equal to number of occurrences of C.
NOTE: Don't count empty subarrays.

Problem Constraints
1 <= |A| <= 104
1 <= A[i], B, C <= 108
B != C

Input Format
First argument is an integer array A.
Second argument is an integer B.
Third argument is an integer C.

Output Format
Return an integer denoting the number of subarrays in which the number of occurrences of B is equal to number of occurrences of C.

Example Input
Input 1:
 A = [1, 2, 1]
 B = 1
 C = 2
 
Input 2:
 A = {1, 2, 1}
 B = 4
 C = 6

Example Output
Output 1:
 2
 
Output 2:
 6

Example Explanation
Explanation 1:
 The possible sub-arrays have same equal number of occurrences of B and C are:
    1) {1, 2}, B and C have same occurrence(1).
    2) {2, 1}, B and C have same occurrence(1).
    
Explanation 2:
 The possible sub-arrays have same equal number of occurrences of B and C are:
    1) {1}, B and C have same occurrence(0).
    2) {2}, B and C have same occurrence(0).
    3) {1}, B and C have same occurrence(0).
    4) {1, 2}, B and C have same occurrence(0).
    5) {2, 1}, B and C have same occurrence(0).
    6) {1, 2, 1}, B and C have same occurrence(0).
*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int ans = 0;
        int countB = 0;
        int countC = 0;
        for(int i=0; i<A.size(); i++){
           
           if(A.get(i) == B){
               countB++;
           }
           
           if(A.get(i) == C){
               countC++;
           }
            
            int x = countB - countC;
            if(map.containsKey(x)){
                ans = ans + map.get(x);
            }
            
            if(countB == countC){
                ans = ans + 1;
            }
            
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }
            else{
                map.put(x,1);
            }
            
        }
        return ans;
    }
}

