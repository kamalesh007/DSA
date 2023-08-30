// Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.

// The first stair would require only one block, and the second stair would require two blocks, and so on.

// // Find and return the maximum height of the staircase.

public class Solution {
    public int solve(int A) {
    
    int low = 1;
    int high = A;

    while(low <= high)
    {
        int mid = low + (high - low)/2;
        long temp = (Long.valueOf(mid)* (mid+1))/2;
        if(temp > A)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return high;

    
    }
}
