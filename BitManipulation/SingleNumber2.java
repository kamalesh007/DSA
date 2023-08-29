// Given an array of integers, every element appears thrice except for one, which occurs once.

// Find that element that does not appear thrice.

// NOTE: Your algorithm should have a linear runtime complexity.

// Could you implement it without using extra memory?

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int len = A.length;
        int ans = 0;
        for(int i = 0 ; i < 32 ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < len ; j++)
            {
                if(((1<<i)&A[j]) !=0 )// SET
                {
                    count++;
                }
            }
            if(count % 3 !=0)
            {
                ans = ans | (1<<i);
            }
        }
        return ans;
    
    }
}
