/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

Solution
Approach 1: Binary Search
Assume that the answer is k, i.e. we've managed to complete k rows of coins. 
These completed rows contain in total 1 + 2 + ... + k = k(k+1)/2 coins.

Approach 2: Math
If we look deeper into the formula of the problem, we could actually solve it with the help of mathematics, without using any iteration.
*/

class Solution {
  public int arrangeCoins(int n) {
    
    long left = 0, right = n;
    long k, curr;
    
    while (left <= right) {
      
      //take middle number and find no of coins required
      k = left + (right - left) / 2;
      curr = k * (k + 1) / 2;
      
      //if no of coins required are equal to no of coins we have
      if (curr == n) return (int)k;

      //if no of coins required are more then try with lesser rows range
      if (n < curr) {
        right = k - 1;
      } 
      else  //try with greater rows range
      {
        left = k + 1;
      }
    }
    
    return (int)right;
  }
}

class Solution {
  public int arrangeCoins(int n) {
    return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
  }
}
