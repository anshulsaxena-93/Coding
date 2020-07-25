/*
Problem Description
Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
Return the count modulo 10^9 + 7.

Problem Constraints
1 <= A <= 109

Input Format
First and only argument is an integer A.

Output Format
Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 10^9 + 7.

Example Input
Input 1:
 A = 3
 
Input 2:
 A = 1
 
Example Output
Output 1:
 4
 
Output 2:
 1

Example Explanation
Explanation 1:
 DECIMAL    BINARY  SET BIT COUNT
    1          01        1
    2          10        1
    3          11        2
 1 + 1 + 2 = 4 
 Answer = 4 % 1000000007 = 4

Explanation 2:
 A = 1
  DECIMAL    BINARY  SET BIT COUNT
    1          01        1
 Answer = 1 % 1000000007 = 1
*/

public class Solution {
    public int solve(int A) {
        long val1,val2,cnt;
        cnt = 0;
        for(int i = 1;i<32;i++){
            val1 = (int)((A+1)/Math.pow(2,i));
            val2 = (int)((A+1)%Math.pow(2,i));
            if(val2 > Math.pow(2,i-1))
                val2 = val2 - (int)Math.pow(2,i-1);
            else
                val2 = 0;
            cnt = cnt + (int)(val1*Math.pow(2,i-1)) + val2;
        }
       
       return (int)(cnt%1000000007);
    }
    
}
