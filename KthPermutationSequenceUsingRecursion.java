class Solution {
    
    int K = 0;
    int targetK = 0;
    String str = null;
    
    public String getPermutation(int n, int k) {
        targetK = k;
        K = 0;
        KComb(new HashSet<>(),"",n);
        return str;
    }
    
    private boolean KComb(HashSet<Integer> set,String s,int n){
        
        if(set.size() == n){
            K++;
            if(K == targetK){
                str = new String(s);
                return true;
            }
            else{
                return false;
            }
        }
        
        for(int i=1; i<=n; i++){
            
            if(set.contains(i)){
                continue;
            }
            else{
                set.add(i);
                boolean flag = KComb(set, s + "" + i, n);
                if(flag == true){
                    return true;
                }
                else{
                    set.remove(Integer.valueOf(i));
                }
            }
            
        }
        return false;
    }
}
