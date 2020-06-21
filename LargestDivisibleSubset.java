/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*/

class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        if(nums.length == 0){
            return  new ArrayList<>();
        }
        
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        
        //Add all numbers themselves as answer
        for(int i=0; i<nums.length; i++){
           al.add(new ArrayList<>(Arrays.asList(nums[i])));    
        }
        
        int maxLength=1;
        ArrayList<Integer> result = al.get(0);
        
        //Start picking one by one and check for all the all the prev elements
        //if it is dvisible & size of prev element list size + 1 is greater than current element list size
        for(int i=0; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if((nums[i] % nums[j] == 0) && (al.get(j).size() + 1 > al.get(i).size())){
                    ArrayList<Integer> list = new ArrayList<>(al.get(j));
                    list.add(nums[i]);
                    al.set(i,list);
                    
                    if(al.get(i).size() > maxLength){
                        maxLength = al.get(i).size();
                        result = al.get(i);
                    }
                }
            }
        }
        return result;
    }
}    
