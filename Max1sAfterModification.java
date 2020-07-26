/*
You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.
*/
public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        
        int i=0,j=0,c=B;
        int start=0,end=0;
        
        while(i<A.size() && j<A.size()){
            
            if(A.get(j)==1){
                j++;
            }else if(A.get(j)==0 && c>0){
                j++;
                c--;
            }else if(A.get(j)==0 && c<=0){
                
                int currLength = j-i;
                int maxLength = end-start;
                
                if(currLength>maxLength){
                    start=i;
                    end=j;
                }
                
                i++;
                j=i;
                c=B;
                
            }
            
        }
        
        int currLength = j-i;
        int maxLength = end-start;
                
        if(currLength>maxLength){
                    start=i;
                    end=j;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int k=start;k<end;k++){
            result.add(k);
        }
        return result;
    }
}
