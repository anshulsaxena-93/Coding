/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
*/

class Solution {
    
    HashMap<String,Integer> map = null;
    public int numTrees(int n) {
        map = new HashMap<>();
        return countBST(1,n);
    }
    
    private int countBST(int start,int end){
        
        String key = start + "|" + end;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        if(start >= end){
            map.put(key,1);
            return 1;
        }
        
        int count = 0;
        
        //take each number in the range and then multiply the number of trees from left subset and right subset
        for(int k=start; k<=end; k++){
            count = count + (countBST(start,k-1) * countBST(k+1,end));
        }
        
        map.put(key,count);
        return count;
    }
}
