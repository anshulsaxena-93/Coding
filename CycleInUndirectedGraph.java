/*
Problem Description

Given an undirected graph having A nodes labelled from 1 to A 
with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
1 <= A, M <= 3105

1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].

Output Format
Return 1 if cycle is present else return 0.

Example Input
Input 1:

 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]
Input 2:

 A = 3
 B = [  [1. 2]
        [1, 3]
     ]


Example Output
Output 1:

 1
Output 2:

 0

Example Explanation*
Explanation 1:

 There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1
Explanation 2:

 No cycle present in the graph so we will return 0.
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
            
            if(adjMap.containsKey(y)){
               ArrayList<Integer> list = adjMap.get(y);
               list.add(x);
               adjMap.put(y,list);
            }
            else{
               ArrayList<Integer> list = new ArrayList<>();
               list.add(x);
               adjMap.put(y,list); 
            }
        }
        
        int[] state = new int[A+1];
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=A; i++){
            
            if(state[i] == 0){ //untouched
                
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
            for(int i=0; i<size; i++){
                
                int node = queue.poll();
                al.add(node);
                
                if(adjMap.containsKey(node)){
                    ArrayList<Integer> list = adjMap.get(node);
                    
                    for(int j=0; j<list.size(); j++){
                        
                        if(state[list.get(j)] == 0){ //untouched
                            queue.add(list.get(j));
                            state[list.get(j)] = 1; //processing
                        }
                        else if(state[list.get(j)] == 1){ //processing
                            return true; //cycle found (difference in result with Diretced graph)
                        }
                        else if(state[list.get(j)] == 2){ //processed
                           //ignore;
                        }
                        
                    }
                }
            }
            
            for(int i=0; i<al.size(); i++){
                state[al.get(i)] = 2; //processed
            }
            
        }
        return false;
    }
}
