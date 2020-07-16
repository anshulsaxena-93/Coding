/*
Problem Description

You are given K sorted integer arrays in a form of 2D integer matrix A of size K X N.
You need to merge them into a single array and return it.

Problem Constraints
1 <= K, N <= 103

0 <= A[i][j] <= 108
A[i][j] <= A[i][j+1]

Input Format
First and only argument is an 2D integer matrix A.

Output Format
Return a integer array denoting the merged array you get after merging all the arrays in A.

Example Input
Input 1:
 A = [  [1, 2, 3]
        [2, 4, 6]
        [0, 9, 10]
     ]

Example Output
Output 1:
 [0, 1, 2, 2, 3, 4, 6, 9, 10]


Example Explanation
Explanation 1:

 You need to merge [1, 2, 3] , [2, 4, 6] and [0, 9, 10]  into a single array
 so the merged array will look like [0, 1, 2, 2, 3, 4, 6, 9, 10]
*/

class Node implements Comparable<Node>{
    int i;
    int j;
    int val;
    public Node(int i,int j,int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }
    public int compareTo(Node n){
        return this.val - n.val;
    }
}

public class Solution {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for(int i=0; i<A.size(); i++){
            Node node = new Node(i,0,A.get(i).get(0));
            minHeap.add(node);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(minHeap.size() > 0){
            
            Node node = minHeap.poll();
            result.add(node.val);
            
            if((node.j + 1) < A.get(0).size()){
                Node n1 = new Node(node.i,node.j + 1,A.get(node.i).get(node.j+1));
                minHeap.add(n1);
            }
        }
        return result;
        
    }
}
