// Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.

public class Solution {
    public int solve(int[] A, int B) {
    
    long[] prefixSum = new long[A.length+1];

    prefixSum[0] = 0;

    for(int i = 0 ; i < A.length ; i++)
    {
        prefixSum[i+1] = prefixSum[i] + A[i];
    }
    
    int low = 1;

    int high = A.length;

    while(low <= high)
    {
        int mid = (low+high)/2;

        if(check(mid,prefixSum,B))
        {
            low = mid + 1;            
        }
        else
        {
            high = mid - 1;
        }
    }

    return high;

    }

    public boolean check(int subArraySize,long[] prefixSum,int B)
    {
        int start = 0;
        int end = subArraySize;
        while(end < prefixSum.length)
        {
            long sum = prefixSum[end] - prefixSum[start];
            if(sum > B)
            {
                return false;
            }
            else
            {
                start++;
                end ++;
            }
        }
        return true;
    }
    
}
