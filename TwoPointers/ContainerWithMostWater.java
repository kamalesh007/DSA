// Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).

// N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

// Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container

public class Solution {
    public int maxArea(int[] A) {
        int ans = 0;        
        int i = 0;
        int j = A.length - 1;
        while(i < j)
        {
            if(A[i] <= A[j])
            {
                //Discard i because we have maximized our ans for i;
                int res = (j-i)* A[i];
                i++;
                ans = Math.max(ans,res);
            }
            else
            {
                 int res = (j-i)* A[j];
                 ans = Math.max(ans,res);
                 j--;
            }
        }
        return ans;
    
    }
}
