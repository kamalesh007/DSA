// Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.

// (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
public class Solution {
    public int solve(int[] A, int B) {
         int leftPtr = 0;
         int rightPtr = A.length - 1;
         int mod = 1000000000+7;
         int count = 0;

         int N = rightPtr + 1;
         
         while(leftPtr <= rightPtr)
         {
             long product = (long)A[leftPtr] * (long)A[rightPtr];
             if(product < B)
             {
                 int contribution = (rightPtr - leftPtr  + 1) * 2 - 1;
                 count = (count + contribution) % mod;
                leftPtr++;
             }
             else
             {
                 rightPtr--;
             }
         }

         return count;


    }
}
