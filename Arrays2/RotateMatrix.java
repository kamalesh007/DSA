// You are given a n x n 2D matrix A representing an image.

// Rotate the image by 90 degrees (clockwise).

// You need to do this in place.

// Note: If you end up using an additional array, you will only receive partial score.
public class Solution {
    public void solve(int[][] A) {
        // Do transpose and reverse each row
        int n=A.length;
        int startRow=0;
        int startSize=1;
        while(startSize<=n && startRow<=n-1)
        {
            for(int i=0;i<startSize;i++)
            {
                //swap A[startRow][i] to A[i][startRow]
                int temp=A[startRow][i];
                A[startRow][i]=A[i][startRow];
                A[i][startRow]=temp;
            }
            startSize++;
            startRow++;
        }
        for(int i=0;i<n;i++)
        {
            int start=0;
            int end=n-1;
            while(start<end)
            {
                int temp=A[i][start];
                A[i][start]=A[i][end];
                A[i][end]=temp;
                start++;
                end--;
            }
        }
        
    }
}
