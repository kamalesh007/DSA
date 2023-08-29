// Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
// Assume that no characters are repeated.

// Note: The answer might not fit in an integer, so return your answer % 1000003
public class Solution {
    public int findRank(String A) {
    int len = A.length();
    int ans = 0;
    for(int i=0;i<len;i++)
    {
        int asci = (int)A.charAt(i);
        int count = 0;
        for(int j = i+1;j<len;j++)
        {
            int compareAsci = (int)A.charAt(j);
            if(compareAsci < asci)
            {
                count++;
            }
        }
        int noOfPosavail = len - (i+1) ;
        
        int contri = ((count%1000003) * fact(noOfPosavail, 1000003)) % 1000003;

        ans = ans%1000003 + contri%1000003;

    }

    return ans+1;
    
    }

    public int fact(int N,int P)
    {
        int ans = 1;
        for(int i =1;i<=N;i++)
        {
            ans = (ans * i) % P;
        }
        return ans;
    }
}
