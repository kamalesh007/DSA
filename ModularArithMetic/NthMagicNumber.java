// Given an integer A, find and return the Ath magic number.

// A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.

// First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

public class Solution {
    public int solve(int A) {
        int ans=0;
        int pow=1;
        while(A!=0)
        {
            pow=pow*5;
            if((A&1)==1)
            {
                ans=ans+pow;
            }
            A=A>>1;
        }
        return ans;
    
    
    }
}
