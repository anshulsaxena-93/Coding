class TrieNode{
    TrieNode[] children=null;
    TrieNode(){
        children = new TrieNode[26];
        Arrays.fill(children,null);
    }
}
class Solution {
    
    public String longestDupSubstring(String S) {
        
        int low = 1;
        int high = S.length();
        
        String result = "";
        while(low <= high){
            int mid = low + (high-low)/2;
            
            String str = search(S,mid);
            if(str.length() > 0){
                low = mid + 1;
                if(str.length() > result.length()){
                    result = str;
                }
            }
            else{
                high = mid - 1;
            }
        }
        return result;
    }
    
    private String search(String s,int len){
        
        TrieNode root = new TrieNode();
        
        TrieNode curr = root;
        for(int i=0; i<len; i++){
            if(curr.children[s.charAt(i) - 'a'] == null){
                curr.children[s.charAt(i) - 'a'] = new TrieNode();
                curr = curr.children[s.charAt(i) - 'a'];
            }
        }
        
        
        for(int i=1; i < (s.length() - len + 1); i++){
            
            curr = root;
            
            for(int j=i; j < (i + len); j++){
                if(curr.children[s.charAt(j) - 'a'] != null){
                    curr = curr.children[s.charAt(j) - 'a'];
                    
                    if(j == (i + len -1)){
                        return (s.substring(i,i + len));
                    }
                }
                else{
                     curr.children[s.charAt(j) - 'a'] = new TrieNode();
                     curr = curr.children[s.charAt(j) - 'a'];
                }
            }
            
        }
        return "";
    }
   
}
