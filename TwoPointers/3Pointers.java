// You are given 3 sorted arrays A, B and C.

// Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

// Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
    
    int ans = Integer.MAX_VALUE;
    int i = 0 ;
    int j = 0;
    int k = 0;

    while( i < A.length && j < B.length && k < C.length )
    {
        int part_1 = Math.abs(A[i] - B[j]);
        int part_2 = Math.abs(B[j] - C[k]);
        int part_3 = Math.abs(C[k] - A[i]);

        int max = Math.max(Math.max(part_1,part_2),part_3);
        if(max < ans)
        {
            ans = max;
        }

        if(part_1 >= part_2 && part_1 >= part_3)
        {
            if(A[i] <= B[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        else if(part_2 >= part_1 && part_2 >= part_3)
        {
            if(B[j] <= C[k])
            {
                j++;
            }
            else
            {
                k++;
            }
        }
        else
        {
            if(A[i] <= C[k])
            {
                i++;
            }
            else
            {
                k++;
            }
        }

    }
    return ans;
    
    }
}
