// Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.

// Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

// NOTE:

// Rows are numbered from top to bottom, and columns are numbered from left to right.
// The sum may be large, so return the answer mod 109 + 7.
// Also, select the data type carefully, if you want to store the addition of some elements.
// Indexing given in B, C, D, and E arrays is 1-based.
// Top Left 0-based index = (B[i] - 1, C[i] - 1)
// Bottom Right 0-based index = (D[i] - 1, E[i] - 1)

public class Solution {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int[] ans=new int[B.length];
        
        long[][] ps=new long[A.length+1][A[0].length+1];
        
        long mod=1000000007;
        
        for(int i=1;i<ps.length;i++)
        {
            for(int j=1;j<ps[i].length;j++)
            {
                ps[i][j]=(long)(A[i-1][j-1])+ps[i][j-1]+ps[i-1][j]-ps[i-1][j-1];
            }
        }        
        for(int i=0;i<B.length;i++)
        {
            int r1=B[i];
            int c1=C[i];
            int r2=D[i];
            int c2=E[i];
            
            long var1=ps[r2][c2]-ps[r2][c1-1]-ps[r1-1][c2]+ps[r1-1][c1-1];
            var1=var1%mod;
            var1=(var1+mod)%mod;
            ans[i]=(int)var1;
            
        }
        return ans;
    }
}
