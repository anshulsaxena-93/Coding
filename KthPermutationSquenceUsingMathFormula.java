/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/

class Solution {

    int[] fact = new int[10];
    ArrayList<Integer> listOfNumbers = null;
    
    public String getPermutation(int n, int K) {
        
        
        //Fill factorial table from 0 -> 9
        fillFact();
        
        //Fill list of eligible numbers
        listOfNumbers = new ArrayList<>();
        fillListOfNumbers(n);
        
        return KthPermSequence(K-1); //just to be aligned with List Index that why K-1;

    }
    
    private String KthPermSequence(int K){
        
        if(listOfNumbers.size() == 0){
            return "";
        }
        
        //Find the index of List which element to be picked
        //find the bucket in which K will land -> K / (n-1)!
        int index = K / fact[listOfNumbers.size() - 1];
        
        //Take the digit and append it to the list
        StringBuilder sb = new StringBuilder();
        sb.append(listOfNumbers.get(index));
        
        //Update K -> after landing into a particular bucket update the K for Subbucket
        K = K % fact[listOfNumbers.size() - 1];
        
        //Remove the element which is already added from List
        listOfNumbers.remove(index);
        
        return (sb.toString() + KthPermSequence(K));
    }
    
    private void fillFact(){
       
        fact[0] = 1;
        
        for(int i = 1; i <= 9; i++){
            fact[i] = i * fact[i-1];
        }
    }
    
    private void fillListOfNumbers(int n){
        
        for(int i=1; i<=n; i++)
        {
            listOfNumbers.add(i);
        }
    }
    
}
