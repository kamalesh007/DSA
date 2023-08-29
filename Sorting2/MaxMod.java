
// Given an array A of size N, Groot wants you to pick 2 indices i and j such that

// 1 <= i, j <= N
// A[i] % A[j] is maximum among all possible pairs of (i, j).
// Help Groot in finding the maximum value of A[i] % A[j] for some i, j.
public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0 ; i < A.length; i++)
        {
            max = Math.max(max,A[i]);            
        }
        
        for(int i = 0 ; i < A.length; i++)
        {
            if(A[i] < max)
            {
                secondMax = Math.max(secondMax,A[i]);            
            }
        }
        if(secondMax == Integer.MIN_VALUE)
        {
            secondMax = max;
        }
        return secondMax % max ;
    }
}
