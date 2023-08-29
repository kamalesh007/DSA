// We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
// For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

// You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

public class Solution {
    public int cntBits(int[] A) {
        long ans=0;
        for(int i=0;i<=31;i++)
        {
            long count0=0;
            long count1=0;
            int bitpos=(1<<i);
            for(int j=0;j<A.length;j++)
            {
                int element=A[j];
                if((bitpos & element)!=0)
                {
                    count1++;
                }
                else
                {
                    count0++;
                }
            }
            long contribution= (count1*count0)*2;
            ans+=contribution;
            ans=ans%1000000007;
        }
        return (int)(ans);
    }
}
