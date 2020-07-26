/*
Problem Description
Given an array A of N non-negative numbers and you are also given non-negative number B.
You need to find the number of subarrays in A having sum less than B. We may assume that there is no overflow.

Problem Constraints
1 <= N <= 10^4
1 <= A[i] <= 100
1 <= B <= 10^8

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the number of subarrays in A having sum less than B.

Example Input
Input 1:
 A = [2, 5, 6]
 B = 10
 
Input 2:
 A = [1, 11, 2, 3, 15]
 B = 10

Example Output
Output 1:
 4
 
Output 2:
 4

Example Explanation
Explanation 1:
 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},

Explanation 2:
 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
     
        int ret = 0;//to store ans
        int sum = 0;//to keep track of window sum
        int size = A.size();
        int left = 0;//left end of the window
        for(int i =0;i<size;++i){
            sum+=A.get(i);
            while(sum>=B&&left<=i){//if sum is more start deducting from left
                sum-=A.get(left++);
            }
            ret+= i-left+1;//nC2  ways or no of subarray with i as end and left as starting 
        }
        return ret;
        
    }
}
