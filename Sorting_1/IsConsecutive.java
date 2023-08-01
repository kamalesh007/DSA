public class Solution {
    public int solve(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < A.length ; i++)
        {
            min = Math.min(A[i],min);
            max = Math.max(A[i],max);
        }

        int numberOfElements = max - min + 1;

        if(numberOfElements > 100000)
        {
            return 0;
        }
        
        if(numberOfElements != A.length)
        {
            return 0;
        }

        int[] arr = new int[numberOfElements];

        for(int i = 0 ; i < A.length;i++)
        {
            int hash = A[i] - min;
            if(hash >= numberOfElements)
            {
                return 0;
            }
            arr[hash] ++;
        }
        for(int i = 0 ; i < arr.length;i++)
        {
            if(arr[i]==0) // If some elements are not filled then error
            {
                return 0;
            }
        }
        return 1;


        
    }
}
