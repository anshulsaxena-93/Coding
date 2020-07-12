/*
Problem Description

Given a 2D binary matrix A of size  N x M  find the area of maximum size square sub-matrix with all 1's.

Problem Constraints
1 <= N, M <= 103
A[i][j] = 1 or A[i][j] = 0

Input Format
First argument is an 2D matrix A of size N x M.

Output Format
Output the area of maximum size square sub-matrix in A with all 1's.

Example Input
Input 1:

 A = [
        [0, 1, 1, 0, 1],
        [1, 1, 0, 1, 0],
        [0, 1, 1, 1, 0],
        [1, 1, 1, 1, 0],
        [1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0]
     ]
Input 2:

 A = [
       [1, 1],
       [1, 1]
     ]


Example Output
Output 1:
 9
 
Output 2:
 4

Example Explanation
Explanation 1:

  Consider the below binary matrix.
 
 The area of the square is 3 * 3 = 9
Explanation 2:

 The given matrix is the largest size square possible so area will be 2 * 2 = 4
*/ 

public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        
        int m = A.size();
        int n = A.get(0).size();
        
        if(m == 0){
            return 0;
        }
        
        int[] arr = new int[n];
        Arrays.fill(arr,0);
        
        int maxArea = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(A.get(i).get(j) == 0){
                    arr[j] = 0;
                }
                else{
                    arr[j] = arr[j] + 1;
                }
            }
            
            int[] nsl = NSL(arr);
            int[] nsr = NSR(arr);
            
            for(int j=0; j<arr.length; j++){
                int width = nsr[j] - nsl[j] - 1;
                if(width >= arr[j]){
                    int area = arr[j] * arr[j];
                    maxArea = Math.max(area,maxArea);
                }
            }
            
        }
        return maxArea;
    }
    
    private int[] NSL(int[] arr){
        int[] nsl = new int[arr.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(st.isEmpty()){
                nsl[i] = -1;
                st.push(i);
            }
            else{
                if(arr[i] > arr[st.peek()]){
                    nsl[i] = st.peek();
                    st.push(i);
                }
                else if(arr[i] <= arr[st.peek()]){
                    while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                        st.pop();
                    }
                    
                    if(st.isEmpty()){
                        nsl[i] = -1;
                        st.push(i);
                    }
                    else{
                        nsl[i] = st.peek();
                        st.push(i);
                    }
                }
            }
        }
        return nsl;
    }
    
    private int[] NSR(int[] arr){
        int[] nsr = new int[arr.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=arr.length-1; i>=0; i--){
            if(st.isEmpty()){
                nsr[i] = arr.length;
                st.push(i);
            }
            else{
                if(arr[i] > arr[st.peek()]){
                    nsr[i] = st.peek();
                    st.push(i);
                }
                else if(arr[i] <= arr[st.peek()]){
                    while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                        st.pop();
                    }
                    
                    if(st.isEmpty()){
                        nsr[i] = arr.length;
                        st.push(i);
                    }
                    else{
                        nsr[i] = st.peek();
                        st.push(i);
                    }
                }
            }
        }
        return nsr;
    }
}
