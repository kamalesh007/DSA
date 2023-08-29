public class Solution {
    public int solve(int[][] A) {
        int sum=0;
        int n=A.length;
        int m=A[0].length;
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A[i].length;j++)
            {
                sum+=(((i+1)*(n-i)*(j+1)*(m-j)) *A[i][j]);
            }
        }
        return sum;
    }
}
