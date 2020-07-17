/*
Problem Description
Given a binary tree A consisting of N nodes, return a 2-D array denoting the vertical order traversal of A.
Go through the example and image for more details.

NOTE:
If 2 or more Tree Nodes shares the same vertical level then the one with earlier occurence in the level-order(pre-order in original question)
traversal of tree comes first in the output.
Row 1 of the output array will be the nodes on leftmost vertical line similarly last row of the output array will be the nodes on the rightmost vertical line.

Problem Constraints
0 <= N <= 104

Input Format
First and only argument is an pointer to root of the binary tree A.

Output Format
Return a 2D array denoting the vertical order traversal of A.

Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
 
Input 2:
           1
         /   \
        2     3
       / \
      4   5


Example Output
Output 1:
 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
 
Output 2:
 [
    [4],
    [2],
    [1, 5],
    [3]
 ]


Example Explanation
Explanation 1:
 Nodes on Vertical Line 1: 2
 Nodes on Vertical Line 2: 3
 Nodes on Vertical Line 3: 6, 5
  As 6 and 5 are on the same vertical level but as 6 comes first in the pre-order traversal of the tree so we will output 6 before 5.
 Nodes on Vertical Line 4: 7
 Nodes on Vertical Line 5: 9

Explanation 2:
 Nodes on Vertical Line 1: 4
 Nodes on Vertical Line 2: 2
 Nodes on Vertical Line 3: 1, 5
 Nodes on Vertical Line 4: 3
 */
 
 /**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
class Node{
    TreeNode tnode;
    int level;
    public Node(TreeNode tnode,int level){
        this.tnode = tnode;
        this.level = level;
    }
}
public class Solution {
    
   public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
    
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       if(A == null) return result;
        
       Queue<Node> queue = new LinkedList<>();
       queue.add(new Node(A,0));
       
       Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
       
       while(queue.size() > 0){
           
           Node node = queue.poll();
           
           TreeNode tnode = node.tnode;
           
           if(map.containsKey(node.level)){
               ArrayList<Integer> list = map.get(node.level);
               list.add(tnode.val);
               map.put(node.level,list);
           }
           else{
               ArrayList<Integer> list = new ArrayList<>();
               list.add(tnode.val);
               map.put(node.level,list);
           }
           
           if(tnode.left != null){
               queue.add(new Node(tnode.left,node.level - 1));
           }
           
           if(tnode.right != null){
               queue.add(new Node(tnode.right,node.level + 1));
           }
           
       }
       
       Iterator<Integer> itr = map.keySet().iterator();
       while(itr.hasNext()){
           result.add(map.get(itr.next()));
       }
       return result;
     
    }
}

 
