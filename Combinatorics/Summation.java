// Given an integer A.

// Calculate the sum = (ACr) * (r) * (r - 1) * (2r-2) for all r from 0 to A.

// Return sum % 109 + 7

public class Solution {
    public int solve(int A) {    
       long binomial = fastPower(3,Long.valueOf(A-2),1000000007);
       binomial = (binomial * (A-1)) % 1000000007;
       binomial = (binomial * (A)) % 1000000007;

       return (int) binomial;
       
    }


    public long fastPowerRecursion(long a,long b,long m)
    {        
        if(b == 1)
        {
            return a % m;
        }
        else if(b % 2 == 0)
        {
            a = (a * a)%m;
            b = b / 2;
            return fastPowerRecursion(a,b,m);
        }
        else
        {
            //a = (a * a)%m; Wrong Trace once you will know
            b = b / 2;
            return (a*fastPowerRecursion((a*a)%m,b,m))%m;
        }
    }

    public int fastPower(long a,long b,long m)
    {
        long ans = 1L;

        while(b > 0)
        {
            if(b % 2 == 0) //Even
            {
                a = (a*a)%m;
                b =b/2;                
            }
            else
            {                
                
                ans = (ans * a) % m;               
                a = (a*a)%m;
                b =b/2;  
                
            }
        }
        return (int)(ans%m);
    }
}
