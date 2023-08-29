// Given a matrix B, of size N x M, you are allowed to do at most A special operations on this grid such that there is no vertical or horizontal contiguous subarray that has a sum greater than C.

// A special operation involves multiplying any element by -1 i.e. changing its sign.

// Return 1 if it is possible to achieve the answer, otherwise 0.

public class Solution {
   
    // Code have to dry run once to understand the return statements
    public int[][] arr;
    public int sumAllowed;
    public int solve(int A, int[][] B, int C) {
        arr = B ;
        sumAllowed = C ;
        return traverse(A);
    }

    public int traverse(int A)
    {
        if(A == -1)
        {
            return 0;
        }
        int ret = 1;

        for(int i = 0 ; i < arr.length; i++)
        {
            for(int j = 0 ; j < arr[0].length ; j++)
            {
                int sum = 0;

                for(int k = j ; k < arr[0].length ; k++)
                {
                    sum += arr[i][k];
                    if(sum > sumAllowed )
                    {
                        ret = 0;
                        for(int x = j ; x <= k ; x++)
                        {
                            arr[i][x] = -arr[i][x];
                            ret = ret | traverse(A-1);                                                       
                            arr[i][x] = - arr[i][x];
                        }
                        return ret;
                    }

                }
            }

        }

        for(int j = 0 ; j < arr[0].length ; j++)
        {
            for(int i = 0 ; i < arr.length ; i++)
            {
                int sum = 0;
                for(int k = i ; k < arr.length ; k++)
                {
                    
                    sum += arr[k][j];
                    if(sum > sumAllowed)
                    {
                        ret = 0;
                        for(int x = i ; x <= k ; x++)
                        {
                            arr[x][j] = -arr[x][j];
                            ret = ret | traverse(A-1);                                                        
                            arr[x][j] = - arr[x][j];
                        }
                        return ret;
                    }
                }
            }
        }
        return ret;
    }
}
