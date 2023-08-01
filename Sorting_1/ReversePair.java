/*

Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.

Note :
Follow 0-based indexing, while returning the sub-array's starting and ending indexes.

*/



public class Solution {
    
    public int ans;
    public int solve(int[] A) {
        return mergeSort(A,0,A.length-1);
        //return findReversePair(A,0,0,1);
    }

    public int findReversePair(int[] A,int start,int mid,int end)
    {
        int count = 0;
        int[] left = new int[mid-start+1];
        int[] right = new int[end-(mid+1)+1];        
        for(int i = start ; i <= mid ; i++)
        {
            left[i-start]=A[i];
            //System.out.print(left[i-start]+"\t");
        }
        for(int i = mid+1 ; i <= end ; i++)
        {
            right[i-(mid+1)] = A[i];
            //System.out.print(right[i-(mid+1)]+"\t");
        }

        int i = 0;
        int j = 0;

        while( (i < left.length) && (j < right.length))
        {            
            long rightEle = Long.valueOf(right[j]) << 1L;
            //System.out.print(rightEle+"\t");
            long leftEle = left[i];
            //System.out.print(leftEle+"\t");
            if(leftEle > rightEle)
            {
                
                count += (left.length-1-i+1);
                j++;
                //System.out.print(count+"\t");
            }
            else
            {
                i++;
            }
        }
        return count;        


    }

    public int mergeSort(int[] A , int start, int end)
    {
        if(start >= end )
        {
            return 0;
        }

        int mid = start + ((end - start)/2);

        int leftReversePair = mergeSort(A,start,mid);
        //System.out.print(leftReversePair+"\t");
        int rightReversePair = mergeSort(A,mid+1,end);
        //System.out.print(rightReversePair+"\t");
        int MergedLeftRightReversePair = findReversePair(A,start,mid,end);
        //System.out.print(MergedLeftRightReversePair+"\t");
        int reversePairCount = leftReversePair + rightReversePair + MergedLeftRightReversePair;
        merge(A,start,mid,end);
        return reversePairCount;
    }

    public void merge(int[] A,int left,int mid,int right)
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
                //count = (count%mod) + ((N1-1-lPtr+1)%mod);                                
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

    } 


}
