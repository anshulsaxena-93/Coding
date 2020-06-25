/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. 
Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

//For proof check https://youtu.be/-YiQZi3mLq0?list=PL0mOOvoSbyTtFlq2Or--S4gd3UPMqoyGK

class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow_pointer = 0;
        int fast_pointer = 0;
        
        //detect if cycle exist and where they meet
        while(true){
            slow_pointer = nums[slow_pointer];
            fast_pointer = nums[nums[fast_pointer]];
            if(slow_pointer == fast_pointer){
                break;
            }
        }
        
        //find the start of the cycle
        fast_pointer = 0;
        while(slow_pointer != fast_pointer){
            slow_pointer = nums[slow_pointer];
            fast_pointer = nums[fast_pointer];
        }
        
        return slow_pointer;
    }
}
