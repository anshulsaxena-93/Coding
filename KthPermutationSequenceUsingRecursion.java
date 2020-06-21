/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/

class Solution {
    
    int K = 0;
    int targetK = 0;
    String str = null;
    
    public String getPermutation(int n, int k) {
        targetK = k;
        K = 0;
        KComb(new HashSet<>(),"",n);
        return str;
    }
    
    private boolean KComb(HashSet<Integer> set,String s,int n){
        
        if(set.size() == n){
            K++;
            if(K == targetK){
                str = new String(s);
                return true;
            }
            else{
                return false;
            }
        }
        
        for(int i=1; i<=n; i++){
            
            if(set.contains(i)){
                continue;
            }
            else{
                set.add(i);
                boolean flag = KComb(set, s + "" + i, n);
                if(flag == true){
                    return true;
                }
                else{
                    set.remove(Integer.valueOf(i));
                }
            }
            
        }
        return false;
    }
}
