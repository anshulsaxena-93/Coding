/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildBT(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    
    private TreeNode buildBT(int[] inorder,int[] postorder,int ISI,int IEI,int PSI,int PEI){
        
        if(PSI > PEI){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[PEI]);
        if(PSI == PEI){
            return root;
        }
        
        int i = ISI;
        for(i = ISI; i <= IEI; i++){
            if(inorder[i] == root.val){
                break;
            }
        }
        
        int count = (i - ISI);
        
        root.left = buildBT(inorder,postorder,ISI,i-1,PSI,PSI+count-1);
        root.right = buildBT(inorder,postorder,i+1,IEI,PSI+count,PEI-1);
        
        return root;
        
    }
}
