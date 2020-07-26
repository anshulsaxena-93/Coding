/*
Problem Description
Given an one-dimensional unsorted array A containing N integers.
You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.
Return 1 if any such pair exists else return 0.

Problem Constraints
1 <= N <= 10^5
-10^3 <= A[i] <= 10^3
-10^5 <= B <= 10^5

Input Format
First argument is an integer array A of size N.
Second argument is an integer B.

Output Format
Return 1 if any such pair exists else return 0.

Example Input
Input 1:
 A = [5, 10, 3, 2, 50, 80]
 B = 78
 
Input 2:
 A = [-10, 20]
 B = 30

Example Output
Output 1:
 1
 
Output 2:
 1

Example Explanation
Explanation 1:
 Pair (80, 2) gives a difference of 78.
 
Explanation 2:
 Pair (20, -10) gives a difference of 30 i.e 20 - (-10) => 20 + 10 => 30
*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        
        Collections.sort(A);
        
        int low = 0;
        int high = 0;
        
        while(low < A.size() && high < A.size()){
            
            int diff = A.get(high) - A.get(low);
            if(diff == B && low != high){
                return 1;
            }
            else if(diff < B){
                high++;
            }
            else{
                low++;
            }
            
        }
        return 0;
    }
}
