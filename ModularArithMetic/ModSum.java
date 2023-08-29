// Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.
public class Solution {
    public int solve(int[] A) {
        int[] frequencyArray=new int[1001];
        int ans=0;
        int mod=1000000000+7;        
        for(int i=0;i<=1000;i++)
        {
            frequencyArray[i]=0;
        }
        for(int i=0;i<A.length;i++)
        {
            frequencyArray[A[i]]++;
        }
        for(int i=1;i<=1000;i++)
        {
            for(int j=1;j<=1000;j++)
            { 
                if(frequencyArray[i]!=0 && frequencyArray[j]!=0)
                {                   
                    int contribution = (i % j) * (frequencyArray[i] * frequencyArray[j]);
                    ans = ((ans % mod )+ (contribution % mod))% mod;
                    
                }                
            }
        }
        return ans;
   
   }
}
