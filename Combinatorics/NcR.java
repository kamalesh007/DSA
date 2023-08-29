// Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.

// x! means factorial of x i.e. x! = 1 * 2 * 3... * x

public class Solution {
    public int solve(int A, int B, int C) {
        int[][] combArr=new int[A+1][B+1];
        for(int i=0;i<A+1;i++)
        {
            for(int j=0;j<=Math.min(i,B);j++)
            {
                if(i==j || j==0)
                {
                    combArr[i][j]=1;
                }
                else
                {
                    combArr[i][j]=(combArr[i-1][j]+combArr[i-1][j-1])%C;
                }
            }
        }
        return combArr[A][B]%C;
    }
}
