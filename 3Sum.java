/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        
        List<List<Integer>> doublelist = new ArrayList<>();
               
        Arrays.sort(a);
        
        for(int i=0;i<a.length-2;i++){
            
            if(i>0 && (a[i] == a[i-1])){
                continue;
            }
             
           int start = i+1;
           int end = a.length-1;
               
           while(start<end){
               if(end < a.length -1 && a[end] == a[end+1]){
                 end--;
                 continue;
               }
               
               if(a[i]+a[start]+a[end] == 0){
                   List<Integer> list = Arrays.asList(a[i],a[start],a[end]);
                   doublelist.add(list);
                   start++;
                   end--;
               }else if(a[i]+a[start]+a[end] < 0){
                   start++;
               }else{
                   end--;
               }
           }    
            
        }   
        return doublelist;
        
    }
}
