// Given a positive integer A.

// Return the number of ways it can be written as a sum of consecutive positive integers.

public class Solution {
    public int solve(int A) {
    int count = 1;

    // Finding max number of ways 

    int i = 0;

    int maxWays = 0;

    if(A == 1)
    {
        return 1;
    }

    while((maxWays*maxWays)+maxWays <= 2*A)
    {
        maxWays++;
    }
   // System.out.print(maxWays+"\t");
    for(int N = 2 ; N <= maxWays ; N++)
    {
        boolean flag = (2*A % N) == 0;
        flag = flag && ((2*A)/N) - N + 1 > 0 && (((2*A)/N) - N + 1) % 2 == 0;
        //System.out.print(flag+"for N:"+N+"\t");
        if(flag)
        {
            count++;
        }
    }
    return count;
    }
}
