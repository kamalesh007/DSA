// You are given two positive numbers A and B . You need to find the maximum valued integer X such that:

// X divides A i.e. A % X = 0
// X and B are co-prime i.e. gcd(X, B) = 1
public class Solution {
    public int cpFact(int A, int B) {
    
    int gcd = gcdUtil(A,B);

    while(gcd != 1)
    {
        A = A / gcd ; 
        gcd = gcdUtil(A , B);
    }
    
    return A;

    }

    int gcdUtil(int A,int B)
    {
        if(A == 0)
        {
            return B;
        }
        return gcdUtil(B%A,A);
    }
}
