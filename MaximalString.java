/*
Problem Description
Given a string A and integer B, what is maximal lexicographical stringthat can be made from A if you do atmost B swaps.

Problem Constraints
1 <= |A| <= 9

A contains only digits from 0 to 9.
1 <= B <= 5

Input Format
First argument is string A.
Second argument is integer B.

Output Format
Return a string, the naswer to the problem.

Example Input
Input 1:
A = "254"
B = 1

Input 2:
A = "254'
B = 2

Example Output
Output 1:
 524
 
Output 2:
 542

Example Explanation
Explanation 1:
 Swap 2 and 5.
 
Explanation 2:
Swap 2 and 5 then swap 4 and 2.
*/

/*
The idea is to consider every digit and swap it with digits
following it one at a time and see if it leads to the maximum number.
The process is repeated B times.
*/

public class Solution {
    
    String ans = "";
    public String solve(String A, int B) {
        ans = A;
        getMaxString(A,B);
        return ans;
    }
    
    private void getMaxString(String s,int k){
        
        if(k == 0){
            return;
        }
       
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length()-1; i++){
            for(int j=i+1; j<s.length(); j++){
                if(sb.charAt(j) > sb.charAt(i)){
                    
                    //swap(i,j);
                    char c = sb.charAt(i);
                    sb.setCharAt(i,sb.charAt(j));
                    sb.setCharAt(j,c);
                    
                    if(sb.toString().compareTo(ans) > 0){
                        ans = sb.toString();
                    }
                    
                    getMaxString(sb.toString(),k-1);
                    
                    //swap(i,j);
                    c = sb.charAt(i);
                    sb.setCharAt(i,sb.charAt(j));
                    sb.setCharAt(j,c);
                    
                }
            }
        }      
    }
}
