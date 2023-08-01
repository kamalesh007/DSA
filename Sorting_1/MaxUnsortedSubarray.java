public class Solution {
    public int[] subUnsort(int[] A) {
        int minDip=Integer.MAX_VALUE;
        int minDipIndex=Integer.MAX_VALUE;
        int right = 0;
        for(int i=0;i<A.length-1;i++)
        {
            if(A[i]<=A[i+1])
            {
                continue;
            }
            else
            {
                minDip = Math.min(minDip,A[i+1]);                
            }
        }

        if(minDip == Integer.MAX_VALUE)
        {
            return new int[]{-1};
        }

        for(int i=0;i<A.length;i++)
        {
            if(A[i]>minDip)
            {
                minDipIndex = i;
                break;
            }
        }
        int maxHill=Integer.MIN_VALUE;

        for(int i=A.length-1;i>0;i--)
        {
            if(A[i-1]<=A[i])
            {
                continue;
            }
            else
            {
                maxHill = Math.max(maxHill,A[i-1]);
            }

        }

        for(int i=A.length-1;i>=0;i--)
        {
            if(maxHill > A[i])
            {
                right = i;
                break;
            }
        }

        if(right == 0 )
        {
            return new int[]{-1};
        }
        else
        {
            return new int[]{minDipIndex,right};
        }
    }
}
