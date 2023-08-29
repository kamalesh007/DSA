// Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

// Find the maximum value of GCD.
public class Solution {
    public int solve(int[] A) {
        int ans=0;
        int[] prefixGCD=new int[A.length+1];
        prefixGCD[0]=0;
        int[] suffixGCD=new int[A.length+1];
        suffixGCD[A.length]=0;
        for(int i=1;i<prefixGCD.length;i++)
        {
            prefixGCD[i]=this.GCD(prefixGCD[i-1],A[i-1]);
        }
        for(int i=A.length-1;i>=0;i--)
        {
            suffixGCD[i]=this.GCD(suffixGCD[i+1],A[i]);
        }
        
        for(int i=0;i<A.length;i++)
        {
            ans=Math.max(ans,this.GCD(prefixGCD[i],suffixGCD[i+1]));
        }
        return ans;
    }
    
    public int GCD(int A,int B)
    {
        if(B==0)return A;
        return GCD(B,A%B);
    }
}
