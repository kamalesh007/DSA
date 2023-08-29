// Divide two integers without using multiplication, division and mod operator.

// Return the floor of the result of the division.

// Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

// NOTE: INT_MAX = 2^31 - 1

public class Solution {
    public int divide(int A, int B) {
    
    long lA = Long.valueOf(A);

    long lB = Long.valueOf(B);

    
    boolean sign = true ; //true both same sign ; false different sign

    sign = (lA < 0 ^ lB < 0);

    sign = !sign;


    long ans = 0L;

    lA = Math.abs(lA);   

    lB = Math.abs(lB);

    //System.out.print(sign+"\t");

    for(int i = 31; i >= 0 ; i--)
    {
        if( lB << i <= lA)
        {
            lA  -= (lB << i);
            ans += (long)1 << i;
        }
    }

    //System.out.print(ans+"\t");

    if(!sign)
    {
        ans = -ans;
    }

    if(ans > Integer.MAX_VALUE)
    {
        return Integer.MAX_VALUE;
    }
    else
    {
        return (int)ans;
    }
        
    }
}
