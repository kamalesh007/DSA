// Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
// You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

// Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
// NOTE:
// 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
// 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

// Return the ans % 10000003.



public class Solution {
    public int mod;
    public int paint(int A, int B, int[] C) {
        mod = 10000003;
        long low = 0L;
        long high = 0L;
        for(int i = 0 ; i < C.length; i++)
        {
            low = Math.max(low,(long)C[i] * B);
            high = high + (C[i]);
        }
        high = (high * B);               
        long ans = 0L;

        /*
            Decreasing monotonuos function

            time ---> low - high ;

            Painter ---> high - low ;

            Min time when A number of painters possible 

            search space:  low time     okayTime
            time --->>> painters more | painters less than or equal to 
                                 high   low
            
        */

        while(low <= high) // Decreasing monotonuos 
        {
            long mid = (low + ((high - low)/2)); // Guess mid Time
            boolean paintersForCurMid = minPainterForTime(C,B,mid,A);            
            if(!paintersForCurMid)
            {
                low = mid + 1;
            }          
            else
            {                
                high = mid - 1;
            }
        }
        return (int)(low % mod);
    }


    public boolean minPainterForTime(int[] C,int B,long time,int A)
    {
        int painters = 1;
        long sum = 0;
        for(int i = 0 ; i < C.length ;i ++)
        {
            if((long)C[i] * B > time) return false;
            sum = sum + ((long)C[i] * B );
            if(sum <= time)
            {
                continue;
            }
            else
            {
                painters ++;
                sum = (long)C[i] * B;
            }
        }
        return painters <= A ;
    }
    
}
