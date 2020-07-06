/*
Problem Description

You are given a AB character matrix named C. Every cell in C has a character U,R,L or D indicating up,right,left and down.

Your target is to go from top left corner to the bottom right corner of the matrix.

But there are some restrictions while moving along the matrix:

If you follow what is written in the cell then you can move freely.
But if you don't follow what is written in the cell then you have to pay 1 unit of cost.
Like: If a cell contains character U and you go right instead of Up you have to pay 1 unit of cost.

So your task is to find the minimum cost to go from top-left corner to the bottom-right corner.

Problem Constraints
1 <= A,B <= 103
C[i][j] can be either U,R,L or D.

Input Format
First Argument represents a integer A (number of rows).
Second Argument represents a integer B (number of columns).
Third Argument represents a string array C which contains A strings each of length B.

Output Format
Return an integer denoting the minimum cost to travel from top-left corner to bottom-right corner.

Example Input
Input:1

 A = 3
 B = 3
 C = ["RRR","DDD","UUU"]
Input:2

 A = 1
 B = 4
 C = ["LLLL"]


Example Output
Output-1 :

 1
Output-2 :

 3


Example Explanation*
Explanation for Input-1:

 Matrix looks like: RRR
                    DDD
                    UUU
 We go right two times and down two times.
 So from top-right cell we are going down though right is given so this incurs a cost of 1.
Explanation for Input-2:

 Matrix looks like: LLLL
 We go right three times.
 */
 
 class Tri implements Comparable<Tri>{
    int x;
    int y;
    int cost;
    Tri(int x,int y,int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    
    public int compareTo(Tri t){
        return this.cost - t.cost;
    }
}
public class Solution {
    
    int dx[]={-1,0,1,0};
    int dy[]={0,1,0,-1};
    char dir[]={'U','R','D','L'};
    
    public int solve(int A, int B, ArrayList<String> C) {
   
       boolean[][] visited = new boolean[A][B];
       
       int[][] cost = new int[A][B];
       for(int[] c : cost){
           Arrays.fill(c,Integer.MAX_VALUE);
       }
      
       PriorityQueue<Tri> pq = new PriorityQueue<>();
       pq.add(new Tri(0,0,0));
       visited[0][0] = true;
       cost[0][0] = 0;
       
       while(pq.size() > 0){
           
           Tri t = pq.poll();
           
           visited[t.x][t.y] = true;
           
           if(t.x == A-1 && t.y == B-1){
               return cost[t.x][t.y];
           }
           
           for(int i=0; i<4; i++){
               
               int cx = t.x + dx[i];
               int cy = t.y + dy[i];
               
               if(isValid(cx,cy,A,B) && !visited[cx][cy]){
                   if(C.get(t.x).charAt(t.y) == dir[i]){
                       if(cost[t.x][t.y] < cost[cx][cy]){
                           pq.add(new Tri(cx,cy,cost[t.x][t.y]));
                           cost[cx][cy] = cost[t.x][t.y];
                       }
                   }
                   else{
                       if(cost[t.x][t.y]+1 < cost[cx][cy]){
                           pq.add(new Tri(cx,cy,cost[t.x][t.y] + 1));
                           cost[cx][cy] = 1 + cost[t.x][t.y];
                       }
                   }
               }
               
           }
           
       }
       return cost[A-1][B-1];
    }
    
    private boolean isValid(int x,int y,int A,int B){
        if(x>=0 && x<A && y>=0 && y<B){
            return true;
        }
        return false;
    }
    
}
