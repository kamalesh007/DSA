// Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.

// Since the number of subarrays could be large, return value % 109 +7.
public class Solution {
    public int solve(int[] A) {
    int mod = 1000000000+7;
    int[] hashArr = new int[1000000+1];    
    int i = 0;
    int j = -1;
    long count = 0L;
    while((j+1)<A.length)
    {
        if(hashArr[A[j+1]] == 0)
        {
            hashArr[A[j+1]] ++;
            j++;
        }
        else if(hashArr[A[j+1]]!=0)
        {
            long contribution = (j - i + 1);
            count = (count + contribution)% mod;
            
            hashArr[A[i]] --;
            i++;
        }        

    }
    
    while(i <= j)
    {
        long contribution = (j - i + 1);
        count = (count + contribution)% mod;
        i++;
    }
    return (int)(count%mod);

    }
}
