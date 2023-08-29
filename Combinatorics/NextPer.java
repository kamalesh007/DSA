// Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

// If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

// NOTE:

// The replacement must be in-place, do not allocate extra memory.
// DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.


public class Solution {
    public int[] nextPermutation(int[] A) {
        int nonDecreasingIndex = -1;
        for(int i = A.length - 1 ; i > 0 ; i--)
        {
            if(A[i-1]>=A[i])
            {
                continue;
            }
            else
            {
                nonDecreasingIndex = i-1;
                break;
            }
        }
        
        if(nonDecreasingIndex == -1)
        {
            int start = 0;
            int end = A.length-1;

            while(start<end)
            {
                int temp1 = A[start];
                A[start] = A[end];
                A[end] = temp1;
                start++;
                end --;
            }
            return A;
        }

        int j = nonDecreasingIndex + 1;

        while(j < A.length)
        {
            if(A[j]<=A[nonDecreasingIndex])
            {
                j--;
                break;
            }
            else
            {
                j++;
            }

        }
        if(j == A.length)
        {
            j--;
        }

        int temp = A[nonDecreasingIndex];
        A[nonDecreasingIndex] = A[j];
        A[j] = temp;

        int start = nonDecreasingIndex+1;
        int end = A.length-1;

        while(start<end)
        {
             int temp1 = A[start];
            A[start] = A[end];
            A[end] = temp1;
            start++;
            end --;
        }
        return A;


        
   
    }
}
