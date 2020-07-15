/*
Problem Description

You are given A eggs, and you have access to a building with B floors from 1 to B.

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor C with 0 <= C <= B such that any egg dropped at a floor higher than C will break,
and any egg dropped at or below floor C will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= B).

Your goal is to know with certainty what the value of C is.

What is the minimum number of moves that you need to know with certainty what C is, regardless of the initial value of C

Problem Constraints
1 <= A <= 100
1 <= B <= 10^4

Input Format
First Argument is an integer A denoting number of eggs.
Second Argument is an integer B denoting number of floors.

Output Format
Return an integer denoting the Minimum number of moves.

Example Input
Input 1:
 A = 1
 B = 2
 
Input 2:
 A = 2
 B = 10

Example Output
Output 1:
 2
 
Output 2:
 4 
 
Example Explanation
Explanation 1:

 Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 If it didn't break, then we know with certainty F = 2.
 Hence, we needed 2 moves in the worst case to know what F is with certainty.
*/

public class Solution {
    
    public int solve(int A, int B) {
        
         //Approach 1(Binomial Coefficient and Binary Search Solution)
        return minTrials(A,B);
        
        //Approach 2(MCM)
        // int dp[][] = new int[A+1][B+1];
        // for(int i=1; i<=A; i++){
        //     dp[i][0] = 0;
        //     dp[i][1] = 1;
        // }
        
        // for(int j=1; j<=B; j++){
        //     dp[1][j] = j;
        // }
        
        // for(int i=2; i<=A; i++){
        //     for(int j=2; j<=B; j++){
        //         dp[i][j] = Integer.MAX_VALUE;
        //         for(int k=1; k<=j; k++){
        //             int temp = 1 + Math.max(dp[i-1][k-1],dp[i][j-k]);
        //             if(temp < dp[i][j]){
        //                 dp[i][j] = temp;
        //             }
        //         }
        //     }
        // }
        // return dp[A][B];
        
    }
    
    private int binomialCoeff(int x, int n, int k) 
    { 
    int sum = 0, term = 1; 
     for (int i = 1; i <= n && sum < k; ++i) { 
        term *= x - i + 1; 
        term /= i; 
        sum += term; 
     } 
    return sum; 
    } 
  
   // Do binary search to find minimum  
   // number of trials in worst case. 
   private int minTrials(int n, int k) 
   { 
    // Initialize low and high as 1st  
    //and last floors 
    int low = 1, high = k; 
  
    // Do binary search, for every mid,  
    // find sum of binomial coefficients and  
    // check if the sum is greater than k or not. 
    while (low < high) { 
        int mid = (low + high) / 2; 
        if (binomialCoeff(mid, n, k) < k) 
            low = mid + 1; 
        else
            high = mid; 
    } 
  
    return low; 
   } 
    
}
 
