// Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

// Assume that there will only be one solution.


public class Solution {
    public int threeSumClosest(int[] A, int B) {
        int prevAbs = Integer.MAX_VALUE;
        Arrays.sort(A);
        int ans = 0;
        int i = 0;
        int j = A.length - 1;
        int N = j + 1;

        for(int k = 0 ; k < A.length - 2 ; k++)
        {
            int sumToFind = B - A[k];
             i = k + 1;
             j = A.length - 1 ;

            while( i < j)
            {
                int sum = A[i]+A[j];
                //System.out.print(sum +"\t"+sumToFind);
                if(sum == sumToFind)
                {
                    ans = B;
                    break;                                       
                }
                else if(sum < sumToFind)
                {
                    int abs = Math.abs(sum-sumToFind);
                    if(abs < prevAbs)
                    {
                        prevAbs = abs ;
                        ans = A[i]+A[j]+A[k];
                    }
                    i++;
                }
                else
                {
                    int abs = Math.abs(sum-sumToFind);
                    if(abs < prevAbs)
                    {
                        prevAbs = abs ;
                        ans = A[i]+A[j]+A[k];
                    }
                    
                    j --;
                }
                
            }
            if(ans == B)
            {
                break;
            }


        }
        return ans;
        
        
    }
}
