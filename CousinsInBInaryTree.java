/*
Problem Description
Given a Binary Tree A consisting of N nodes.
You need to find all the cousins of node B.

NOTE:
Siblings should not be considered as cousins.
Try to do it in single traversal.
You can assume that Node B is there in the tree A.
Order doesn't matter in the output.

Problem Constraints
1 <= N <= 105
1 <= B <= N

Input Format
First Argument represents the root of binary tree A.
Second Argument is an integer B denoting the node number.

Output Format
Return an integer array denoting the cousins of node B.
NOTE: Order doesn't matter.

Example Input
Input 1:
 A =
           1
         /   \
        2     3
       / \   / \
      4   5 6   7 
      
B = 5

Input 2:
 A = 
            1
          /   \
         2     3
        / \     \
       4   5     6

B = 1

Example Output
Output 1:
 [6, 7]
 
Output 2:
 []

Example Explanation
Explanation 1:
 Cousins of Node 5 are Node 6 and 7 so we will return [6, 7]
 Remember Node 4 is sibling of Node 5 and do not need to return this.
 
Explanation 2:
 Since Node 1 is the root so it doesn't have any cousin so we will return an empty array.
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
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null){
            return result;
        }
        
        if(A.val == B){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        
        while(queue.size() > 0){
            
            int size = queue.size();
            boolean flag = false;
            
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                
                if((node.left != null && node.left.val == B)
                   || (node.right != null && node.right.val == B)){
                       flag = true;
                }
                else{
                    if(node.left != null){
                        result.add(node.left.val);
                    }
                    if(node.right != null){
                        result.add(node.right.val);
                    }
                }
            }
            
            if(flag){
                return result;    
            }
            else{
                result.clear();
            }
            
        }
        return result;
    }
}
