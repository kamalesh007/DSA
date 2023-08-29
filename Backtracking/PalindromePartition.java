// Given a string A, partition A such that every string of the partition is a palindrome.

// Return all possible palindrome partitioning of A.

// Ordering the results in the answer : Entry i will come before Entry j if :
// len(Entryi[0]) < len(Entryj[0]) OR
// (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
// (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
public class Solution {
	
    public ArrayList<ArrayList<String>> ans;

    public ArrayList<ArrayList<String>> partition(String a) {
        ans=new ArrayList<ArrayList<String>>();
        partitionPalindrome(0,new ArrayList<String>(),a);
        return ans;
	}

    public Boolean isPalindrome(int s,int e,String str)
    {
        while(s<e)
        {
            if(str.charAt(s)!=str.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }

    public void partitionPalindrome(int startIndex,ArrayList<String> current,String s)
    {
        if(startIndex == s.length())
        {
            
        	ans.add((ArrayList<String>)current.clone());
            return;
        }
        for(int j=startIndex;j<s.length();j++)
        {
            // Check whether from startIndex to is a palindrome or Not
            if(isPalindrome(startIndex,j,s))
            {
                String leftSubStr=s.substring(startIndex,startIndex+(j-startIndex+1));
                current.add(leftSubStr);
                partitionPalindrome(j+1,current,s);
                current.remove(current.size()-1);
            }

        }
    }

}
