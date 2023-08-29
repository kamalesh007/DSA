// Given an integer array, A of size N.
// You have to find all possible non-empty subsequences of the array of numbers and then,
// for each subsequence, find the difference between the largest and smallest number in that subsequence.
// Then add up all the differences to get the number.

// As the number may be large, output the number modulo 1e9 + 7 (1000000007).

// NOTE: Subsequence can be non-contiguous.

public class Solution {
    public int solve(int[] A) {
    int mod = 1000000000+7;
    Arrays.sort(A);

    int N = A.length;

    long[] p2 = new long[N];

    p2[0] = 1L;

    for(int i = 1; i < N ; i++)
    {
        p2[i] = ((p2[i-1] % mod) * 2L) % mod;
    }

    long  ans = 0;
    for(int i = 0 ; i < N ; i++)
    {
        long  ele = A[i];

        long  maxOccurences = p2[i];
        
        long  minOccurences = p2[N-i-1];
        
        long  contribution = (A[i] * (maxOccurences - minOccurences)) % mod;

        System.out.print(contribution+"\t");

        ans = (ans + contribution) % mod;

    }
    
    return (int)ans;
    
    }
}
