/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
class Pair{
    UndirectedGraphNode node;
    UndirectedGraphNode clone;
    Pair(UndirectedGraphNode node,UndirectedGraphNode clone){
        this.node = node;
        this.clone = clone;
    }
} 
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        Queue<Pair> queue = new LinkedList<>();
        UndirectedGraphNode cloneNode = 
                         new UndirectedGraphNode(node.label);
        Pair pair = new Pair(node,cloneNode);                 
        queue.add(pair);
        
        HashMap<UndirectedGraphNode,UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node,cloneNode);
        
        UndirectedGraphNode root = null;
        while(queue.size() > 0){
            
            int size = queue.size();
            
            for(int i=1; i<=size; i++){
                
                Pair p = queue.poll();
                
                if(root == null){
                    root = p.clone;
                }
                
                for(int j=0; j<p.node.neighbors.size(); j++){
                    
                    UndirectedGraphNode nodeNeighbor = p.node.neighbors.get(j);
                    
                    if(!visited.containsKey(nodeNeighbor)){
                        UndirectedGraphNode cloneNeighbor = 
                         new UndirectedGraphNode(nodeNeighbor.label);
                        
                        p.clone.neighbors.add(cloneNeighbor);
                        
                        Pair p1 = new Pair(nodeNeighbor,cloneNeighbor);
                        queue.add(p1);
                        visited.put(nodeNeighbor,cloneNeighbor);
                    }
                    else{
                        UndirectedGraphNode cloneNeighbor = visited.get(nodeNeighbor);
                        p.clone.neighbors.add(cloneNeighbor);
                    }
                    
                }
            }
            
        }
        return root;
    }
}
