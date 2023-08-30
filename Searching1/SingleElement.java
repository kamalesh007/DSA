// Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

// Elements which are appearing twice are adjacent to each other.

// NOTE: Users are expected to solve this in O(log(N)) time.

public class Solution {
    public int solve(int[] A) {
        int l=0;
        int h=A.length-1;
        
        while(l<=h)
        {
            int m=l+((h-l)/2);
            if(m>0 && A[m-1]==A[m])
            {
                m--;
            }
            if(m%2==0)
            {
                l=m+2;
            }
            else
            {
                h=m-1;
            }
        }
        return A[h];
    }
}
