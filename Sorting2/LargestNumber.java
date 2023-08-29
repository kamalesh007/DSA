// Given an array A of non-negative integers, arrange them such that they form the largest number.

// Note: The result may be very large, so you need to return a string instead of an integer.

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {
        int[] arr = new int[A.length];
        for(int i = 0 ; i < A.length ; i++)
        {
            arr[i] = A[i]; // Shallow copy 
        }
        quicksort(arr,0,A.length-1);
        String ans ="";

        for(int i = A.length-1 ; i >=0 ; i -- )
        {
            ans = String.valueOf(arr[i])+ans;
        }

        int i = 0;       
        while(i < ans.length()-1  && ans.charAt(i) == '0')
        {
            i ++;
        }


        return ans.substring(i);
    }

    public void quicksort(int[] arr,int start, int end)
    {
        if(start >= end)
        {
            return;
        }
        int partitionIndex = quickPartition(arr,start,end);
        quicksort(arr,start,partitionIndex-1);
        quicksort(arr,partitionIndex+1,end);
    }

    public boolean compare(long first,long second)
    {
        String f = String.valueOf(first);
        String s = String.valueOf(second);
        long fs = Long.valueOf(f+s);
        long sf= Long.valueOf(s+f);
        return fs >  sf;
       
    }

    public int quickPartition(int[] arr,int start,int end)
    {
        int pivot = arr[end];
        long pivotL = Long.valueOf(pivot);        
        int i = start;
        for(int j = start ; j <= end-1 ; j++)
        {
            long ele = Long.valueOf(arr[j]);

            if(compare(ele,pivot))
            {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                i++;
            }
        }

        int swap = arr[end];
        arr[end] = arr[i];
        arr[i] = swap;
        return i;
    }
 
}
