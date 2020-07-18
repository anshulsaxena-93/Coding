/*
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]]

Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .

Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]

Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
*/  

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if(map.containsKey(a)){
                ArrayList<Integer> list = map.get(a);
                list.add(b);
                map.put(a,list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a,list);
            }
        }
        
        int[] visited = new int[numCourses];
        Arrays.fill(visited,-1);
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(visited[i] == -1){  //Not yet processed
                //check cycle
                if(checkCycle(i,visited,result,map) == true){
                   result.clear();
                   int[] empty = new int[result.size()];
                   return empty;
                }
            }
        }
         int[] ans = new int[result.size()];
         for(int i=0; i<ans.length; i++){
             ans[i] = result.get(i);
         }
         return ans;
    }
    
    private boolean checkCycle(int i,int[] visited,ArrayList<Integer> result,
                        HashMap<Integer,ArrayList<Integer>> map){
        
        visited[i] = 0; //InProcess
        
        if(map.containsKey(i)){
            ArrayList<Integer> list = map.get(i);
            for(int j=0; j<list.size(); j++){
                int k = list.get(j);
                if(visited[k] == -1){
                    if(checkCycle(k,visited,result,map) == true){
                        return true;
                    }
                }
                else if(visited[k] == 0){
                    return true;
                }
                else if(visited[k] == 1){
                    //ignore do nothing
                }
            }
        }
        
        visited[i] = 1; //processed
        result.add(i);
        return false;
    }
}
