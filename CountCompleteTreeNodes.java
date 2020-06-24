/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
  Time Complexity (logN * logN)
*/
class Solution {
    public int countNodes(TreeNode root) {
        return count(root);
    }
    
    private int count(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        //count extreme left depth
        int leftDepth = 0;
        TreeNode leftNode = root;
        while(leftNode != null){
            leftDepth++;
            leftNode = leftNode.left;
        }
        
        //count extreme right depth
        int rightDepth = 0;
        TreeNode rightNode = root;
        while(rightNode != null){
            rightDepth++;
            rightNode = rightNode.right;
        }
        
        //if both the depths are same then its a perfect binary tree, hence the nnumber of nodes = 2 ^ depth - 1;
        if(leftDepth == rightDepth){
            return (int)Math.pow(2,leftDepth) - 1;
        }
        
        //coun the number of nodes in left subtree + right subtree + 1(for current node)
        return 1 + count(root.left) + count(root.right);
        
    }
    
}
