// Given an array of integers A, find and return the count of divisors of each element of the array.

// NOTE: The order of the resultant array should be the same as the input array.

public class Solution {
    public int[] solve(int[] A) {
        int max=Integer.MIN_VALUE;
        int[] ans=new int[A.length];
        for(int i=0;i<A.length;i++)
        {
            if(A[i]>max)
            {
                max=A[i];
            }
        }
        int[] divArr=new int[max+1];
        for(int i=1;i<=max;i++)
        {
            divArr[i] = 2;   
        }
        divArr[0] = 0;
        divArr[1] = 1 ;
        for(int i=2;i<=(max/2);i++)
        {
            for(int j=2*i;j<=max;j=j+i)
            {
                divArr[j]++;
            }
        }
        for(int i=0;i<A.length;i++)
        {
            ans[i]=divArr[A[i]];   
        }
        return ans;
    }
}
