// Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

// Since the answer may be large, return the answer modulo (109 + 7).

// Note: Ensure to handle integer overflow when performing the calculations.
public class Solution {
    public int solve(int[] A, int B) {
        long[] cnt=new long[B];
        int mod=1000000007;
        for(int i=0;i<B;i++)
        {
            cnt[i]=0L;
        }
        for(int i=0;i<A.length;i++)
        {
            cnt[A[i]%B]++;
        }
        long ans=(cnt[0]*(cnt[0]-1))/2;
        ans=ans%mod;
        int i=1;
        int j=B-1;
        while(i<=j)
        {
            if(i==j)
            {
                ans+=((cnt[i]*(cnt[i]-1)))/2;
                ans=ans%mod;
            }
            else
            {
                ans+=(cnt[i]*cnt[j]);
                ans=ans%mod;
            }
            i++;
            j--;
        }
        return ((int)(ans))%mod;
    }
}
