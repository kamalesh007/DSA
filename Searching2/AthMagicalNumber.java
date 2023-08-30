// You are given three positive integers, A, B, and C.

// Any positive integer is magical if divisible by either B or C.

// Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

// Note: Ensure to prevent integer overflow while calculating.

public class Solution {
    public int solve(int A, int B, int C) {
    int mod = 1000000000+7;
    int min = Math.min(B,C);
    long low = (long)min;
    long high = (long)A * min;

    long lcm = ( B * C ) / gcd(B,C);

    while(low <= high)
    {
        long mid = (low + ((high-low)/2));
        long count = (mid/B) + (mid/C) - (mid/lcm);
        // if((count == A) && ((mid % B == 0) || (mid % C == 0 )))
        // {
        //     return (int)(mid % mod);
        // }
        if (count < A)
        {
            low = (mid + 1) ;
        }
        else
        {
            high = (mid - 1);
        }

    }
    
    return (int)(low%mod);

    }


    public long gcd(long A, long B) {
        if(B==0) return A;
        else return gcd(B,A%B);    
    }
}
