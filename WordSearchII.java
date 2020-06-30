/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.
*/

class TrieNode{
    TrieNode[] children;
    String word;
    TrieNode(){
        children = new TrieNode[26];
        for(int i=0; i<26; i++){
            children[i] = null;
        }
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
       
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                DFS(board,i,j,root,result);
            }
        }
        return result;

    }
    
    private void DFS(char[][] board,int i,int j,TrieNode root,List<String> result){
        
        char c = board[i][j];
        
        if(c == '*' || root.children[c - 'a'] == null){
            return;
        }
        
        root = root.children[c - 'a'];
        
        if(root.word != null){
            result.add(root.word);
            root.word = null;
        }
        
        board[i][j] = '*';
        
        if(i > 0) DFS(board,i-1,j,root,result);
        if(j > 0) DFS(board,i,j-1,root,result);
        if(i < board.length - 1) DFS(board,i+1,j,root,result);
        if(j < board[0].length -1) DFS(board,i,j+1,root,result);
        
        board[i][j] = c;
        
    }
    
    private TrieNode buildTrie(String[] words){
        
        TrieNode root = new TrieNode();
        
        for(int i=0; i<words.length; i++){
            
            String s = words[i];
            TrieNode curr = root;
            
            for(int j=0; j<s.length(); j++){
                
                if(curr.children[s.charAt(j) - 'a'] == null){
                    curr.children[s.charAt(j) - 'a'] = new TrieNode();
                    curr = curr.children[s.charAt(j) - 'a'];
                }
                else{
                    curr = curr.children[s.charAt(j) - 'a'];
                }
            }
            
            curr.word = s;
        }
        
        return root;
    }
}
