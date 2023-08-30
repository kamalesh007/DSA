// Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

// If the answer does not exist return an array with a single integer "-1".

// First sub-array means the sub-array for which starting index in minimum.

public class Solution {
    public int[] solve(int[] A, int B) {
        int[] prefixSum = new int[A.length+1];
        prefixSum[0]=0;
        for(int i=0;i<A.length;i++)
        {
            prefixSum[i+1]=prefixSum[i]+A[i];
        }        
        // P [j] - P[i-1] = B        
        int i = 0;
        int j = 0;
        int N = prefixSum.length ;
        while( j < N)
        {
            int diff = prefixSum[j] - prefixSum[i];
            if(diff == B)
            {
                int leftIndex = i;
                int rightIndex = j - 1;
                int[] ans = new int[rightIndex - leftIndex + 1];
                for(int k = 0;k < ans.length;k++)
                {
                    ans[k]=A[leftIndex++];
                }
                return ans;
            }
            else if(diff < B)
            {
                j++;
            }
            else
            {
                i++;
            }

        }
        return new int[]{-1};

    }
}
