// Given an array of integers A, find and return the peak element in it.
// An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

// NOTE:

// It is guaranteed that the array contains only a single peak element.
// Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

public class Solution {
    public int solve(int[] A) {
        int N = A.length;
        int l = 0 ;
        int h = N - 1;

        while(l <= h)
        {
            int mid = (l+h)/2;

           // (mid == 0 || A[mid] > A[mid-1])  && ( mid == N -1 || A[mid] > A[mid + 1])

            if((mid == 0 || A[mid] >= A[mid-1])  && ( mid == N -1 || A[mid] >= A[mid + 1]))
            {
                return A[mid];
            }

            if(mid == 0 || A[mid] < A[mid+1])
            {
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }
        return -1;
    }
}
