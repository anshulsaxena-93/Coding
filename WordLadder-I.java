/*
Given two words A and B, and a dictionary, C, find the length of shortest transformation sequence from A to B, such that:

You must change exactly one character in every transformation.
Each intermediate word must exist in the dictionary.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.


Input Format:

The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains an array of strings, C.
Output Format:

Return an integer representing the minimum number of steps required to change string A to string B.
Constraints:

1 <= length(A), length(B), length(C[i]) <= 25
1 <= length(C) <= 5e3
Example :

Input 1:
    A = "hit"
    B = "cog"
    C = ["hot", "dot", "dog", "lot", "log"]

Output 1:
    5

Explanation 1:
    "hit" -> "hot" -> "dot" -> "dog" -> "cog"
*/

public class Solution {
    
    static char[] ch= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n'
                       ,'o','p','q','r','s','t','u','v','w','x','y','z'};
                       
    public int solve(String A, String B, ArrayList<String> C) {
        
        HashSet<String> dictionary = new HashSet<>(C);
        
        HashSet<String> visited = new HashSet<>();
        visited.add(A);
        
        Queue<String> queue = new LinkedList<>();
        queue.add(A);
        
        int changes = 1;
        while(queue.size() > 0){
            
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
               
                String s = queue.poll();
                
                if(s.equals(B)){
                    return changes;
                }
                else{
                    StringBuilder sb  = new StringBuilder(s);
                   
                    for(int j=0; j<s.length(); j++){
                        for(int k=0; k<26; k++){
                           sb.setCharAt(j,ch[k]);
                            
                            String s1 = sb.toString();
                            if(dictionary.contains(s1) && !visited.contains(s1)){
                                queue.add(s1);
                                visited.add(s1);
                            }
                        }
                    }
                }
            }
            changes++;
            
        }
        
        return 0;
    }

}
