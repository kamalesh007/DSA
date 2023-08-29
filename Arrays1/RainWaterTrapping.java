//Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int ans=0;
        int[] R=new int[A.length];
        int[] L=new int[A.length];
        R[A.length-1]=A[A.length-1];
        for(int i=A.length-2;i>=0;i--)
        {
            R[i]=Math.max(R[i+1],A[i]);
        }
        L[0]=A[0];
        for(int i=1;i<A.length;i++)
        {
            L[i]=Math.max(A[i],L[i-1]);
        }
        for(int i=0;i<A.length;i++)
        {
            ans+=(Math.min(R[i],L[i])-A[i]);
        }
        return ans;
    }
}
