// Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

public class Solution {
    public int findMinXor(int[] A) {
    
    Arrays.sort(A);
    int ans = Integer.MAX_VALUE;
    for(int i = 0 ; i < A.length-1;i++)
    {
        int k =A[i]^A[i+1];
        ans = Math.min(ans,k);
    }
    return ans;
    
    }
}
