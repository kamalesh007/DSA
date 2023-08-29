// Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

// NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans=0;
        for(int i=0;i<A.length;i++)
        {
            ans=ans^(A[i]);
        }
        return ans;
    }
}
