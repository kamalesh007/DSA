// Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.

// What is the most number of chunks we could have made

public class Solution {
    public int solve(int[] A) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < A.length ; i++)
        {
            max = Math.max(max,A[i]);
            if(max == i)
            {
                count ++;
            }
        }
        return count;
    }
}
