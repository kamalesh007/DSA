// Given a string A and a dictionary of words B, add spaces in A to construct a sentence where each word is a valid dictionary word.

// Return all such possible sentences.

public class Solution {
    
    public HashSet<String> dictionary;
    public ArrayList<String> ans;
    public String[] wordBreak(String A, String[] B) {
        for(int i = 0 ; i < B.length; i++)
        {
            dictionary.add(B[i]);
        }
        
    }

    public void solve(String A,int start,int end,ArrayList<String> arr)
    {
        if(start > end)
        {
            String addToAns = "";
            for(String str : arr)
            {
                addToAns += str +" ";
            }
            addToAns.trim();

        }
    }
}
