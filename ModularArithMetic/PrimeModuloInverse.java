
// Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.

// A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
public class Solution {
    public int solve(int A, int B) {
       long a=A;
       long b=B-2;
       long m=B;
       long res=1;
       while(b>0)
       {
           if(b%2==0)
           {
               b=b/2;
               a=(a*a)%m;
           }
           else
           {
               res=(res*a)%m;
               b=b/2;
               a=(a*a)%m;
           }
       }
        return (int)res;
    }
}
