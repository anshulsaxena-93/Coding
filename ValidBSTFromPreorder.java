/*
Problem Description
You are given a preorder traversal A, of a Binary Search Tree.
Find if it is a valid preorder traversal of a BST.

Problem Constraints
1 <= A[i] <= 106
1 <= |A| <= 105

Input Format
First and only argument is an integer array A denoting the pre-order traversal.

Output Format
Return an integer:
0 : Impossible preorder traversal of a BST
1 : Possible preorder traversal of a BST

Example Input
Input 1:
A = [7, 7, 10, 10, 9, 5, 2, 8]

Example Output
Output 1:
0
*/
public class Solution {
    public int solve(ArrayList<Integer> A) {
        if(checkValidBST(0,A.size()-1,A) == true){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    private boolean checkValidBST(int start,int end,ArrayList<Integer> A){
        
        if(start >= end){
            return true;
        }
        
        int root = A.get(start);
        
        int i = start + 1;
        for(i = start + 1; i<=end; i++){
            if(A.get(i) > root){
                break;
            }
        }
        
        for(int j=i; j<=end; j++){
            if(A.get(j) <= root){
                return false;
            }
        }
        
        return checkValidBST(start+1,i-1,A) || checkValidBST(i,end,A);
    }
}
