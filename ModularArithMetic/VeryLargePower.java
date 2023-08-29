// Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

// "^" means power,
// "%" means mod, and
// "!" means factorial.

// Note: Ensure to handle integer overflow when performing the calculations.
public class Solution {
    public int solve(int A, int B) {
        long m=1000000007;// this is prime;
        long b=1;
        for(int i=1;i<=B;i++)
        {
            b=(b*i)%(m-1);
        }
        long a=Long.valueOf(A);
        long res=1;
        while(b!=0)
		{
			if(b%2==0)
			{
				b=b/2;
				a=(a*a)%m;				
			}
			else
			{				 
				res=(res*a)%m;
				a=(a*a)%m;
				b=b/2;
			}
		}
		
		return ((int)(res%m));
		
    }

    public long fastPower(long a, long b,long m)
    {
        if(b == 0)
        {
            return 1;
        }
        if(b == 1)
        {
            return a % m;
        }

        if( (b%2) == 0) // EVEN
        {
            long tempA = (a*a)%m;
            b = b / 2;
            return fastPower(tempA,b,m);
        }
        else
        {
            long tempA = (a*a)%m;
            b = b / 2;
            long tempAns = a * fastPower(tempA,b,m);
            return (tempAns % m);
        }
    }
}
