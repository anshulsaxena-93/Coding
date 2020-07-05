/*
Problem Description

Given an array A containing N integers.

You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.

If no such triplet exist return 0.

Problem Constraints
3 <= N <= 105.
1 <= A[i] <= 108.

Input Format
First argument is an integer array A.

Output Format
Return a single integer denoting the maximum sum of triplet as described in the question.

Example Input
Input 1:

 A = [2, 5, 3, 1, 4, 9]
Input 2:

 A = [1, 2, 3]

Example Output
Output 1:

 16
Output 2:

 6

Example Explanation
Explanation 1:

 All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
  Maximum sum = 16
Explanation 2:

 All possible triplets are:-
    1 2 3 => sum = 6
 Maximum sum = 6
*/

public class Solution {
    public int solve(ArrayList<Integer> A) {
       
        int[] maxSuffix = new int[A.size()+1];
        maxSuffix[A.size()] = 0;
        for(int i=A.size()-1; i>=0; i--){
            maxSuffix[i] = Math.max(maxSuffix[i+1],A.get(i));
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(A.get(0));
        int ans = 0;
        for(int i=1; i<A.size()-1; i++){
            if(A.get(i) < maxSuffix[i+1]){
                if(set.lower(Integer.valueOf(A.get(i))) != null){
                    ans = Math.max(ans,
                                   A.get(i) + maxSuffix[i+1] + 
                                   set.lower(Integer.valueOf(A.get(i))));
                }
            }
            set.add(A.get(i));
        }
        return ans;
    }
   
}
