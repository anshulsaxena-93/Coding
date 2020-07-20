/*
Problem Description
Given an integer array A of size N containing 0's and 1's only.
You need to find the length of the longest subarray having count of 1’s one more than count of 0’s.

Problem Constraints
1 <= N <= 10^5

Input Format
First and only argument is an integer array A of size N.

Output Format
Return an integer denoting the longest length of the subarray.

Example Input
Input 1:
 A = [0, 1, 1, 0, 0, 1]

Input 2:
 A = [1, 0, 0, 1, 0]

Example Output
Output 1:
 5
 
Output 2:
 1

Example Explanation
Explanation 1:
 Subarray of length 5, index 1 to 5 i.e 1, 1, 0, 0, 1. Count of 1 = 3, Count of 0 = 2.

Explanation 2:
 Subarray of length 1 will be only subarray that follow the above condition.
*/

public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int count0 = 0;
        int count1 = 0;
        
        for(int i=0; i<A.size(); i++){
            if(A.get(i) == 0){
                count0++;
            }
            
            if(A.get(i) == 1){
                count1++;
            }
            
            int x = count1 - count0;
            if(map.containsKey(x-1)){
                int length = i - map.get(x-1);
                maxLength = Math.max(maxLength,length);
            }
            
            if(count1 - count0 == 1){
                maxLength = Math.max(maxLength,i+1);
            }
            
            if(!map.containsKey(x)){
               map.put(x,i); 
            }
        }
        
        return maxLength;
    }
}
