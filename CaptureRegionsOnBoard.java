/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/

public class Solution {
    public void solve(ArrayList<ArrayList<Character>> a) {
        
        int m = a.size();
        if(m == 0){
            return;
        }
        
        int n = a.get(0).size();
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                visited[i][j] = -1; //Not touched at all
            }
        }
        
        for(int i=0; i<m; i++){
            DFS(a,visited,i,0);
            DFS(a,visited,i,n-1);
        }
        
        for(int j=1; j<n-1; j++){
            DFS(a,visited,0,j);
            DFS(a,visited,m-1,j);
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                //if they are touched then they will remain unchanged either the are 'X' or 'O'
                if(visited[i][j] == 0){
                    //continue;
                }
                
                //Not touched at all it means they are are not connected to any 'O on the edges
                //hence they can be captured
                else if(visited[i][j] == -1){ 
                    a.get(i).set(j,'X');
                }
            }
        }
        
    }
    
    private void DFS(ArrayList<ArrayList<Character>> a,int[][] visited,int i,int j){
        
        if(visited[i][j] == 0){
            return;
        }
        
        if(a.get(i).get(j) == 'X'){
            visited[i][j] = 0;
            return;
        }
        
        if(a.get(i).get(j) == 'O'){
            visited[i][j] = 0;
            
            if(i+1 < a.size()){
                DFS(a,visited,i+1,j);
            }
            
            if(i-1 >= 0){
                DFS(a,visited,i-1,j);
            }
            
            if(j+1 < a.get(i).size()){
                DFS(a,visited,i,j+1);
            }
            
            if(j-1 >= 0){
                DFS(a,visited,i,j-1);
            }
        }
        
    }
}
