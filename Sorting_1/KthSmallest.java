public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        
        for(int i=0;i<B;i++)
        {
            int min=Integer.MAX_VALUE;
            int minIndex=i;
            for(int j=i;j<A.length;j++)
            {
                if(A[j]<min)
                {
                   min=A[j];
                   minIndex=j;
                }
            }
            if(minIndex!=i)
            {
                //swap
                int temp=A[i];
                A[i]=A[minIndex];
                A[minIndex]=temp;
            }
        }
        return A[B-1];
        
        
        
    }
}
