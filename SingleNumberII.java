/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
*/

class Solution {
    public int singleNumber(int[] nums) {
        
        //Approach 1 - Sorting
        if(nums.length == 1){
            return nums[0];
        }
        
        Arrays.sort(nums);
        
        if(nums[0] != nums[1]){
            return nums[0];
        }
        
        int i = 1;
        while(i < nums.length){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
            i = i + 3;
        }
        return nums[nums.length - 1];
        
        //Approach 2 - Using HashMap
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i=0; i<nums.length; i++){
//             if(map.containsKey(nums[i])){
//                 map.put(nums[i],map.get(nums[i]) + 1);
//             }
//             else{
//                 map.put(nums[i],1);
//             }
//         }
       
//         Iterator<Integer> itr = map.keySet().iterator();
        
//         while(itr.hasNext()){
//             int key = itr.next();
//             if(map.get(key) == 1){
//                 return key;
//             }
//         }
        
//         return -1;
    }
}
