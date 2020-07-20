/*
Problem Description
Given an array of integers A and an integer B.
Find the total number of subarrays having exactly B odd numbers.

Problem Constraints
1 <= length of the array <= 10^5
1 <= A[i] <= 10^9
0 <= B <= A

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the total number of subarrays having exactly B odd numbers.

Example Input
Input 1:
 A = [4, 3, 2, 3, 4]
 B = 2
 
Input 2:
 A = [5, 6, 7, 8, 9]
 B = 3

Example Output
Output 1:
 4
 
Output 2:
 1

Example Explanation
Explanation 1:
 The subarrays having exactly B odd numbers are:
 [4, 3, 2, 3], [4, 3, 2, 3, 4], [3, 2, 3], [3, 2, 3, 4]
 
Explanation 2:
 The subarrays having exactly B odd numbers is [5, 6, 7, 8, 9]
*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        
        int count = 0;
        for(int i=0; i<A.size(); i++){
            if(A.get(i) % 2 != 0){
                count++;
            }
            
            int x = count - B;
            if(map.containsKey(x)){
                ans = ans + map.get(x);
            }
            
            if(count == B){
                ans = ans + 1;
            }
            
            if(map.containsKey(count)){
                map.put(count,map.get(count) + 1);
            }
            else{
                map.put(count,1);
            }
        }
        return ans;
    }
}
