/*
Problem Description
Given are Three arrays A, B and C.
Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.

Problem Constraints
1 <= |A|, |B|, |C| <= 100000
1 <= A[i], B[i], C[i] <= 100000
A, B, C may or may not have pairwise distinct elements.

Input Format
First argument is the array A.
First argument is the array B.
First argument is the array C.

Output Format
Return a sorted array of numbers.

Example Input
Input 1:
A = [1, 1, 2]
B = [2, 3]
C = [3]

Input 2:
A = [1, 2]
B = [1, 3]
C = [2, 3]

Example Output
Output 1:
[2, 3]

Output 2:
[1, 2, 3]

Example Explanation
Explanation 1:
1 is only present in A. 2 is present in A and B. 3 is present in B and C.

Explanation 2:
All numbers are present in atleast 2 out of 3 lists.
*/

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
    
       ArrayList<Integer> result = new ArrayList<>();
       HashSet<Integer> set = new HashSet<>();
       
       HashMap<Integer,Integer> map1 = new HashMap<>();
       for(int i=0; i<A.size(); i++){
           map1.put(A.get(i),1);
       }
       
       HashMap<Integer,Integer> map2 = new HashMap<>();
       for(int i=0; i<B.size(); i++){
           map2.put(B.get(i),1);
           if(map1.containsKey(B.get(i))){
               if(!set.contains(B.get(i))){
                   result.add(B.get(i));
                   set.add(B.get(i));
               }
           }
       }
       
       HashMap<Integer,Integer> map3 = new HashMap<>();
       for(int i=0; i<C.size(); i++){
           map3.put(C.get(i),1);
           if(map1.containsKey(C.get(i)) || map2.containsKey(C.get(i))){
               if(!set.contains(C.get(i))){
                   result.add(C.get(i));
                   set.add(C.get(i));
               }
           }
       }
       
       Collections.sort(result);
       return result;
    }
}
