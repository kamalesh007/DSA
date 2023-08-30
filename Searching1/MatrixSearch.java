// Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

// This matrix A has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than or equal to the last integer of the previous row.
// Return 1 if B is present in A, else return 0.

// NOTE: Rows are numbered from top to bottom, and columns are from left to right.

public class Solution {
    public int searchMatrix(int[][] A, int B) {
   
        int noOfRows = A.length ;
        int noOfCols = A[0].length;

        int rowPtr = 0;
        int colPtr = noOfCols - 1;
   
        while(rowPtr >= 0 && rowPtr < noOfRows && colPtr >=0 && colPtr < noOfCols)
        {
            int ele = A[rowPtr][colPtr];

            if(ele == B)
            {
                return 1;
            }
            else if(B < ele)
            {
                colPtr --;
            }
            else
            {
                rowPtr ++;
            }
        }
        return 0;

    }
}
