public class Solution {
   

   public int mod = 1000000007;
   // public int count;
    public int solve(int[] A) {
        return mergeSort(A,0,A.length-1,0);
    }  

    public int merge(int[] A,int left,int mid,int right)
    {
        int count= 0;
        int N1= mid-left+1;
        int N2=right - (mid+1) + 1;
        int[] leftArr = new int[N1];
        int[] rightArr =new int[N2];
        int lPtr,rPtr;
        lPtr=0;
        rPtr=0;
        for(int i=left;i<=mid;i++)
        {
            leftArr[lPtr++]=A[i];
        }
        for(int i=mid+1;i<=right;i++)
        {
            rightArr[rPtr++]=A[i];
        }
        lPtr=0;
        rPtr=0;
        int index=left;
        while(lPtr < N1 && rPtr < N2)
        {
            if(leftArr[lPtr] <= rightArr[rPtr])
            {
                A[index++]=leftArr[lPtr++];
            }
            else
            {
                A[index++]= rightArr[rPtr++];
                count = (count%mod) + ((N1-1-lPtr+1)%mod);                                
            }
        }
        while(lPtr < N1)
        {
            A[index++]=leftArr[lPtr++];
        }
        while(rPtr< N2)
        {
            A[index++]=rightArr[rPtr++];   
        }
        return count;

    }  

    public int mergeSort(int[]A,int left,int right,int globalCount)
    {        
        if(right - left + 1 == 1) // if number of terms == 1 then the array is already sorted
        {
          return 0;   
        }        
        else
        {
            int mid = ((right - left) / 2) + left ;
            int leftIC =  mergeSort(A,left,mid,globalCount);
            int rightIC = mergeSort(A,mid+1,right,globalCount);
            int count = (((leftIC%mod) + (rightIC%mod)+ (merge(A,left,mid,right)%mod)) %  mod);            
            globalCount = (globalCount%mod + count%mod) %mod;
        }

        return globalCount;
    }
    
    
    
    
    
    

}
