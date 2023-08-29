// Scooby has 3 three integers A, B, and C.

// Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell the number of special integers less than or equal to A.
public class Solution {
    public int solve(int A, int B, int C) {
    
    int lcm = ( B * C ) / gcdUtil(B,C);

    return A / lcm;
    
    }

    public int gcdUtil(int A,int B)
    {
        if(A==0)
        {
            return B;
        }
        return gcdUtil(B%A,A);
    }
}
