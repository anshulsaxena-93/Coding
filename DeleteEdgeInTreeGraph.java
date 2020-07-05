/*
Problem Description

Given a undirected tree with N nodes labeled from 1 to N.

Each node has a certain weight assigned to it given by an integer array A of size N.

You need to delete an edge in such a way that Product between sum of weight of nodes in one subtree with sum of weight of nodes in other subtree is maximized.

Return this maximum possible product modulo 109 + 7.

NOTE:

The tree is rooted at node labeled with 1.

Problem Constraints
2 <= N <= 105
1 <= A[i] <= 103

Input Format
First argument is an integer array A of size N denoting the weight of each node.
Second argument is a 2-D array B of size (N-1) x 2 denoting the edge of the tree.

Output Format
Return a single integer denoting the maximum product prossible of sum of weights of nodes in the two subtrees formed by deleting an edge with modulo 109 + 7.

Example Input
Input 1:

 A = [10, 5, 12, 6]
 B = [

        [1, 2]
        [1, 4]
        [4, 3]
     ]
Input 2:

 A = [11, 12]
 B = [

        [1, 2]
     ]


Example Output
Output 1:

 270
Output 2:

 132


Example Explanation
Explanation 1:

 Removing edge (1, 4) created two subtrees.
 Subtree-1 contains nodes (1, 2) and Subtree-2 contains nodes (3, 4)
 So product will be = (A[1] + A[2]) * (A[3] + A[4]) = 15 * 18 = 270
Explanation 2:

 Removing edge (1, 2) created two subtrees.
 Subtree-1 contains node (1) and Subtree-2 contains node (3)
 So product will be = (A[1]) * (A[2]) = 11 * 12 = 132
 */
 
 public class Solution {
    static int mod = 1000000007;
    public int deleteEdge(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        
        long totalSum = 0;
        for(int i=0; i<A.size(); i++){
            totalSum = totalSum + A.get(i);
        }
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<B.size(); i++){
            int x = B.get(i).get(0);
            int y = B.get(i).get(1);
            
            if(map.containsKey(x)){
                ArrayList<Integer> list = map.get(x);
                list.add(y);
                map.put(x,list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(y);
                map.put(x,list);
            }
            
            if(map.containsKey(y)){
                ArrayList<Integer> list = map.get(y);
                list.add(x);
                map.put(y,list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(x);
                map.put(y,list);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        HashSet<Integer> visited = new HashSet<>();
        visited.add(1);
        
        long maxProd = 0;
        while(queue.size() > 0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int n = queue.poll();
                if(map.containsKey(n)){
                    ArrayList<Integer> list = map.get(n);
                    for(int j=0; j<list.size(); j++){
                        if(!visited.contains(list.get(j))){
                            HashSet<Integer> v = new HashSet<>();
                            v.add(n);
                            long sum1 = DFS(list.get(j),v,map,A);
                            long sum2 = totalSum - sum1;
                            long prod = ((sum1 % mod) * (sum2 % mod)) % mod;
                            maxProd = Math.max(prod,maxProd);
                            queue.add(list.get(j));
                            visited.add(list.get(j));
                        }
                    }
                }
            }
        }
        
        return (int)maxProd;
    }
    
   private long DFS(int n,HashSet<Integer> visited,
                   HashMap<Integer,ArrayList<Integer>> map,ArrayList<Integer> A)
   {
       
       long sum = A.get(n-1);
       visited.add(n);
       
       if(map.containsKey(n)){
           ArrayList<Integer> list = map.get(n);
           for(int i=0; i<list.size(); i++){
               if(!visited.contains(list.get(i))){
                   sum = ((sum % mod) + (DFS(list.get(i),visited,map,A) % mod)) % mod;
               }
           }
       }
       return sum;
   }
}
