// Given a matrix of integers A of size N x M . There are 4 types of squares in it:

// 1. 1 represents the starting square.  There is exactly one starting square.
// 2. 2 represents the ending square.  There is exactly one ending square.
// 3. 0 represents empty squares we can walk over.
// 4. -1 represents obstacles that we cannot walk over.
// Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

// Note: Rows are numbered from top to bottom and columns are numbered from left to right.

public class Solution {
    public int rows;
    public int cols;
    public int sRow,sCol;
    public int eRow,eCol;
    public int ans;
    public int[] xI;
    public int[] yI;
    public int solve(int[][] A) {
        rows=A.length;
        cols=A[0].length;
        ans=0;
        int count0=0;
        xI=new int[]{1,0,0,-1};   // D,L,R,U Row
        yI=new int[]{0,-1,1,0};     //col
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(A[i][j]==1)
                {
                    sRow=i;
                    sCol=j;
                }                
                else if(A[i][j]==0)
                {
                    //Count the number of zeros
                    count0++;
                }
            }
        }
        
        findPaths(sRow,sCol,A,count0+1);
        return ans;

    }


    public boolean isValid(int[][] X,int row,int col)
    {
        return row >=0 && row < rows && col >=0 && col <cols && X[row][col]!=-1;
    }

    public void findPaths(int row,int col,int[][] A,int countZ)
    {
        
        //System.out.print(row+":"+col+", ");
        if(A[row][col]==2)
        {
            if(countZ==0)
            {
                ans++;
            }
            return ;
        }
        A[row][col]=-1;

        for(int i=0;i<4;i++)
        {
            int tempRow = row + xI[i];
            int tempCol = col +yI[i];

            if(isValid(A,tempRow,tempCol))
            {
                findPaths(tempRow,tempCol,A,countZ-1);
            }
        }
        A[row][col]=0;
    }
}
