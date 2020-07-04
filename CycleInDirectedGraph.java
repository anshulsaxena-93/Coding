/*
Problem Description

Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges 
such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A(A-1))

1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return 1 if cycle is present else return 0.

Example Input
Input 1:

 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output
Output 1:

 1
Output 2:

 0

Example Explanation*
Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:

 The given graph doesn't contain any cycle.
*/

public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        
        HashMap<Integer,ArrayList<Integer>> adjMap = new HashMap<>();
        for(int i=0; i<B.size(); i++){
            int x = B.get(i).get(0);
            int y = B.get(i).get(1);
            
            if(adjMap.containsKey(x)){
                ArrayList<Integer> list = adjMap.get(x);
                list.add(y);
                adjMap.put(x,list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(y);
                adjMap.put(x,list);
            }
        }
        
        int[] state = new int[A+1];
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=A; i++){
           
           if(state[i] == 0){
               queue.add(i);
               state[i] = 1; //processing
               
               if(checkCycle(queue,state,adjMap) == true){
                   return 1;
               }
           } 
        }
        return 0;
    }
    
    private boolean checkCycle(Queue<Integer> queue,int[] state,
                               HashMap<Integer,ArrayList<Integer>> adjMap){
    
        while(queue.size() > 0){
            
            int size = queue.size();
            
            ArrayList<Integer> al = new ArrayList<>();
            for(int j=0; j<size; j++){
                
             int node = queue.poll();
             al.add(node);
             
             if(adjMap.containsKey(node)){
                
                ArrayList<Integer> list = adjMap.get(node);
                for(int i=0; i<list.size(); i++){
                    
                    if(state[list.get(i)] == 0){ //untouched
                        queue.add(list.get(i));
                        state[list.get(i)] = 1; //processing
                    }
                    else if(state[list.get(i)] == 1){
                        //ignore
                    }
                    else if(state[list.get(i)] == 2){
                        return true;  //cycle found (difference in result with UnDiretced graph)
                    }
                }
              }
                
            }
            
            for(int j=0; j<al.size(); j++){
                state[al.get(j)] = 2; //processed
            }
            
        }    
        return false;                           
    }
}
