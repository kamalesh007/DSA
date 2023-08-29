// Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

// Note: It is possible to swap any two elements, not necessarily consecutive.
public class Solution {
    public int solve(int[] A, int B) {
        int ans = Integer.MAX_VALUE;
        int countLessThanB = 0;
        for(int i =0 ;i<A.length ;i ++)
        {
            if(A[i]<=B)
            {
                countLessThanB ++;
            }
        }
        int swaps = countLessThanB;
        if(countLessThanB == A.length)
        {
            return 0;
        }
        for(int i = 0 ; i < countLessThanB ; i++)
        {
            if(A[i]<= B)
            {
                swaps --;
            }
        }

        for(int i=1; i <= A.length - countLessThanB ; i++)
        {
            int j = countLessThanB - 1 + i;

            if(A[i-1] > B)
            {
                swaps --;
            }
            if(A[j] > B)
            {
                swaps++;
            }

            ans = Math.min(ans,swaps);            
        }
        return ans;
    }
}
