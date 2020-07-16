/*
Problem Description

Given two equally sized 1-D arrays A, B containing N integers each.
A sum combination is made by adding one element from array A and another element of array B.
Return the maximum C valid sum combinations from all the possible sum combinations.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 103
1 <= C <= N

Input Format
First argument is an one-dimensional integer array A of size N.
Second argument is an one-dimensional integer array B of size N.
Third argument is an integer C.

Output Format
Return a one-dimensional integer array of size C denoting the top C maximum sum combinations.

NOTE:
The returned array must be sorted in non-increasing order.

Example Input
Input 1:
 A = [3, 2]
 B = [1, 4]
 C = 2
 
Input 2:
 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
 C = 4
 
Example Output
Output 1:
 [7, 6]
 
Output 1:
 [10, 9, 9, 8]

Example Explanation
Explanation 1:
 7     (A : 3) + (B : 4)
 6     (A : 2) + (B : 4)
 
Explanation 2:
 10   (A : 4) + (B : 6)
 9   (A : 4) + (B : 5)
 9   (A : 3) + (B : 6)
 8   (A : 3) + (B : 5)
*/

class Node implements Comparable<Node>
{
    int i, j, sum;
    public Node(int i, int j, int sum)
    {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
    public int compareTo(Node n){
        return n.sum - this.sum;
    }
}
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
       
       Collections.sort(A,Collections.reverseOrder());
       Collections.sort(B,Collections.reverseOrder());
       
       PriorityQueue<Node> maxHeap = new PriorityQueue<>();
       for(int i=0; i<A.size(); i++){
           Node node = new Node(i,0,A.get(i) + B.get(0));
           maxHeap.add(node);
       }
       
       ArrayList<Integer> ans = new ArrayList<>();
       while(ans.size() < C){
           Node n1 = maxHeap.poll();
           ans.add(n1.sum);
           
           if(n1.j + 1 < B.size()){
               Node n2 = new Node(n1.i,n1.j + 1,A.get(n1.i) + B.get(n1.j + 1));
               maxHeap.add(n2);
           }
       }
       return ans;
    
    }
}
