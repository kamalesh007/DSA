
// Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

// Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();

        int mod = 1000000000+7;

        long count = 0;

        int i = 0; // lftPtr

        int j = A.length-1; // rightPtr

        for(int itr=0;itr<=j;itr++)
        {
            if(freqMap.containsKey(A[itr]))
            {
                int fre = freqMap.get(A[itr]);
                freqMap.put(A[itr],fre+1);
            }
            else
            {
                 freqMap.put(A[itr],1);
            }

        }

        while(i<j)
        {
            if((i>0) && (A[i]==A[i-1]))
            {
                i++;
                continue;
            }
            int sum = ((A[i]% mod )+ (A[j]% mod) % mod);

            if(sum < B)
            {
                i++;
            }
            else if(sum > B)
            {
                j--;
            }
            else
            {
                
                if(A[i] == A[j])
                {

                    long freq=(long)freqMap.get(A[i]);
                    freq = (freq * (freq - 1)) / 2;
                    freq = freq % mod;
                    //int contribution = ((freq % mod) * ((freq - 1)%mod) % mod) / 2;
                    count += freq;
                    count = count % mod ;
                }
                else
                {
                    long freq = (long)freqMap.get(A[i]);

                    long frq1 = (long) freqMap.get(A[j]);

                    long contribution = (freq * frq1)% mod;
                    //int contribution= (((freqMap.get(A[i]) % mod) * (freqMap.get(A[j]) % mod)) % mod);
                    count += contribution;
                     count = count % mod ;
                } 
                i++;                               
            }
        }
        return (int)count ;

    }
}
