/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth 
of the two subtrees of every node never differ by more than 1. 

Example :

Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3

*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 
public class Solution {
    
    public TreeNode sortedListToBST(ListNode list) {
        
        if(list == null){
            return null;
        }
        
        if(list.next == null){
            return new TreeNode(list.val);
        }
        
        ListNode midNode = getMiddleNode(list);
        
        TreeNode root = new TreeNode(midNode.val);
        root.left = sortedListToBST(list);
        root.right = sortedListToBST(midNode.next);
        
        return root;
        
    }
    
    private ListNode getMiddleNode(ListNode list){
        
        ListNode n1 = list;
        ListNode n2 = list;
        ListNode prev = null;
        
        while(n2 != null && n2.next != null){
            prev = n1;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        
        //To split the list into 2 parts
        if(prev != null){
            prev.next = null;
        }
        
        return n1; 
    }
}
