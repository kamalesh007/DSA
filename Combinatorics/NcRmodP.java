// Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

// x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

// NOTE: For this problem, we are considering 1 as a prime.
public class Solution {
    public int solve(int A, int B, int C) {
        
        long nf = fact(A,C);
        long rf = fact(B,C);
        long nrf = fact(A-B,C);

        //System.out.print(nf+"\t"+rf+"\t"+nrf+"\t");
                        
        long modIRF = fastPower(rf,C-2,C);

        long modINRF = fastPower(nrf,C-2,C);

        long tempAns = (modINRF * modIRF ) % C;
        tempAns = (tempAns * nf)%C;

        return (int)tempAns;
    
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

    public long fact(long N,long P)
    {
        long ans = 1;
        for(long i =1;i<=N;i++)
        {
            ans = (ans * i) % P;
        }
        return ans;
    }
    
}
