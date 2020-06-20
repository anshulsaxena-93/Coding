public String longestCommonSubstring(String S) {
        
        int[][] dp = new int[S.length()+1][S.length()+1];
        for(int i=0; i<=S.length(); i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=S.length(); j++){
            dp[0][j] = 0;
        }
        
       int maxLength = 0;
       int m=0,n=0;
        for(int i=1; i<=S.length(); i++){
            for(int j=1; j<=S.length(); j++){
                
                if(S.charAt(i-1) == S.charAt(j-1) && i != j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(maxLength < dp[i][j]){
                        maxLength = dp[i][j];
                        m = i;
                        n = j;
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(maxLength > 0 && m > 0 && n > 0){
            sb.append(S.charAt(m-1));
            m--;
            n--;
            maxLength--;
        }
        
        return sb.reverse().toString();
    }
}    
