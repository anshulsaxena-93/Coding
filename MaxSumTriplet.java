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
 */
 
 public class Solution {
   
   public int solve(ArrayList<Integer> A) {
        
        int ans = 0;
        for(int i=1; i<A.size()-1; i++){
            
            int max1=0;
            for(int j=0; j<i; j++){
                if(A.get(j) < A.get(i)){
                    max1 = Math.max(max1,A.get(j));
                }
            }
            
            int max2=0;
            for(int j=i+1; j<A.size(); j++){
                if(A.get(j) > A.get(i)){
                    max2 = Math.max(max2,A.get(j));
                }
            }
            
            if(max1 > 0 && max2 > 0){
                ans = Math.max(ans,max1 + A.get(i) + max2);
            }
            
        }
        return ans;
    }
}    
