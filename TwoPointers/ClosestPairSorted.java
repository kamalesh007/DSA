
// Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.

// More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.

// If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.

// Return an array with two elements {A[i], B[j]}.

public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
    
    int indexI = 10000000;

    int indexJ = 10000000;

    int[] ans = new int[2];

    int diff = Integer.MAX_VALUE;

    int i = 0;

    int j = B.length - 1;

    while(i < A.length && j < B.length && j >=0 && i>=0)
    {
        int absValue = Math.abs(A[i] + B[j] - C);
        //System.out.print(absValue+"\t");
        if(absValue < diff || (absValue == diff && i <= indexI && j < indexJ))
        {            
            ans[0] = A[i];
            ans[1] = B[j];
            diff = absValue;
            indexJ = j;
            indexI = i;
        }        
        
        if(A[i] + B[j] > C)
        {
            j -- ;
        }
        else if(A[i] + B[j] < C)
        {
            i ++;
        }
        else
        {
            i ++;
            j--;
        }

    }
    return ans;
    
    }
}
