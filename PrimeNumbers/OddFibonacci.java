
// You are given two integers A and B, representing an interval [A, B].

// Fibonacci sequence is a sequence whose definition is as follows:

// F[1] = 1 , F[2] = 1

// F[i] = F[i-1] + F[i-2] for i > 2

// Your task is to find the count of integers x in the range [A, B] such that F[x] is odd.
public class Solution {
    public int solve(int A, int B) {
       // return (B-A+1)-((B/3)-((A-1)/3));

       return ((( B / 3 ) * 2) + (B % 3)) - ((( (A- 1) / 3 ) * 2) + ((A-1) % 3));
    }
}
