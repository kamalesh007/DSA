//Given an array, A of integers of size N. Find the maximum value of j - i such that A[i] <= A[j].
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
        int ans = 0 ;
        for(int i = 0; i < A.length ; i++)
        {
            int lastPtr = A.length - 1;
            
            while(lastPtr > i)
            {
                if(A[lastPtr] >=A[i])
                {
                    ans = Math.max(ans,lastPtr-i);
                    break;
                }         
                else
                {
                    lastPtr -- ;
                }       
            }
        }
        return ans;
    }
}
