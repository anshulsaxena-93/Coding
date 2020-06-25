/*
How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4 
so minimum numbers will be 2
*/

public class Solution {
    
    HashMap<String,Integer> map = null;
    public int fibsum(int A) {
        //map = new HashMap<>();
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        while(fib.get(fib.size() - 1) < A){
            fib.add(fib.get(fib.size()-1) + fib.get(fib.size()-2));
        }
        return min1(fib,A);
    }
   
   // greedy approach -> https://en.wikipedia.org/wiki/Zeckendorf%27s_theorem
   /*
    if fibonnacci(i) <= N 
        then 1 + fibonacci(N - fibonacci(i)) 
      else move to lower fibonacci number (i--);
   */  
    private int min1(ArrayList<Integer> fib,int sum){
        
        int count = 0;
        
        int i = fib.size() - 1;
        while(sum > 0){
            
            if(sum >= fib.get(i)){
                sum = sum - fib.get(i);
                count++;
            }
            else{
                i--;
            }
            
        }
        return count;
    }
    
    //dp
    private int min2(ArrayList<Integer> fib,int sum){
        
        int dp[][] = new int[fib.size()+1][sum+1];
        for(int i=0; i<=fib.size(); i++){
            dp[i][0] = 0;
        }
        
        for(int j=1; j<=sum; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        
        for(int i=1; i<=fib.size(); i++){
            for(int j=1; j<=sum; j++){
                
                if(fib.get(i-1) <= j){
                    dp[i][j] = Math.min(1 + dp[i][j - fib.get(i-1)], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[fib.size()][sum];
    }
    
    private int min3(int i,ArrayList<Integer> fib,int sum){
        
        String key = i + "|" + sum;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        if(sum == 0){
            map.put(key,0);
            return 0;
        }
        
        if(i == fib.size()){
            return Integer.MAX_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        if(fib.get(i) <= sum){
            
            int a = min3(i,fib,sum - fib.get(i));
            if(a != Integer.MAX_VALUE){
               a = a + 1;    
            }
            
            int b = min3(i+1,fib,sum);
            
            if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE){
                //do nothing
            }
            else{
              min =  Math.min(a,b);  
            }
        }
        map.put(key,min);
        return min;
    }
}
