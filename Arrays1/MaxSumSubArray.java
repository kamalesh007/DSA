//Find the maximum sum of contiguous non-empty subarray within an array A of length N.
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int curSum=0;        
        int maxSum=Integer.MIN_VALUE;
        int L=0;
        int anyOneIndex=0;
        for(int i=0;i<A.length;i++)
        {
            curSum+=A[i];            
            if(curSum>maxSum)
            {
                maxSum=curSum;
                anyOneIndex=i;
            }
            if(curSum<0)
            {
                
                curSum=0;
            }
        }
        //System.out.println(L+" "+anyOneIndex);
        return maxSum;
    }
}
